package ru.vsu.dnlkkandco;

import org.antlr.v4.runtime.tree.TerminalNode;
import ru.vsu.dnlkkandco.gen.DnlkkRulesBaseVisitor;
import ru.vsu.dnlkkandco.gen.DnlkkRulesParser;

import java.util.ArrayList;
import java.util.List;

public class AstBuilderVisitor extends DnlkkRulesBaseVisitor<AstNode> {
    @Override
    public AstNode visitProgram(DnlkkRulesParser.ProgramContext ctx) {
        System.out.println("Stmts amount: " + ctx.stmt_list().stmt().size());
        List<AstNode> stmts = new ArrayList<>();
        for (DnlkkRulesParser.StmtContext stmtCtx : ctx.stmt_list().stmt()) {
            stmts.add(visitStmt(stmtCtx));
        }
        return new ProgramNode(stmts);
    }

    @Override
    public AstNode visitStmt(DnlkkRulesParser.StmtContext ctx) {
        if (ctx.definition() != null) return visitDefinition(ctx.definition());
        if (ctx.assign() != null) return visitAssign(ctx.assign());
        if (ctx.expr() != null) return visitExpr(ctx.expr());
        if (ctx.if_() != null) return visitIf(ctx.if_());
        if (ctx.while_() != null) return visitWhile(ctx.while_());
        if (ctx.for_() != null) return visitFor(ctx.for_());
        if (ctx.return_() != null) return visitReturn(ctx.return_());
        if (ctx.GOTO() != null) return new TerminalAstNode(ctx.GOTO().getText());
        throw new RuntimeException("Stmt doesn't contain any node!");
    }

    @Override
    public AstNode visitDefinition(DnlkkRulesParser.DefinitionContext ctx) {
        AstNode ident = new TerminalAstNode(ctx.assign().IDENT().getText());
        AstNode value =
                ctx.assign().expr() != null ?
                        visitExpr(ctx.assign().expr()) :
                        visitFun(ctx.assign().fun());
        return new BinOpNode("var", ident, value);
    }

    @Override
    public AstNode visitLogical(DnlkkRulesParser.LogicalContext ctx) {
        if (ctx.NOT_LOGICAL_OPERATOR() != null)
            return new UnaryOpNode("not", visitLogical(ctx.not_operand));
        if (ctx.LOGICAL_OPERATORS() != null) {
            String op = ctx.LOGICAL_OPERATORS().getText();
            AstNode left = visitLogical(ctx.left);
            AstNode right = visitLogical(ctx.right);
            return new BinOpNode(op, left, right);
        }
        return visitCompare(ctx.compare());
    }

    @Override
    public AstNode visitCompare(DnlkkRulesParser.CompareContext ctx) {
        if (ctx.add() != null)
            return visitAdd(ctx.add());
        return new BinOpNode(
                ctx.COMPARE().getText(),
                visitCompare(ctx.left),
                visitCompare(ctx.right)
        );
    }

    @Override
    public AstNode visitAdd(DnlkkRulesParser.AddContext ctx) {
        if (ctx.mult() != null)
            return visitMult(ctx.mult());
        return new BinOpNode(
                ctx.ADD().getText(),
                visitAdd(ctx.left),
                visitAdd(ctx.right)
        );
    }

    @Override
    public AstNode visitMult(DnlkkRulesParser.MultContext ctx) {
        if (ctx.unary() != null)
            return visitUnary(ctx.unary());
        return new BinOpNode(
                ctx.MULT().getText(),
                visitMult(ctx.left),
                visitMult(ctx.right)
        );
    }

    @Override
    public AstNode visitUnary(DnlkkRulesParser.UnaryContext ctx) {
        if (ctx.call() != null)
            return visitCall(ctx.call());
        if (ctx.unary_add_operand != null)
            return new UnaryOpNode(ctx.ADD().getText(), visitUnary(ctx.unary_add_operand));
        return new UnaryOpNode(ctx.MULT().getText(), visitUnary(ctx.unary_mult_operand));
    }

