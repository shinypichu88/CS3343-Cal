package cal;

public class Cosecant extends TrigoOperator{

	public Cosecant(String sign) {
		super("csc");
		
	}

	@Override
	public double calculate(double val1, double val2) {
		return 1/Math.sin(val2);
	}
	
}
