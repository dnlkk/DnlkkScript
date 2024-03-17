package ru.vsu.dnlkkandco;

import ru.vsu.dnlkkandco.gen.DnlkkRulesBaseVisitor;
import ru.vsu.dnlkkandco.gen.DnlkkRulesParser;

import java.util.List;

public class AstBuilderVisitor extends DnlkkRulesBaseVisitor<AstNode> {
    @Override
    public AstNode visitProgram(DnlkkRulesParser.ProgramContext ctx) {
        List<AstNode> stmts = ctx.stmt_list().stmt().stream().map(this::visitStmt).toList();
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
        if (ctx.fun() != null) return visitFun(ctx.fun());
        if (ctx.return_() != null) return visitReturn(ctx.return_());
        if (ctx.GOTO() != null) return new TerminalNode(ctx.GOTO().getText());
        throw new RuntimeException("Stmt doesn't contain any node!");
    }

    @Override
    public AstNode visitDefinition(DnlkkRulesParser.DefinitionContext ctx) {
        AstNode ident = new TerminalNode(ctx.assign().IDENT().getText());
        AstNode value =
                ctx.assign().expr() != null ?
                        visitExpr(ctx.assign().expr()) :
                        visitFun(ctx.assign().fun());
        return new BinOpNode("var", ident, value);
    }
}
