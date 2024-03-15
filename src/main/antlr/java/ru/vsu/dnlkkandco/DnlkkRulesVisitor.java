// Generated from C:/Users/user/DnlkkProjects/DnlkkScript/src/main/antlr/java/ru/vsu/dnlkkandco/DnlkkRules.g4 by ANTLR 4.13.1
package ru.vsu.dnlkkandco;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DnlkkRulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DnlkkRulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DnlkkRulesParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_list(DnlkkRulesParser.Stmt_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#stmt_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_block(DnlkkRulesParser.Stmt_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(DnlkkRulesParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(DnlkkRulesParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(DnlkkRulesParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(DnlkkRulesParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(DnlkkRulesParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(DnlkkRulesParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(DnlkkRulesParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#fun_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun_call(DnlkkRulesParser.Fun_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#args_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs_call(DnlkkRulesParser.Args_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(DnlkkRulesParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(DnlkkRulesParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(DnlkkRulesParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(DnlkkRulesParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(DnlkkRulesParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(DnlkkRulesParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(DnlkkRulesParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(DnlkkRulesParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(DnlkkRulesParser.String_literalContext ctx);
}