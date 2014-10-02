package cal;

/**
 * This is a class to handle the common mathematics method.
 * 
 * @author Jason Yu
 */
public class BasicMathsMethods {

	/**
	 * Checks if the string is digit.
	 * 
	 * @param str
	 *            The input string
	 * @return true, if is digit
	 */
	public static boolean isDigit(String str) {
		return str.matches("\\d+(\\.\\d+)?");
	}

	/**
	 * Checks if the character is an operator.
	 * 
	 * @param chr
	 *            The input Character
	 * @return true, if is operator
	 */
	public static boolean isOperator(String chr) {
		return chr.equals("+") || chr.equals("-") || chr.equals("*")
				|| chr.equals("/") || chr.equals("^");
	}
	
	public static Operator typeOfOperator(String chr)
	{
		Operator result = null;
		
		if(chr.equals("+"))
			return result = new Addition('+'); 
		else if(chr.equals("-"))
			return result = new Subtraction('-');
		else if (chr.equals("*"))
			return result = new Subtraction('*');
		else if (chr.equals("/"))
			return result = new Subtraction('/');
		else if (chr.equals("^"))
			return result = new Subtraction('^');
		
		return null;
	}
	/**
	 * Checks if the string is an operator.
	 * 
	 * @param chr
	 *            The input String
	 * @return true, if is operator
	 */
	public static boolean isOperator(char chr) {
		return chr == '+' || chr == '-' || chr == '*' || chr == '/'
				|| chr == '^';
	}

	/**
	 * Compare the priority of the 2 operator.
	 * <ol>
	 * <li>^
	 * <li>*, /
	 * <li>+, *
	 * </ol>
	 * 
	 * @param operator1
	 *            The 1st operator
	 * @param operator2
	 *            The 2nd operator
	 * @return true, if operator 1 has higher priority than operator 2
	 */
	public static boolean comparePriority(String operator1, String operator2) {
		if ((operator2.equals("+") || operator2.equals("-"))
				&& (operator1.equals("+") || operator1.equals("-")))
			return true;
		else if ((operator2.equals("*") || operator2.equals("/"))
				&& (operator1.equals("+") || operator1.equals("-")
						|| operator1.equals("*") || operator1.equals("/")))
			return true;
		else if ((operator2.equals("^"))
				&& (operator1.equals("+") || operator1.equals("-")
						|| operator1.equals("*") || operator1.equals("/")))
			return true;
		else
			return false;
	}
}
