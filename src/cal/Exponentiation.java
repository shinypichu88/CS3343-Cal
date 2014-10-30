package cal;

public class Exponentiation extends Operator {

    public Exponentiation() {
	super("^");
    }

    @Override
    public double calculate(double val1, double val2) {
	return Math.pow(val1, val2);
    }

}
