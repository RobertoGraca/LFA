public class Interpreter extends CalculatorBaseVisitor<Integer> {

   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
	   if(ctx.expr()!=null){
		  int x = visit(ctx.expr());
		  System.out.println("Resultado = " + x);  
		  return x;
	  }
	  return 0;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      int num1 = visit(ctx.expr(0));
      int num2 = visit(ctx.expr(1));
      int res=0;
      switch(ctx.op.getText()){
		  case "+": res = num1+num2;break;
		  case "-": res = num1-num2;break;
	  }
	  return res;
   }

   @Override public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.getText());
   }

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
	  int num1 = visit(ctx.expr(0));
      int num2 = visit(ctx.expr(1));
      int res=0;
      switch(ctx.op.getText()){
		  case "*": res = num1*num2;break;
		  case "/": res = num1/num2;break;
		  case "%": res = num1%num2;break;
	  }
	  return res;
   }
}
