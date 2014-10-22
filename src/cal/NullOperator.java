package cal;

public class NullOperator extends Operator {

    public NullOperator() {
	super(" ");
    }

	@Override
	public double calculate(double val1, double val2) {
		return 0;
	}
    
}
