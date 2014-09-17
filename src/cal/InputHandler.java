package cal;

import java.io.File;

public class InputHandler {

	/*
	 * TODO Classify whether the user input are: 1. expression 2. equation 3.
	 * input file path Read the user input from input file path
	 */

	private String input;
	private InputOutput dataStructure;

	public boolean setInput(String string) {
		// TODO Validate user Input
		input = string;
		if (isExpression(input)) {
			dataStructure = new ExpressionTree();
			dataStructure.input(input);
			return true;
		} else if (isEquation(input)) {
			// TODO: create equation tree for calculation
			return true;
		} else if (isFilePath(input)) {
			// TODO: read user input from file path
		      // check input isEquation/isExpression again
			return true;
		} else
			return false;
	}

	   private boolean isExpression(String str) {
	        str = str.replace(" ", "");
	        if (str.isEmpty())
	            return false;
	        // TODO Regex for checking all chaaracter except integer, floating point, +-*/ or ()
	        if (str.matches(".*[a-zA-Z]+.*"))
	            return false;
	        else
	            return true;
	   }
	
//TODO fix bug
//	private boolean isExpression(String str) {
//		str = str.replace(" ", "");
//		if (str.isEmpty())
//		  return false;
//		return str.matches("^([-+]?[0-9]*\\.?[0-9]+)$");
//	}

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

	public String output() {
		return dataStructure.output();
	}
}
