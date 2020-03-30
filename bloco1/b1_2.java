import java.util.*;
import static java.lang.System.err;


public class b1_2{
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		Stack<Double> stack = new Stack<>();
		System.out.print("Introduza a expressão a calcular: ");
		while(sc.hasNextLine()){
			Scanner sc2 = new Scanner(System.in);
			while(sc2.hasNext()){
				if(sc2.hasNextDouble()){
					stack.push(sc2.nextDouble());
				}
				else {
					if(!stack.isEmpty()){
						String sig = sc2.next();
						if(sig.equals("+") || sig.equals("-") || sig.equals("/") || sig.equals("*")){
							double res;
							double op1 = stack.pop();
							double op2 = stack.pop();
							switch(sig){
								case "+":
									res = op2+op1;
									System.out.printf("%.2f + %.2f = %.2f\n", op2,op1,res);
									stack.push(res);
									break;
								case "-":
									res = op2-op1;
									System.out.printf("%.2f - %.2f = %.2f\n", op2,op1,res);
									stack.push(res);
									break;
								case "*":
									res = op2*op1;
									System.out.printf("%.2f * %.2f = %.2f\n", op2,op1,res);
									stack.push(res);
									break;
								case "/":
									res = op2/op1;
									System.out.printf("%.2f / %.2f = %.2f\n", op2,op1,res);
									stack.push(res);
									break;
							}
						}
						else{
							System.err.println("Operator of incorrect type!");
							System.exit(3);
						}
					}
					else{
						System.err.println("Stack is empty!");
						System.exit(2);
					}
				}
			}
		}
	}
}
