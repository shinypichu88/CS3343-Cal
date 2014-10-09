package cal;

import java.io.File;

/**
 * A <factory> object for creating Parser objects<Product>.
 */
public class ParserFactory {
	/**
	 * To determine the input string whether it is expression, equation and file
	 * path and create the correct <Product>
	 * 
	 * @param str
	 *            accept string input
	 * @return Parser <Product> object
	 */
	/*
	 * Classify whether the user input are: 1. expression 2. equation 3. input
	 * file path Read the user input from input file path
	 */
	public Parser createParser(String str) {
		String input = str;
		if (isExpression(input)) {
			return new ExpressionTreeController();
		} else if (isEquation(input)) {
			// TODO: create equation tree for calculation
			return new NullParser();
		} else if (isFilePath(input)) {
			// TODO: read user input from file path
			// check input isEquation/isExpression again
			return new NullParser();
		} else
			return new NullParser();
	}

	// XXX move to BasicMathMethod
	/**
	 * Checks if is expression.
	 *
	 * @param str input string
	 * @return true, if input is expression
	 */
	public boolean isExpression(String str) {
		str = str.replace(" ", "");
		if (str.isEmpty())
			return false;

		String num = "[\\-\\+]?[0-9]*\\.?[0-9]+";
		String op = "([\\/\\+\\-\\*\\^])";
		String exp = "\\(*" + num + "\\)*(" + op + "\\(*" + num + "\\)*)*";

		return str.matches(exp);
	}

	/**
	 * Checks if is equation.
	 *
	 * @param str input string
	 * @return true, if input is equation
	 */
	private boolean isEquation(String str) {
		// TODO check equation
		str = str.replace(" ", "");
		if (str.isEmpty())
			return false;
		else
			return false;
	}

	/**
	 * Checks if is file path.
	 *
	 * @param str input string
	 * @return true, if input is file path
	 */
	private boolean isFilePath(String str) {
		return new File(str).exists();
	}
}
