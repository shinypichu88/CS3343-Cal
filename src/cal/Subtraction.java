package cal;

public class Subtraction extends Operator {

	public Subtraction() {
		super("-");
	}
	

	@Override
	public double calculate(double val1, double val2) {
		return val1 - val2;
	}
}
