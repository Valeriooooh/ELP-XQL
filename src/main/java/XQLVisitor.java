// Generated from /home/goncalo/Development/ELP-XQL/src/main/XQL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQLParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(XQLParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(XQLParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#load}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoad(XQLParser.LoadContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(XQLParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#save}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSave(XQLParser.SaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(XQLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#composition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposition(XQLParser.CompositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(XQLParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(XQLParser.AttributeContext ctx);
}