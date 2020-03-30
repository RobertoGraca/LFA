import java.util.*;
import java.util.List;
import java.io.*;
import java.nio.file.*;
import static java.lang.System.err;

public class b1_3{
	static final Scanner sc = new Scanner(System.in);
	static Hashtable<String,Integer> comp;
	
	public static void main(String[] args) throws IOException{
		File f = new File("numbers.txt"); 
		List<String> linhas = Files.readAllLines(f.toPath());
		comp = new Hashtable<String,Integer>();
		for(String s:linhas){
			String[] spl = s.split("-");
			comp.put(spl[1].trim(),Integer.parseInt(spl[0].trim()));
		}
		while(sc.hasNextLine()){
			String[] spl = sc.nextLine().split(" ");
			for(String s:spl){
				if(comp.containsKey(s)){
					System.out.print(comp.get(s)+" ");
				}
				else{
					System.out.print(s+" ");
				}
			}
			System.out.println();
		}
	}
}
