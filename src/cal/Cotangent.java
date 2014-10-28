package cal;

public class Cotangent extends TrigoOperator{

	public Cotangent(String sign) {
		super("cot");
		
	}

	@Override
	public double calculate(double val1, double val2) {
		
		return 1/Math.tan(val2);
	}

}
