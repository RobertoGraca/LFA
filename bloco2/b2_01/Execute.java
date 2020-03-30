public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitTop(HelloParser.TopContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitR(HelloParser.RContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
	   Iterator<TerminalNode> it = ctx.ID().iterator();
	   String s = "";
	   while(it.hasNext()){
		   s+=it.next()+" ";
	   }
	   System.out.println("Olá "+s);
      return visitChildren(ctx);
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
	   Iterator<TerminalNode> it = ctx.ID().iterator();
	   String s = "";
	   while(it.hasNext()){
		   s+=it.next()+" ";
	   }
	   System.out.println("Adeus "+s);
      return visitChildren(ctx);
   }
}
