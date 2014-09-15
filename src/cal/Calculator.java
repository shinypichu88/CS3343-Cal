package cal;

import java.util.Scanner;

/**
 * The Class Calculator.
 */
public class Calculator {
	private static InputOutput expressionTree;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanInput();
	}

	public static void scanInput() {
		String s;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an expression: ");
		s = in.nextLine();
		expressionTree = new ExpressionTree();
		if (expressionTree.input(s))
			System.out.println("Result:\n" + expressionTree.output());
	}

	public void setInputExpression(final String string) {
		// TODO Auto-generated method stub
		expressionTree = new ExpressionTree();
		expressionTree.input(string);
	}

	public int execute() {
		// TODO Auto-generated method stub
		return Integer.parseInt(expressionTree.output());
	}

}
