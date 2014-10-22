package cal;

public class Sine extends TrigoOperator{
	public Sine() {
		super("sin");	
	}

	@Override
	public double calculate(double val1, double val2) {
		return Math.sin(val2);
	}
}
