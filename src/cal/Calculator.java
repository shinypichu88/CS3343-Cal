package cal;

import java.util.Scanner;

/**
 * The Class Calculator to read infix expression input and then output the
 * calculated result.
 * 
 * It act as the <client> object in simple factory pattern
 * 
 * @author Cal
 * @version 1.0
 */
public class Calculator {

	private Parser parser;

	/**
	 * This is the main method which initialises a Calculator Class and keep
	 * looping to scan user input, transform into a input expression and then
	 * execute to calculate the answer until the user input "quit".
	 * 
	 * @param args
	 *            Unused
	 */
	public static void main(String[] args) {

		Calculator cal = new Calculator();

		String input = "";
		boolean isTryAgain = true;

		do {

			System.out.print("Enter (Type \"quit\" to stop): ");
			input = scanInput();

			isTryAgain = !input.toLowerCase().equals("quit");

			if (isTryAgain) {
				cal.setInputExpression(input);
				System.out.println("Result:\n" + cal.execute() + "\n");
			}

		} while (isTryAgain);

		System.out.println("Bye!");

	}

	/**
	 * Scan the console input (the expression) from user by Scanner class that
	 * Java provided.
	 * 
	 * @return the input string
	 */
	public static String scanInput() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		return input;
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
		parser.read(input);
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
