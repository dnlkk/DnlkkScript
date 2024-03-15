// Generated from D:/IdeaProjects/DnlkkScript/src/main/antlr/java/ru/vsu/dnlkkandco/DnlkkRules.g4 by ANTLR 4.13.1
package ru.vsu.dnlkkandco;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DnlkkRulesParser}.
 */
public interface DnlkkRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DnlkkRulesParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DnlkkRulesParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(DnlkkRulesParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(DnlkkRulesParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(DnlkkRulesParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(DnlkkRulesParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(DnlkkRulesParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(DnlkkRulesParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(DnlkkRulesParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(DnlkkRulesParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(DnlkkRulesParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(DnlkkRulesParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DnlkkRulesParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DnlkkRulesParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(DnlkkRulesParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(DnlkkRulesParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMult(DnlkkRulesParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMult(DnlkkRulesParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(DnlkkRulesParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(DnlkkRulesParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(DnlkkRulesParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(DnlkkRulesParser.IdentContext ctx);
}