package cal;

public class Division extends Operator{

	public Division() {
		super("/");
	}

	@Override
	public double calculate(double val1, double val2) {
		return val1 / val2;
	}
}
