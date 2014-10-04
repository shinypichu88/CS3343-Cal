package cal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * This class handles the conversion between difference affix.
 * 
 * @author Jason Yu
 */
public class AffixConverter {
	/**
	 * Convert string input to array list of operator/operand.
	 * 
	 * @param input
	 *            a user input expression
	 * @return resultList an ArrayList of operator and operand in each slot
	 */
	public static ArrayList<String> toStringArray(String input) {
		input = input.replace("(", " ( ");
		input = input.replace(")", " ) ");
		input = input.replace("+", " + ");
		input = input.replace("-", " - ");
		input = input.replace("*", " * ");
		input = input.replace("/", " / ");
		input = input.replace("^", " ^ ");
		input = input.replace("sin", " sin ");
		input = input.replace("cos", " cos ");
		input = input.replace("tan", " tan ");
		input = input.replace("csc", " csc ");
		input = input.replace("sec", " sec ");
		input = input.replace("cot", " cot ");

		ArrayList<String> resultList = new ArrayList<String>();
		input = input.replaceAll("\\s+", " ");
		// System.out.println(input.trim());
		String[] resultArray = input.trim().split(" ");
		Collections.addAll(resultList, resultArray);
		return resultList;
	}

	/**
	 * Convert infix to postfix expression: 1*(22+3.33) -> 1 22 3.33 + *
	 * <ul>
	 * <li>Input: ArrayList<String> ["1","*","(","22","+","3.33",")"]
	 * <li>Output: ArrayList<String> ["1","22","3.33","+","*"]
	 * </ul>
	 * 
	 * @param arrayList
	 *            an ArrayList of a infix expression
	 * @return ArrayList of a postfix expression
	 */
	public static ArrayList<String> toPostfix(ArrayList<String> arrayList) {
		ArrayList<String> postfix = new ArrayList<String>();
		Stack<String> operatorStack = new Stack<String>(); // stack to hold
		// symbols
		operatorStack.push("#"); // symbol to denote end of stack
		for (int i = 0; i < arrayList.size(); i++) {
			String currentChar = arrayList.get(i);
			// if a operator repeatedly pops if stack top has same or higher
			// precedence
			if (BasicMathsMethods.isOperator(currentChar)) {
				while (BasicMathsMethods.comparePriority(currentChar,
						operatorStack.peek()))
					postfix.add(operatorStack.pop());
				operatorStack.push(currentChar);
			}
			// push if left parenthesis
			else if (currentChar.equals("("))
				operatorStack.push(currentChar);
			else if (currentChar.equals(")")) {
				// repeatedly pops if right parenthesis until left parenthesis
				// is found
				while (!operatorStack.peek().equals("("))
					postfix.add(operatorStack.pop());
				operatorStack.pop();
			} else
				postfix.add(currentChar);
		}
		// pops all elements of stack left
		while (!operatorStack.peek().equals("#")) {
			postfix.add(operatorStack.pop());
		}

		return postfix;
	}
}
