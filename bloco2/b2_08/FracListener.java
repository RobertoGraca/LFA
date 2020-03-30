// Generated from Frac.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FracParser}.
 */
public interface FracListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FracParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FracParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FracParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FracParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link FracParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FracParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link FracParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FracParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link FracParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterVariable(FracParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link FracParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitVariable(FracParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintFrac}
	 * labeled alternative in {@link FracParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintFrac(FracParser.PrintFracContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintFrac}
	 * labeled alternative in {@link FracParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintFrac(FracParser.PrintFracContext ctx);
	/**
	 * Enter a parse tree produced by {@link FracParser#assignement}.
	 * @param ctx the parse tree
	 */
	void enterAssignement(FracParser.AssignementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FracParser#assignement}.
	 * @param ctx the parse tree
	 */
	void exitAssignement(FracParser.AssignementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FracParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(FracParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link FracParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(FracParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFrac}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprFrac(FracParser.ExprFracContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFrac}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprFrac(FracParser.ExprFracContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(FracParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(FracParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIntegerSignal}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIntegerSignal(FracParser.ExprIntegerSignalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIntegerSignal}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIntegerSignal(FracParser.ExprIntegerSignalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(FracParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(FracParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInteger(FracParser.ExprIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInteger}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInteger(FracParser.ExprIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(FracParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(FracParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(FracParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link FracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(FracParser.ExprMultDivModContext ctx);
}