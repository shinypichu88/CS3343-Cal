package cal;

public class BasicMathsMethods {
	public static boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}

	// Check if the input string is an operator
	public static boolean isOperator(String chr) {
		return chr.equals("+") || chr.equals("-") || chr.equals("*")
				|| chr.equals("/") || chr.equals("^");
	}

	// Check if the input character is an operator
	public static boolean isOperator(char chr) {
		return chr == '+' || chr == '-' || chr == '*' || chr == '/'
				|| chr == '^';
	}

	// Check if operator 2 is higher priority than operator 1
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
