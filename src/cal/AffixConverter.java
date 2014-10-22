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
		String[] replaceTokenList = {
				"(", ")",
				"+", "-", "*", "/", "^",
				"sin", "cos", "tan",
				"csc", "sec", "cot"};

		for(String token : replaceTokenList)
		{
			input = input.replace(token, " " + token + " ");
		}
		input = input.replaceAll("\\s+", " ");

		ArrayList<String> resultList = new ArrayList<String>();
		// System.out.println(input.trim());
		String[] resultArray = input.trim().split(" ");
		Collections.addAll(resultList, resultArray);
		return resultList;
	}

	public static ArrayList<String> toPostfix(String input) {
		return toPostfix(AffixConverter.toStringArray(input));
	}

	/**
	 * Convert infix to postfix expression: 1*(22+3.33) -> 1 22 3.33 + *
	 * The result is made specifically for expression tree to put into node
	 * 
	 * <pre>
	 * <b> Operator Data Structure:</b>
	 *
	 * Infix operator: a+b
	 *    +
	 *   / \
	 *  a   b
	 * 
	 * Negative sign: -a
	 *    -
	 *   / \
	 *  0   a
	 * 
	 * This is done from AffixConverter by adding 0 to the postfix String.
	 * Nothing should need to handle specifically
	 * 
	 * Prefix operator: sinA
	 *    sin
	 *    / \
	 *  ' '  a
	 * Space
	 * 
	 * Space is added from AffixConverter
	 * Operator should need to handle specifically to return result
	 * 
	 * Postfix operator: a!
	 *    !
	 *   / \
	 *  a  ' '
	 *    Space
	 * 
	 * Space is added from AffixConverter
	 * Operator should need to handle specifically to return result
	 * </pre>
	 * <ul>
	 * <li>Input: ArrayList<String> ["1","*","(","22","+","3.33",")"]
	 * <li>Output: ArrayList<String> ["1","22","3.33","+","*"]
	 * <li>
	 * <li>Input: ArrayList<String> ["-","sin","(","1","+","22",")"]
	 * <li>Output: ArrayList<String> ["0"," ","1","22","+","sin","-"]
	 * <li>
	 * <li>Input: ArrayList<String> ["30","!","4","!"]
	 * <li>Output: ArrayList<String> ["30"," ","!","4"," ","!" ,"*"]
	 * </ul>
	 * 
	 * @param infixArrayList
	 *            ArrayList of a infix expression
	 * @return ArrayList of a postfix expression for expression tree
	 */
	public static ArrayList<String> toPostfix(ArrayList<String> infixArrayList) {

		ArrayList<String> postfixArrayList = new ArrayList<String>();
		Stack<String> operatorStack = new Stack<String>(); // stack to hold
		// symbols
		operatorStack.push("#"); // symbol to denote end of stack
		for (int i = 0; i < infixArrayList.size(); i++) {
			String currentChar = infixArrayList.get(i);
			// handle operator
			if (MathHelper.isOperator(currentChar)) {
				if(MathHelper.isNegativeSign(infixArrayList, i)){
					postfixArrayList.add("0");
					operatorStack.push(currentChar);
				}
				else if(MathHelper.isPrefixOperator(currentChar)){
					postfixArrayList.add(" ");
					if(i-1>=0 && infixArrayList.get(i-1).equals(")"))
						operatorStack.add("*");
					operatorStack.push(currentChar);
				}
				else if(MathHelper.isPostfixOperator(currentChar)){
					postfixArrayList.add(" ");
					postfixArrayList.add(currentChar);
					if(i+1<infixArrayList.size()&&infixArrayList.get(i+1).equals("(")){
						operatorStack.add("*");
					}
				}
				// if a operator repeatedly pops if stack top has same or higher
				// precedence
				else{
					while (MathHelper.comparePriority(currentChar,
							operatorStack.peek()))
						postfixArrayList.add(operatorStack.pop());
					operatorStack.push(currentChar);
				}
			}
			// handle left parenthesis
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
			}
			// handling of operand
			else{
				postfixArrayList.add(currentChar);
				if(i-1>=0 && infixArrayList.get(i-1).equals(")"))
					postfixArrayList.add("*");
				else if(i-1>=0 && MathHelper.isPostfixOperator(infixArrayList.get(i-1)))
					operatorStack.push("*");

				if(i+1<infixArrayList.size()&&(infixArrayList.get(i+1).equals("(")||MathHelper.isPrefixOperator(infixArrayList.get(i+1))))
					operatorStack.push("*");
				else if(i-1>=0 && MathHelper.isNegativeSign(infixArrayList, i-1))
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
