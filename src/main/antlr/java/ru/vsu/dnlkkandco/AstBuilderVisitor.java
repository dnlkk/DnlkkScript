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
            stmts.add(visit(stmtCtx));
        }
        return new ProgramNode(stmts);
    }

    @Override
    public AstNode visitDefinition_stmt(DnlkkRulesParser.Definition_stmtContext ctx) {
        return visitDefinition(ctx.definition());
    }

    @Override
    public AstNode visitAssign_stmt(DnlkkRulesParser.Assign_stmtContext ctx) {
        return visitAssign(ctx.assign());
    }

    @Override
    public AstNode visitExpr_stmt(DnlkkRulesParser.Expr_stmtContext ctx) {
        return visitExpr(ctx.expr());
    }

    @Override
    public AstNode visitIf_stmt(DnlkkRulesParser.If_stmtContext ctx) {
        return visitIf(ctx.if_());
    }

    @Override
    public AstNode visitWhile_stmt(DnlkkRulesParser.While_stmtContext ctx) {
        return visitWhile(ctx.while_());
    }

    @Override
    public AstNode visitFor_stmt(DnlkkRulesParser.For_stmtContext ctx) {
        return visitFor(ctx.for_());
    }

    @Override
    public AstNode visitReturn_stmt(DnlkkRulesParser.Return_stmtContext ctx) {
        return visitReturn(ctx.return_());
    }

    @Override
    public AstNode visitGoto_stmt(DnlkkRulesParser.Goto_stmtContext ctx) {
        return new TerminalAstNode(ctx.GOTO().getText());
    }

    @Override
    public AstNode visitDefinition(DnlkkRulesParser.DefinitionContext ctx) {
        AstNode ident = new TerminalAstNode(ctx.IDENT().getText());
        AstNode value =
                ctx.expr() != null ?
                        visitExpr(ctx.expr()) :
                        visitFun(ctx.fun());
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
            return visit(ctx.call());
        if (ctx.unary_add_operand != null)
            return new UnaryOpNode(ctx.ADD().getText(), visitUnary(ctx.unary_add_operand));
        return new UnaryOpNode(ctx.MULT().getText(), visitUnary(ctx.unary_mult_operand));
    }

    @Override
    public AstNode visitGroup_call(DnlkkRulesParser.Group_callContext ctx) {
        return visit(ctx.group());
    }

    @Override
    public AstNode visitFun_call(DnlkkRulesParser.Fun_callContext ctx) {
        List<AstNode> args = new ArrayList<>();
        for (var arg : ctx.expr())
            args.add(visitExpr(arg));
        return new FunctionCallNode(visit(ctx.call()), args);
    }

    @Override
    public AstNode visitObject_call(DnlkkRulesParser.Object_callContext ctx) {
        AstNode object = visit(ctx.call());
        AstNode field = new TerminalAstNode(ctx.IDENT().getText());
        return new ObjectCallNode(object, field);
    }

    @Override
    public AstNode visitArray_call(DnlkkRulesParser.Array_callContext ctx) {
        AstNode array = visit(ctx.call());

        AstNode expr = visitExpr(ctx.index);
        return new ArrayCallNode(array, expr);
    }

    @Override
    public AstNode visitPrimitive_group(DnlkkRulesParser.Primitive_groupContext ctx) {
        return new TerminalAstNode(ctx.getText());
    }

    @Override
    public AstNode visitFun_group(DnlkkRulesParser.Fun_groupContext ctx) {
        return visitFun(ctx.fun());
    }

    @Override
    public AstNode visitArray_literal_group(DnlkkRulesParser.Array_literal_groupContext ctx) {
        return visitArray_literal(ctx.array_literal());
    }

    @Override
    public AstNode visitObject_literal_group(DnlkkRulesParser.Object_literal_groupContext ctx) {
        return visitObject_literal(ctx.object_literal());
    }

    @Override
    public AstNode visitExpr_group(DnlkkRulesParser.Expr_groupContext ctx) {
        return visitExpr(ctx.expr());
    }

    @Override
    public AstNode visitFun(DnlkkRulesParser.FunContext ctx) {
        TerminalAstNode funIdent = ctx.fun_ident == null ? null : new TerminalAstNode(ctx.fun_ident.getText());
        List<AstNode> args = new ArrayList<>();
        for (int i = ctx.fun_ident == null ? 0 : 1; i < ctx.IDENT().size(); i++)
            args.add(new TerminalAstNode(ctx.IDENT(i).getText()));

        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visit(stmt));
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

    @Override
    public AstNode visitArray_literal(DnlkkRulesParser.Array_literalContext ctx) {
        List<AstNode> elements = new ArrayList<>();
        for (var element : ctx.array_element())
            elements.add(visitArray_element(element));

        return new ArrayLiteralNode(elements);
    }

    @Override
    public AstNode visitArray_element(DnlkkRulesParser.Array_elementContext ctx) {
        return ctx.expr() != null ? visitExpr(ctx.expr()) : visitFun(ctx.fun());
    }

    public AstNode visitReturn(DnlkkRulesParser.ReturnContext ctx) {
        return new ReturnNode(visitExpr(ctx.expr()));
    }
    @Override
    public AstNode visitAssign(DnlkkRulesParser.AssignContext ctx) {
        AstNode variable = visit(ctx.call());
        AstNode value = ctx.expr() != null ? visitExpr(ctx.expr()) : visitFun(ctx.fun());
        return new AssignNode(variable, value);
    }

    @Override
    public AstNode visitWhile(DnlkkRulesParser.WhileContext ctx) {
        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visit(stmt));
        BlockNode body = new BlockNode(stmts);
        return new WhileNode(visitExpr(ctx.expr()), body);
    }

    @Override
    public AstNode visitElse(DnlkkRulesParser.ElseContext ctx) {
        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visit(stmt));
        BlockNode body = new BlockNode(stmts);
        return new ElseNode(body);
    }

    @Override
    public AstNode visitElif(DnlkkRulesParser.ElifContext ctx) {
        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visit(stmt));
        BlockNode body = new BlockNode(stmts);
        return new ElifNode(visitExpr(ctx.expr()), body);
    }

    @Override
    public AstNode visitIf(DnlkkRulesParser.IfContext ctx) {
        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visit(stmt));
        BlockNode body = new BlockNode(stmts);

        List<AstNode> elifs = new ArrayList<>();
        for (var elif: ctx.elif()) {
            elifs.add(visitElif(elif));
        }

        return new IfNode(visitExpr(ctx.expr()), body,
                elifs, visitElse(ctx.else_()));
    }

    @Override
    public AstNode visitFor(DnlkkRulesParser.ForContext ctx) {
        AstNode definition = ctx.definition() == null ? null : visitDefinition(ctx.definition());
        AstNode condition = ctx.logical() == null ? null : visitLogical(ctx.logical());
        AstNode assign = ctx.assign() == null ? null : visitAssign(ctx.assign());
        List<AstNode> stmts = new ArrayList<>();
        if (ctx.stmt_block().stmt_list() != null)
            for (var stmt : ctx.stmt_block().stmt_list().stmt())
                stmts.add(visit(stmt));
        BlockNode body = new BlockNode(stmts);

        return new ForNode(definition, condition, assign, body);
    }
}
