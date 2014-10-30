package cal;

public class Secant extends TrigoOperator {

    public Secant() {
	super("sec");
    }

    @Override
    public double calculate(double val1, double val2) {

	return 1 / Math.cos(Math.toRadians(val2));
    }

}
