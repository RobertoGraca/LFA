import java.util.Hashtable;
import static java.lang.System.err;

public class Interpreter extends FracBaseVisitor<Fraction> {
	
	public Hashtable<String,Fraction> var = new Hashtable<String,Fraction>();

   @Override public Fraction visitProgram(FracParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitExpression(FracParser.ExpressionContext ctx) {
      if(!ctx.expr().equals(null)){
		  Fraction x = visit(ctx.expr());
		  System.out.println("\nResultado = " + x.toString()); 
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
		  Fraction a = visit(ctx.print());
		  System.out.println((a.getD()==1)?a.getN()+"":a.getN()+"/"+a.getD()); 
	  }
	  return null;
   }

   @Override public Fraction visitAssignement(FracParser.AssignementContext ctx) {
      Fraction varVal = visit(ctx.expr());
      var.put(ctx.ID().getText(),varVal);
      return null;
   }

   @Override public Fraction visitPrint(FracParser.PrintContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Fraction visitExprFrac(FracParser.ExprFracContext ctx) {
	   Fraction a = visit(ctx.Integer(0));
	   Fraction b = visit(ctx.Integer(1));
	   return new Fraction(a.getN(),b.getN());
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
      Fraction a = new Fraction(Integer.parseInt(ctx.getText()), null);
      if(a==null){
		  return new Fraction(1,1);
	  }
	  else{
		  return a;
	  }
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
