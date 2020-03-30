import java.util.Hashtable;
import java.io.*;
import java.util.List;
import java.nio.file.Files;
import static java.lang.System.err;

public class Interpreter extends NumbersBaseVisitor<String> {
	
	private Hashtable<String,Integer> ext;

   @Override public String visitProgram(NumbersParser.ProgramContext ctx){
	   ext = new Hashtable<String,Integer>();
	   File f = new File("numbers.txt");
	   List<String> linhas = null;
	   try{
			linhas = Files.readAllLines(f.toPath());
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
	   for(String s:linhas){
		   String[] spl = s.split("-");
		   ext.put(spl[1].trim(),Integer.parseInt(spl[0].trim()));
		   System.out.println(spl[1]);
	   }
      return visitChildren(ctx);
   }

   @Override public String visitStat(NumbersParser.StatContext ctx) {
	   if(ctx.expr()!=null){
		   visit(ctx.expr());
	   }
      return "";
   }

   @Override public String visitExpr(NumbersParser.ExprContext ctx) {
	   String[] spl = visit(ctx.Write()).split(" ");
	   for(String s:spl){
		   if(ext.containsKey(s)){
			   System.out.print(ext.get(s)+" ");
			}else{
				System.out.print(s);
			}
	   }
      return visitChildren(ctx);
   }
}
