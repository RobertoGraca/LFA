import java.util.Hashtable;
import static java.lang.System.err;

public class Interpreter extends FracBaseVisitor<Fraction> {
	
	public Hashtable<String,Fraction> var = new Hashtable<String,Fraction>();

   @Override public Fraction visitProgram(FracParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitExpression(FracParser.ExpressionContext ctx) {
      if(ctx.expr()!=null){
		  Fraction x = visit(ctx.expr());
		  //System.out.println("\nResultado = " + x.toString()); 
		  return x;
	  }
	  return null;
   }

   @Override public Fraction visitVariable(FracParser.VariableContext ctx) {
      if(!ctx.assignement().equals(null)){
		  visit(ctx.assignement());
		  System.out.println("\nVariável adicionada!");
	  }
	  return null;
   }

   @Override public Fraction visitPrintFrac(FracParser.PrintFracContext ctx) {
      if(!ctx.print().equals(null)){
		  visit(ctx.print());
	  }
	  return null;
   }

   @Override public Fraction visitAssignement(FracParser.AssignementContext ctx) {
      Fraction varVal = visit(ctx.expr());
      var.put(ctx.ID().getText(),varVal);
      return null;
   }

   @Override public Fraction visitPrint(FracParser.PrintContext ctx) {
	   Fraction a = visit(ctx.expr());  
	   System.out.println((a.getD()==1)?a.getN()+"":a.getN()+"/"+a.getD()); 
	   return null;
      
   }

   @Override public Fraction visitExprFrac(FracParser.ExprFracContext ctx) {
	   return new Fraction(Integer.parseInt(ctx.Integer(0).getText()),Integer.parseInt(ctx.Integer(1).getText()));
   }

   @Override public Fraction visitExprAddSub(FracParser.ExprAddSubContext ctx) {
      Fraction num1 = visit(ctx.expr(0));
      Fraction num2 = visit(ctx.expr(1));
      Fraction res=null;
      switch(ctx.op.getText()){
		  case "+": res = num1.add(num2);break;
		  case "-": res = num1.sub(num2);break;
	  }
	  return res;
   }

   @Override public Fraction visitExprIntegerSignal(FracParser.ExprIntegerSignalContext ctx) {
      Fraction val = visit(ctx.expr());
	   switch(ctx.op.getText()){
		   case "+": return val;
		   case "-": return val.times(new Fraction(-1,null));
	   }
	   return null;
   }

   @Override public Fraction visitExprParent(FracParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Fraction visitExprInteger(FracParser.ExprIntegerContext ctx) {
      return new Fraction(Integer.parseInt(ctx.getText()), null);
   }

   @Override public Fraction visitExprID(FracParser.ExprIDContext ctx) {
      return var.get(ctx.ID().getText());
   }

   @Override public Fraction visitExprMultDivMod(FracParser.ExprMultDivModContext ctx) {
      Fraction num1 = visit(ctx.expr(0));
      Fraction num2 = visit(ctx.expr(1));
      Fraction res=null;
      switch(ctx.op.getText()){
		  case "*": res = num1.times(num2);break;
		  case ":": res = num1.div(num2);break;
		  case "%": res = num1.mod(num2);break;
	  }
	  return res;
   }
}
