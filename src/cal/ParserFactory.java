package cal;

import java.io.File;

public class ParserFactory {
	/**
	 * To determine the input string whether 
	 * it is expression, equation and file path.
	 * 
	 * @param str accept string input
	 * @return Parser object
	 */
    /*
     * Classify whether the user input are: 1. expression 2. equation 3.
     * input file path Read the user input from input file path
     */
	public Parser createParser(String str) {
	    String input = str;
		if (isExpression(input)) {
			return new ExpressionTree();
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
	public boolean isExpression(String str) {
		str = str.replace(" ", "");
		if (str.isEmpty())
		  return false;
		
		String num = "[\\-\\+]?[0-9]*\\.?[0-9]+";
		String op = "([\\/\\+\\-\\*\\^])";
	    String exp = "\\(*" + num + "\\)*("+op+"\\(*"+num+"\\)*)*";
		
		return str.matches(exp);
	}

	private boolean isEquation(String str) {
		// TODO check equation
		str = str.replace(" ", "");
		if (str.isEmpty())
			return false;
		else
			return false; 
	}

	private boolean isFilePath(String str) {
		return new File(str).exists();
	}
}
