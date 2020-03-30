import java.util.Hashtable;

public class Interpreter extends CalculatorBaseVisitor<Integer> {
	
	private Hashtable<String,Integer> var = new Hashtable<String,Integer>();
	
   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Integer visitExpression(CalculatorParser.ExpressionContext ctx) {
	   if(!ctx.expr().equals(null)){
		  int x = visit(ctx.expr());
		  System.out.println("Resultado = " + x);  
		  return x;
	  }
	  return 0;
   }

   @Override public Integer visitVariable(CalculatorParser.VariableContext ctx) {
      if(!ctx.assignement().equals(null)){
		  visit(ctx.assignement());
		  System.out.println("Variável adicionada!");
	  }
	  return 0;
   }
   
    @Override public Integer visitAssignement(CalculatorParser.AssignementContext ctx) {
      int varVal = visit(ctx.expr());
      var.put(ctx.ID().getText(),varVal);
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

   @Override public Integer visitExprId(CalculatorParser.ExprIdContext ctx) {
      return var.get(ctx.ID().getText());
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
   
   @Override public Integer visitExprIntegerSignal(CalculatorParser.ExprIntegerSignalContext ctx){
	   int val = visit(ctx.expr());
	   switch(ctx.op.getText()){
		   case "+": return val;
		   case "-": return val*-1;
	   }
	   return -1;
   }
}
