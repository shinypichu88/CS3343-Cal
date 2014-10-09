package cal;

public class Division extends Operator{

	public Division() {
		super('/');
		// TODO Auto-generated constructor stub
	}

	public double calculate(double val1, double val2) {
		return val1 / val2;
	}
}
