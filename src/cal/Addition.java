package cal;

public class Addition extends Operator {

	public Addition() {
		super("+");
	}

	@Override
	public double calculate(double val1, double val2) {
		return val1 + val2;
	}
}
