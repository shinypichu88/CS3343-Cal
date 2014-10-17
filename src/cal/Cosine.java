package cal;

public class Cosine extends TrigoOperator{
	public Cosine() {
		super("cos");	
	}
	
	@Override
	public double calculate(double val1, double val2) {
		return Math.cos(val2);
	}
}
