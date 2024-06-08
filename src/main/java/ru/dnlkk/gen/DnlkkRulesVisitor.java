// Generated from C:/Users/user/DnlkkProjects/DnlkkScript/src/main/antlr/java/ru/vsu/dnlkkandco/DnlkkRules.g4 by ANTLR 4.13.1
package ru.dnlkk.gen;
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
	 * Visit a parse tree produced by the {@code definition_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition_stmt(DnlkkRulesParser.Definition_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(DnlkkRulesParser.Assign_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(DnlkkRulesParser.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(DnlkkRulesParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(DnlkkRulesParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(DnlkkRulesParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(DnlkkRulesParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code goto_stmt}
	 * labeled alternative in {@link DnlkkRulesParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoto_stmt(DnlkkRulesParser.Goto_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(DnlkkRulesParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#elif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElif(DnlkkRulesParser.ElifContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(DnlkkRulesParser.ElseContext ctx);
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
	 * Visit a parse tree produced by {@link DnlkkRulesParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical(DnlkkRulesParser.LogicalContext ctx);
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
	 * Visit a parse tree produced by {@link DnlkkRulesParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(DnlkkRulesParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fun_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun_call(DnlkkRulesParser.Fun_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code group_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_call(DnlkkRulesParser.Group_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_call(DnlkkRulesParser.Array_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code object_call}
	 * labeled alternative in {@link DnlkkRulesParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_call(DnlkkRulesParser.Object_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primitive_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_group(DnlkkRulesParser.Primitive_groupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fun_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun_group(DnlkkRulesParser.Fun_groupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array_literal_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_literal_group(DnlkkRulesParser.Array_literal_groupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code object_literal_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_literal_group(DnlkkRulesParser.Object_literal_groupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_group}
	 * labeled alternative in {@link DnlkkRulesParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_group(DnlkkRulesParser.Expr_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(DnlkkRulesParser.PrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(DnlkkRulesParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#array_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_literal(DnlkkRulesParser.Array_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#array_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_element(DnlkkRulesParser.Array_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#object_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_literal(DnlkkRulesParser.Object_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link DnlkkRulesParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(DnlkkRulesParser.FieldContext ctx);
}