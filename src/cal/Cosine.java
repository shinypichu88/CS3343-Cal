package cal;

/**
 * The Class represents Cosine operator
 * It extends the TrigoOperator
 * @author Cal
 *
 */
public class Cosine extends TrigoOperator{
	
	/**
	 * Constructor for Cosine Operator
	 * Initialize by passing "cos" to TrigoOperator to let it know it is a Cosine operator
	 * 
	 */
	public Cosine() {
		super("cos");	
	}
	
	
	/**
	 * Calculate the Cosine function by calling Math.cos
	 * @param val1 It is an empty number for design purpose 
	 * @param val2 It is a input parameter for sine function
	 * 
	 * @return Math.cos(val2) It returns a output of Cosine function
 	 * 
	 */
	@Override
	public double calculate(double val1, double val2) {
		return Math.cos(val2);
	}
}
