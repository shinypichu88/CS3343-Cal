package cal;

public class Multiplication extends Operator{

	public Multiplication() {
		super("*");
	}

	@Override
	public double calculate(double val1, double val2) {
		return val1 * val2;
	}
}
