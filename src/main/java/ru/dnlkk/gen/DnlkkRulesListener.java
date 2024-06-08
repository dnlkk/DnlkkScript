// Generated from C:/Users/user/DnlkkProjects/DnlkkScript/src/main/antlr/java/ru/vsu/dnlkkandco/DnlkkRules.g4 by ANTLR 4.13.1
package ru.dnlkk.gen;
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
	 * Enter a parse tree produced by the {@code definition_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDefinition_stmt(DnlkkRulesParser.Definition_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code definition_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDefinition_stmt(DnlkkRulesParser.Definition_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(DnlkkRulesParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(DnlkkRulesParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(DnlkkRulesParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(DnlkkRulesParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(DnlkkRulesParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(DnlkkRulesParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(DnlkkRulesParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(DnlkkRulesParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(DnlkkRulesParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(DnlkkRulesParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(DnlkkRulesParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(DnlkkRulesParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code goto_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterGoto_stmt(DnlkkRulesParser.Goto_stmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code goto_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitGoto_stmt(DnlkkRulesParser.Goto_stmtContext ctx);
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
	 * Enter a parse tree produced by {@link DnlkkRulesParser#elif}.
	 * @param ctx the parse tree
	 */
	void enterElif(DnlkkRulesParser.ElifContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#elif}.
	 * @param ctx the parse tree
	 */
	void exitElif(DnlkkRulesParser.ElifContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(DnlkkRulesParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(DnlkkRulesParser.ElseContext ctx);
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
	 * Enter a parse tree produced by {@link DnlkkRulesParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterLogical(DnlkkRulesParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitLogical(DnlkkRulesParser.LogicalContext ctx);
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
	 * Enter a parse tree produced by {@link DnlkkRulesParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(DnlkkRulesParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(DnlkkRulesParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fun_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 */
	void enterFun_call(DnlkkRulesParser.Fun_callContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fun_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 */
	void exitFun_call(DnlkkRulesParser.Fun_callContext ctx);
	/**
	 * Enter a parse tree produced by the {@code group_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 */
	void enterGroup_call(DnlkkRulesParser.Group_callContext ctx);
	/**
	 * Exit a parse tree produced by the {@code group_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 */
	void exitGroup_call(DnlkkRulesParser.Group_callContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 */
	void enterArray_call(DnlkkRulesParser.Array_callContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 */
	void exitArray_call(DnlkkRulesParser.Array_callContext ctx);
	/**
	 * Enter a parse tree produced by the {@code object_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 */
	void enterObject_call(DnlkkRulesParser.Object_callContext ctx);
	/**
	 * Exit a parse tree produced by the {@code object_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 */
	void exitObject_call(DnlkkRulesParser.Object_callContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitive_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_group(DnlkkRulesParser.Primitive_groupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitive_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_group(DnlkkRulesParser.Primitive_groupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fun_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void enterFun_group(DnlkkRulesParser.Fun_groupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fun_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void exitFun_group(DnlkkRulesParser.Fun_groupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array_literal_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void enterArray_literal_group(DnlkkRulesParser.Array_literal_groupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array_literal_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void exitArray_literal_group(DnlkkRulesParser.Array_literal_groupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code object_literal_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void enterObject_literal_group(DnlkkRulesParser.Object_literal_groupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code object_literal_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void exitObject_literal_group(DnlkkRulesParser.Object_literal_groupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void enterExpr_group(DnlkkRulesParser.Expr_groupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 */
	void exitExpr_group(DnlkkRulesParser.Expr_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(DnlkkRulesParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(DnlkkRulesParser.PrimitiveContext ctx);
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
	 * Enter a parse tree produced by {@link DnlkkRulesParser#array_literal}.
	 * @param ctx the parse tree
	 */
	void enterArray_literal(DnlkkRulesParser.Array_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#array_literal}.
	 * @param ctx the parse tree
	 */
	void exitArray_literal(DnlkkRulesParser.Array_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#array_element}.
	 * @param ctx the parse tree
	 */
	void enterArray_element(DnlkkRulesParser.Array_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#array_element}.
	 * @param ctx the parse tree
	 */
	void exitArray_element(DnlkkRulesParser.Array_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#object_literal}.
	 * @param ctx the parse tree
	 */
	void enterObject_literal(DnlkkRulesParser.Object_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#object_literal}.
	 * @param ctx the parse tree
	 */
	void exitObject_literal(DnlkkRulesParser.Object_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DnlkkRulesParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(DnlkkRulesParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link DnlkkRulesParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(DnlkkRulesParser.FieldContext ctx);
}