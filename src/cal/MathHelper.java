package cal;

import java.util.ArrayList;

/**
 * This is a class to handle the common mathematics method.
 * 
 * @author Jason Yu
 */
public class MathHelper {

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
	 * @param str
	 *            The input Character
	 * @return true, if is operator
	 */
	public static boolean isOperator(String str) {
		return isPrefixOperator(str) || str.equals("+") || str.equals("-") || str.equals("*")
				|| str.equals("/") || str.equals("^");
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
	 * Checks if the String is an prefix operator.
	 * Like sin, cos, tan
	 * 
	 * @param str
	 *            The input String
	 * @return true, if is operator
	 */
	public static boolean isPrefixOperator(String str) {
		return str.equals("sin") || str.equals("cos") || str.equals("tan")
				|| str.equals("csc") || str.equals("sec") || str.equals("cot");
	}

	/**
	 * Checks if the String is an negative sign.
	 * 
	 * @param equation Array List of the infix equation
	 * @param index  index in the ArrayList to be checked
	 * @return true, if is negative sign
	 */
	public static boolean isNegativeSign(ArrayList<String> equation, int index) {
		boolean result = false;
		String str = equation.get(index);

		if(!str.equals("-")){
			result = false;
		}
		else{
			if(index-1<0)
				result = true;
			else{
				String previousStr = equation.get(index-1);
				if(isOperator(previousStr) || previousStr.equals("(")){
					result = true;
				}
			}
		}

		return result;
	}

	/**
	 * Compare the priority of the 2 operator.
	 * <ol>
	 * <li>prefix operator
	 * <li>^
	 * <li>*, /
	 * <li>+, -
	 * </ol>
	 * 
	 * @param operator1
	 *            The 1st operator
	 * @param operator2
	 *            The 2nd operator
	 * @return true, if operator 2 has higher priority than operator 1
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
		else if ((isPrefixOperator(operator2))
				&& (operator1.equals("+") || operator1.equals("-")
						|| operator1.equals("*") || operator1.equals("/")
						|| operator1.equals("^")))
			return true;
		else
			return false;
	}
}
