package cal;

import java.util.Scanner;

/**
 * The Class Calculator.
 */
public class Calculator {
	private static InputHandler inputHandler;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inputHandler = new InputHandler();
		scanInput();
	}

	public static void scanInput() {
		String s;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an expression: ");
		s = in.nextLine();
		if (inputHandler.setInput(s))
			System.out.println("Result:\n" + inputHandler.output());
	}

	public void setInputExpression(final String string) {
		// TODO Auto-generated method stub
		inputHandler  = new InputHandler();
		inputHandler.setInput(string);
	}

	public int execute() {
		// TODO Auto-generated method stub
		return Integer.parseInt(inputHandler.output());
	}

}
