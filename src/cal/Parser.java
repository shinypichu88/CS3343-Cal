package cal;

/**
 * It is the <Product> interface for <ConcreteProduc> to implement in simple
 * factory pattern
 */
public interface Parser {

	/**
	 * Read the string input
	 * 
	 * @param inputString
	 *            the input string
	 * @return true, if input is successful
	 */
	public boolean read(String inputString);

	/**
	 * Execute to get the result of the product
	 * 
	 * @return The result in String
	 */
	public String execute();
}
