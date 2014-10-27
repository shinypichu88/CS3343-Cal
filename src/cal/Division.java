package cal;

/**
 * 
 * This is a concrete
 * class that is used 
 * to representing 
 * a division object
 * which is extending the
 * abstract operator class
 * 
 * @author cal
 *
 */


public class Division extends Operator{
	
	/**
	 * 
	 *  A constructor to 
	 *  initialize the attributes
	 *  
	 */
	public Division() {
		super("/");
	}

	/**
	 * 
	 *  A method to accept 2 double value
	 *  calculate and return the division 
	 *  value
	 *  @param val1
	 *  @param val2
	 *  
	 */
	@Override
	public double calculate(double val1, double val2) {
		return val1 / val2;
	}
}
