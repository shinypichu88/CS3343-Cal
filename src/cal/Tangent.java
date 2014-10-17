package cal;

public class Tangent extends TrigoOperator{
	public Tangent() {
		super("tan");	
	}
	
	@Override
	public double calculate(double val1, double val2) {
		return Math.tan(val2);
	}
}
