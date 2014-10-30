package cal;

/**
 * The Class represents Tangent operator It extends the TrigoOperator
 * 
 * @author Cal
 * 
 */
public class Tangent extends TrigoOperator {

    /**
     * Constructor for Tangent Operator Initialize by passing "tan" to
     * TrigoOperator to let it know it is a Tangent operator
     * 
     */
    public Tangent() {
	super("tan");
    }

    /**
     * Calculate the Tangent function by calling Math.tan
     * 
     * @param val1
     *            It is an empty number for design purpose
     * @param val2
     *            It is a input parameter for sine function
     * 
     * @return Math.tan(val2) It returns a output of Tangent function
     * 
     */
    @Override
    public double calculate(double val1, double val2) {
	return Math.tan(Math.toRadians(val2));
    }
}