    @Override
    public AstNode visitCall(DnlkkRulesParser.CallContext ctx) {
        if (ctx.group() != null)
            return visitGroup(ctx.group());
        if (ctx.fun_object != null) {
            List<AstNode> args = new ArrayList<>();
            for (var arg : ctx.expr())
                args.add(visitExpr(arg));
            return new FunctionCallNode(visitCall(ctx.fun_object), args);
        }
        if (ctx.object != null) {
            AstNode object = visitCall(ctx.object);
            AstNode field = new TerminalAstNode(ctx.IDENT().getText());
            return new ObjectCallNode(object, field);
        }
        AstNode array = visitCall(ctx.array);

        AstNode expr = visitExpr(ctx.index);
        return new ArrayCallNode(array, expr);
    }

    @Override
    public AstNode visitGroup(DnlkkRulesParser.GroupContext ctx) {
        TerminalNode[] terms = {
                ctx.NULL(),
                ctx.UNDEFINED(),
                ctx.BOOL(),
                ctx.NUM(),
                ctx.DOUBLE(),
                ctx.STRING_LITERAL(),
                ctx.IDENT()};
        for (TerminalNode term : terms)
            if (term != null) return new TerminalAstNode(term.getText());

        if (ctx.expr() != null)
            return visitExpr(ctx.expr());
        if (ctx.object_literal() != null)
            return visitObject_literal(ctx.object_literal());
        if (ctx.fun() != null)
            return visitFun(ctx.fun());
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public AstNode visitFun(DnlkkRulesParser.FunContext ctx) {
        TerminalAstNode funIdent = ctx.fun_ident == null ? null : new TerminalAstNode(ctx.fun_ident.getText());
        List<AstNode> args = new ArrayList<>();
        for (int i = 1; i < ctx.IDENT().size(); i++)
            args.add(new TerminalAstNode(ctx.IDENT(i).getText()));

        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visitStmt(stmt));
        BlockNode body = new BlockNode(stmts);
        return new FunctionDefinitionNode(funIdent, args, body);
    }

    public AstNode visitField(DnlkkRulesParser.FieldContext ctx) {
        AstNode fieldName = new TerminalAstNode(ctx.IDENT().getText());
        AstNode value = ctx.expr() != null ? visitExpr(ctx.expr()) : visitFun(ctx.fun());
        return new FieldNode(fieldName, value);
    }

    @Override
    public AstNode visitObject_literal(DnlkkRulesParser.Object_literalContext ctx) {
        List<AstNode> fields = new ArrayList<>();
        for (var field: ctx.field()) {
            fields.add(visitField(field));
        }
        return new ObjectLiteralNode(fields);
    }
    public AstNode visitReturn(DnlkkRulesParser.ReturnContext ctx) {
        return new ReturnNode(visitExpr(ctx.expr()));
    }
    @Override
    public AstNode visitAssign(DnlkkRulesParser.AssignContext ctx) {
        AstNode variable = new TerminalAstNode(ctx.getText());
        AstNode value = ctx.expr() != null ? visitExpr(ctx.expr()) : visitFun(ctx.fun());
        return new AssignNode(variable, value);
    }

    @Override
    public AstNode visitWhile(DnlkkRulesParser.WhileContext ctx) {
        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visitStmt(stmt));
        BlockNode body = new BlockNode(stmts);
        return new WhileNode(visitExpr(ctx.expr()), body);
    }

    @Override
    public AstNode visitElse(DnlkkRulesParser.ElseContext ctx) {
        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visitStmt(stmt));
        BlockNode body = new BlockNode(stmts);
        return new ElseNode(body);
    }

    @Override
    public AstNode visitElif(DnlkkRulesParser.ElifContext ctx) {
        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visitStmt(stmt));
        BlockNode body = new BlockNode(stmts);
        return new ElifNode(visitExpr(ctx.expr()), body);
    }

    @Override
    public AstNode visitIf(DnlkkRulesParser.IfContext ctx) {
        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visitStmt(stmt));
        BlockNode body = new BlockNode(stmts);

        List<AstNode> elifs = new ArrayList<>();
        for (var elif: ctx.elif()) {
            elifs.add(visitElif(elif));
        }

        return new IfNode(visitExpr(ctx.expr()), body,
                elifs, visitElse(ctx.else_()));
    }

/* TODO: осталось реализовать
    array_literal : Паша сказал тут ошибка в грамматике
    for
*/
}
