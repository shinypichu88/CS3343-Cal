package cal;

public class Secant extends TrigoOperator{
	
	public Secant(String sign)
	{
		super("sec");
	}

	@Override
	public double calculate(double val1, double val2) {
		
		return 1/Math.cos(val2);
	}
	

}
