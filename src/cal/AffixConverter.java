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
			if (MathHelper.isOperator(currentChar)) {
				if(MathHelper.isNegativeSign(infixArrayList, i)){
					postfixArrayList.add("0");
				}
//				else if(MathHelper.isPrefixOperator(currentChar)){
//					postfixArrayList.add(" "); //need to be done
//				}
				else{
					while (MathHelper.comparePriority(currentChar,
							operatorStack.peek()))
						postfixArrayList.add(operatorStack.pop());
				}
				operatorStack.push(currentChar);
			}
			//
			//
			//
			else if(MathHelper.isPrefixOperator(currentChar)){
				
//				TrigoOperator trigoFunction = new Sine(infixArrayList.get(i+1));
				TrigoOperator trigoFunction = checkTrigo(currentChar);
				postfixArrayList.add(String.valueOf(trigoFunction.calculate(0, Math.toRadians(Double.parseDouble(infixArrayList.get(i+1))))));
				i++;
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

	private static TrigoOperator checkTrigo(String currentChar) {
		// TODO Auto-generated method stub
		if(currentChar.equals("sin"))
			return new Sine();
		else if(currentChar.equals("cos"))
			return new Cosine();
		else
			return new Tangent();
		
	}
}
