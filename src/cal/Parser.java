package cal;

/**
 * It is the <Product> interface for <ConcreteProduc> to implement in simple
 * factory pattern
 */
public abstract class Parser {
    	
    	public Parser(String inputString)
    	{
    	    read(inputString);
    	}
    	
	/**
	 * Read the string input
	 * 
	 * @param inputString
	 *            the input string
	 * @return true, if input is successful
	 */
	public abstract void read(String inputString);

	/**
	 * Execute to get the result of the product
	 * 
	 * @return The result in String
	 */
	public abstract String execute();
}
