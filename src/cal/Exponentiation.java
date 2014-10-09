package cal;

public class Exponentiation extends Operator {

    public Exponentiation() {
	super('^');
	// TODO Auto-generated constructor stub
    }

    @Override
    public double calculate(double val1, double val2) {
	return Math.pow(val1,val2);
    }

}
