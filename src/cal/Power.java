package cal;

public class Power extends Operator {

	public Power() {
		super('^');
		// TODO Auto-generated constructor stub
	}

	public double calculate(double val1, double val2) {
		return  Math.pow(val1, val2);
	}
}
