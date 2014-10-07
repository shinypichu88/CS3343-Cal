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
	 * @param infixArrayList
	 *            an ArrayList of a infix expression
	 * @return ArrayList of a postfix expression
	 */
	public static ArrayList<String> toPostfix(ArrayList<String> infixArrayList) {
		ArrayList<String> postfixArrayList = new ArrayList<String>();
		Stack<String> operatorStack = new Stack<String>(); // stack to hold
		// symbols
		operatorStack.push("#"); // symbol to denote end of stack
		for (int i = 0; i < infixArrayList.size(); i++) {
			String currentChar = infixArrayList.get(i);
			// if a operator repeatedly pops if stack top has same or higher
			// precedence
			if (BasicMathsMethods.isOperator(currentChar)) {
				if(BasicMathsMethods.isNegativeSign(infixArrayList, i)){
					postfixArrayList.add("0");
				}
				else{
					while (BasicMathsMethods.comparePriority(currentChar,
							operatorStack.peek()))
						postfixArrayList.add(operatorStack.pop());
				}
				operatorStack.push(currentChar);
			}
			// push if left parenthesis
			else if (currentChar.equals("(")){
				operatorStack.push(currentChar);
			}
			else if (currentChar.equals(")")) {
				// repeatedly pops if right parenthesis until left parenthesis
				// is found
				while (!operatorStack.peek().equals("(")){
					postfixArrayList.add(operatorStack.pop());
				}
				operatorStack.pop();
			} else{
				postfixArrayList.add(currentChar);
				if(i-1>=0 && infixArrayList.get(i-1).equals(")"))
					postfixArrayList.add("*");
				if(i+1<infixArrayList.size() && infixArrayList.get(i+1).equals("("))
					operatorStack.push("*");
				else if(i-1>=0 && BasicMathsMethods.isNegativeSign(infixArrayList, i-1))
					postfixArrayList.add(operatorStack.pop());
			}
		}
		// pops all elements of stack left
		while (!operatorStack.peek().equals("#")) {
			postfixArrayList.add(operatorStack.pop());
		}

		return postfixArrayList;
	}
}
