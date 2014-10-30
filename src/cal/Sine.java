package cal;
/**
 * The Class represents Sine operator
 * It extends the TrigoOperator
 * 
 * @author Cal
 *
 */
public class Sine extends TrigoOperator{
	
	/**
	 * Constructor for Sine Operator
	 * Initialize by passing "sin" to TrigoOperator to let it know it is a Sine operator
	 * 
	 */
	public Sine() {
		super("sin");	
	}

	/**
	 * Calculate the Sine function by calling Math.sin
	 * @param val1 It is an empty number for design purpose 
	 * @param val2 It is a input parameter for sine function
	 * 
	 * @return Math.sin(val2) It returns a output of Sine function 
 	 * 
	 */
	@Override
	public double calculate(double val1, double val2) {
		return Math.sin(val2);
	}
}
