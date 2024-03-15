// Generated from C:/Users/user/DnlkkProjects/DnlkkScript/src/main/antlr/java/ru/vsu/dnlkkandco/DnlkkRules.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link DnlkkRulesParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void enterStmt_block(DnlkkRulesParser.Stmt_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void exitStmt_block(DnlkkRulesParser.Stmt_blockContext ctx);
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
	 * Enter a parse tree produced by {@link DnlkkRulesParser#for}.
	 * @param ctx the parse tree
	 */
	void enterFor(DnlkkRulesParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#for}.
	 * @param ctx the parse tree
	 */
	void exitFor(DnlkkRulesParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(DnlkkRulesParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(DnlkkRulesParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(DnlkkRulesParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(DnlkkRulesParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(DnlkkRulesParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(DnlkkRulesParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#fun_call}.
	 * @param ctx the parse tree
	 */
	void enterFun_call(DnlkkRulesParser.Fun_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#fun_call}.
	 * @param ctx the parse tree
	 */
	void exitFun_call(DnlkkRulesParser.Fun_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#args_call}.
	 * @param ctx the parse tree
	 */
	void enterArgs_call(DnlkkRulesParser.Args_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#args_call}.
	 * @param ctx the parse tree
	 */
	void exitArgs_call(DnlkkRulesParser.Args_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(DnlkkRulesParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(DnlkkRulesParser.DefinitionContext ctx);
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
	 * Enter a parse tree produced by {@link DnlkkRulesParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(DnlkkRulesParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(DnlkkRulesParser.CompareContext ctx);
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
	 * Enter a parse tree produced by {@link DnlkkRulesParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(DnlkkRulesParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(DnlkkRulesParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(DnlkkRulesParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(DnlkkRulesParser.String_literalContext ctx);
}