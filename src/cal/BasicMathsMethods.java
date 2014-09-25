package cal;

/**
 * This is a BasicMathsMethods class
 * It is used to model some basic mathematics rules 
 *
 */
public class BasicMathsMethods {
	public static boolean isDigit(String str) {
		return str.matches("\\d+(\\.\\d+)?");
	}
	
	/**
	 * This function is to check if the input "String" is an operator
	 * i.e. "+", "-", "*", "/"
	 * @param chr a input string which needs to be checked
	 * @return true if the parameter is operator
	 */
	public static boolean isOperator(String chr) {
		return chr.equals("+") || chr.equals("-") || chr.equals("*")
				|| chr.equals("/") || chr.equals("^");
	}

	/**
	 *  This function is to check if the input "Character" is an operator
	 *  i.e. '+', '-', '*', '/'
	 *  @param chr a input character which needs to be checked.
	 *  @return true if the parameter is operator
 	 */
	public static boolean isOperator(char chr) {
		return chr == '+' || chr == '-' || chr == '*' || chr == '/'
				|| chr == '^';
	}

	/**
	 *  This function check if operator 2 is higher priority than operator 1
	 *  Priority: 
	 *  1. '^'
	 *  2. '*', '/' 
	 *  3. '+', '-'
	 *  @param operator1 an operator which is used to compare with operator 2
	 *  @param operator2 an operator which is used to compare with operator 1
	 *  @return true if the priority of operator 2 is higher than operator 1
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
