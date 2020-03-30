import java.lang.IllegalArgumentException;

public class Fraction{
	private Integer n,d;
	
	Fraction(Integer n, Integer d){
		this.n=n;
		if(d==null)this.d = 1;
		else if(d==0) throw new IllegalArgumentException("Divide by zero");
		else this.d=d;
	}
	
	public Integer getN(){
		return n;
	}
	
	public void setN(Integer n){
		this.n=n;
	}
	
	public Integer getD(){
		return d;
	}
	
	public void setD(Integer d){
		if(d==null)this.d = 1;
		else this.d=d;
	}
	
	public Fraction add(Fraction a){
		Integer newN,newD;
		if(d!=a.getD()){
			newN = (n*a.getD()) + (a.getN()*d);
			newD = d*a.getD();
		}
		else{
			newN = n + a.getN();
			newD = d;
		}
		return new Fraction(newN,newD);
	}
	
	public Fraction sub(Fraction a){
		Integer newN,newD;
		if(d!=a.getD()){
			newN = (n*a.getD()) - (a.getN()*d);
			newD = d*a.getD();
		}
		else{
			newN = n - a.getN();
			newD = d;
		}
		return new Fraction(newN,newD);
	}
	
	public Fraction times(Fraction a){
		Integer newN,newD;
		newN = n * a.getN();
		newD = d * a.getD();
		return new Fraction(newN,newD);
	}
	
	public Fraction div(Fraction a){
		Integer newN,newD;
		newN = n * a.getD();
		newD = d * a.getN();
		return new Fraction(newN,newD);
	}
	
	public Fraction mod(Fraction a){
		Integer newN,newD;
		
		return new Fraction(n,d);
	}
	
	@Override public String toString(){
		return (d==1)?n+"":n+"/"+d;
	}
}
