// Generated from /home/datom/Projects/UNI/ELP/ELP-XQL/src/main/XQL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQLParser}.
 */
public interface XQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XQLParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(XQLParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(XQLParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(XQLParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(XQLParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#load}.
	 * @param ctx the parse tree
	 */
	void enterLoad(XQLParser.LoadContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#load}.
	 * @param ctx the parse tree
	 */
	void exitLoad(XQLParser.LoadContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(XQLParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(XQLParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#save}.
	 * @param ctx the parse tree
	 */
	void enterSave(XQLParser.SaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#save}.
	 * @param ctx the parse tree
	 */
	void exitSave(XQLParser.SaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(XQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(XQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#composition}.
	 * @param ctx the parse tree
	 */
	void enterComposition(XQLParser.CompositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#composition}.
	 * @param ctx the parse tree
	 */
	void exitComposition(XQLParser.CompositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(XQLParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(XQLParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(XQLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(XQLParser.AttributeContext ctx);
}