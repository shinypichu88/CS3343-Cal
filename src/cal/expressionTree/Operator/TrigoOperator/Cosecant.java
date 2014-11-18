package cal.expressionTree.Operator.TrigoOperator;

public class Cosecant extends TrigoOperator {

    public Cosecant() {
	super("csc");

    }

    @Override
    public double calculate(double val1, double val2) {
	return 1 / Math.sin(Math.toRadians(val2));
    }

}
