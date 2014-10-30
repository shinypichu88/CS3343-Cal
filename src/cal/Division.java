package cal;

/**
 * 
 * This is a concrete class that is used to representing a division object which
 * is extending the abstract operator class
 * 
 * @author cal
 * 
 */

public class Division extends Operator {

    /**
     * 
     * A constructor to initialize the attributes using symbol / as Division
     * 
     */
    public Division() {
	super("/");
    }

    /**
     * 
     * A method accepting 2 double value to calculate and return the division
     * value
     * 
     * @param val1
     * @param val2
     * 
     */
    @Override
    public double calculate(double val1, double val2) {
	return val1 / val2;
    }
}
