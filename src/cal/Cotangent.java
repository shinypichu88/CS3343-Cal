package cal;

public class Cotangent extends TrigoOperator {

    public Cotangent() {
	super("cot");

    }

    @Override
    public double calculate(double val1, double val2) {

	return 1 / Math.tan(Math.toRadians(val2));
    }

}
