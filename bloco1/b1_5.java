
import java.util.*;
import static java.lang.System.err;


public class b1_1{
	
	static Scanner sc = new Scanner(System.in);
	static Hashtable<String,Double> storage;
	
	public static void main(String[] args){
		Stack<Double> stack = new Stack<>();
		storage = new Hashtable<String,Double>();
		System.out.print("Introduza a expressão a calcular: ");
//		while(sc.hasNextLine()){
			Scanner sc2 = new Scanner(System.in);
			while(sc2.hasNext()){
				if(sc2.hasNextDouble()){
					stack.push(sc2.nextDouble());
					if(sc2.hasNext()){
						String sig = sc2.next();
						if(sig.equals("+") || sig.equals("-") || sig.equals("/") || sig.equals("*") || sig.equals("=")){
							if(sc2.hasNextDouble()){
								stack.push(sc2.nextDouble());
								double res;
								double op1 = stack.pop();
								double op2 = stack.pop();
								switch(sig){
									case "+":
										res = op2+op1;
										System.out.printf("%.2f + %.2f = %.2f\n", op2,op1,res);
										break;
									case "-":
										res = op2-op1;
										System.out.printf("%.2f - %.2f = %.2f\n", op2,op1,res);
										break;
									case "*":
										res = op2*op1;
										System.out.printf("%.2f * %.2f = %.2f\n", op2,op1,res);
										break;
									case "/":
										res = op2/op1;
										System.out.printf("%.2f / %.2f = %.2f\n", op2,op1,res);
										break;
								}
							}
							else{
								System.err.println("Missing second operand!");
								System.exit(4);
							}
						}
						else{
							System.err.println("Operator of incorrect type!");
							System.exit(3);
						}
					}
					else{
						System.err.println("Missing operator!");
						System.exit(2);
					}
				}
				else if(sc2.hasNext()){
					if(sc2.hasNext()){
						
					}
				}
				else{
					System.err.println("Missing two operands!");
					System.exit(1);
				}
			}
		//}
	}
}
