public class Calculator extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
	   double x = visit(ctx.expr());
	   System.out.println("Resultado = " + x);  
      return x;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.getText());
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
	  double num1 = visit(ctx.expr(0));
      double num2 = visit(ctx.expr(1));
      double res=0;
      switch(ctx.op.getText()){
		  case "+": res = num1+num2;break;
		  case "-": res = num1-num2;break;
		  case "*": res = num1*num2;break;
		  case "/": res = num1/num2;break;
	  }
	  return res;
   }
}
