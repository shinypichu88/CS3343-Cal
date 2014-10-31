package cal;

import java.util.Scanner;

/**
 * The Class Calculator to read infix expression input and then output the
 * calculated result.
 * 
 * It act as the <client> object in simple factory pattern
 * 
 * @author Cal
 * @version 2.0
 */
public class Calculator {

    private Parser parser;

    /**
     * This is the main method which initializes a Calculator Class and keep
     * looping to scan user input, transform into a input expression and then
     * execute to calculate the answer until the user input "quit".
     * 
     * @param args
     *            Unused
     */
    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);

	Calculator cal = new Calculator();

	String input = "";
	boolean isTryAgain = true;
	try {
	    do {

		System.out.print("Enter (Type \"quit\" to stop): ");
		input = in.nextLine();

		isTryAgain = !input.toLowerCase().equals("quit");

		if (isTryAgain) {
		    cal.setInputExpression(input);
		    System.out.println("Result:\n" + cal.execute() + "\n");
		}

	    } while (isTryAgain);
	} finally {
	    if (in != null) {
		in.close();
	    }
	}

	System.out.println("Bye!");

    }

    /**
     * Sets the console user inputed expression format (infix) into a expression
     * tree format by factory pattern. Then, The parser variable read the infix
     * input to convert to post-fix format for execution later.
     * 
     * ParserFactory<Factory> will create a concrete parser
     * object<ConcreteProduct> for the calculator<Client> to use
     * 
     * @param input
     *            the console input expression inputed by user
     */
    public void setInputExpression(final String input) {
	ParserFactory factory = new ParserFactory();
	factory = new ParserFactory();
	parser = factory.createParser(input);
    }

    /**
     * Execute the parser variable to output the generated result.
     * 
     * @return the result of execution. Return a number for valid input or a
     *         invalid format prompt message for invalid input.
     */
    public String execute() {
	return parser.execute();
    }

}
