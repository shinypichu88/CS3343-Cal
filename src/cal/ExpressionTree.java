package cal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionTree implements InputOutput {

	private TreeNode headTreeNode;
	private ArrayList<String> postfix;
	private Stack<String> stack;

	public ExpressionTree() {
		stack = new Stack<String>();
	}

	public void buildTree() {
		for (int i = 0; i < postfix.size(); i++)
			insert(postfix.get(i));
		double result = evaluate(headTreeNode);
		System.out.println(result);
	}

	private void insert(String val) {
		try {
			if (isDigit(val)) {
				stack.push(val);
			} else if (isOperator(val)) {
				Operator operator = new Operator(val.charAt(0));
				if(headTreeNode == null) {
					Operand rightOperand = new Operand(Double.parseDouble(stack.pop()));
					Operand leftOperand = new Operand(Double.parseDouble(stack.pop()));
					headTreeNode = operator;
					headTreeNode.left = leftOperand;
					headTreeNode.right = rightOperand;
				}  else {
					Operand rightOperand = new Operand(Double.parseDouble(stack.pop()));
					operator.left = headTreeNode;
					operator.right = rightOperand;
					headTreeNode = operator;
				}

				
			}
		} catch (Exception e) {
			System.out.println("Invalid Expression" + e);
		}
	}

	private boolean isDigit(String str) {
		return str.matches("\\d+(\\.\\d+)?");
	}

	private boolean isOperator(String currentChar) {
		return currentChar.equals("+") || currentChar.equals("-")
				|| currentChar.equals("*") || currentChar.equals("/")
				|| currentChar.equals("^");
	}

	public int parseResult(String inputExpression) {
		input(inputExpression);
		return Integer.parseInt(output());
	}

	private double evaluate ( TreeNode node ) { 
	double result = 0; // Value to be returned 
	if ( node.left == null && node.right == null ) { // Just get the value of the leaf 
		Operand op = (Operand)node;
		result = (double)op.val; 
	}
	else  { 
		// We've got work to do, evaluating the expression 
		double left, right;
		Operator opt = (Operator)node;
		char operator = (char)opt.val; 
		// Capture the values of the left and right subexpressions 
		left = evaluate ( node.left ); 
		right = evaluate ( node.right ); 
		// Do the arithmetic, based on the operator 
		switch ( operator ) { 
			case '+': result = left + right; break;
			case '-': result = left - right; break; 
			case '*': result = left * right; break; 
			case '/': result = left / right; break; 
			case '^': result = Math.pow (left, right ); break; 
			// NOTE: allow fall-through from default to case '+' 
			default: System.out.println ("Unrecognized operator " + 
					operator + " treated as +."); 
			  
		 } 
	 } 
	 // Return either the leaf's value or the one we just calculated. 
	 return result; 
	 } 
	
	@Override
	public boolean input(String infixInput) {
		// TODO Auto-generated method stub
		String input = infixInput.replace(" ", "");
		postfix = toPostfix(toStringArray(input));
		buildTree();
		return true;
	}

	private ArrayList<String> toStringArray(String input) {
		input = input.replace("(", " ( ");
		input = input.replace(")", " ) ");
		input = input.replace("+", " + ");
		input = input.replace("-", " - ");
		input = input.replace("*", " * ");
		input = input.replace("/", " / ");
		input = input.replace("^", " ^ ");

		ArrayList<String> resultList = new ArrayList<String>();
		input = input.replaceAll("\\s+", " ");
		String[] resultArray = input.split(" ");
		Collections.addAll(resultList, resultArray);
		return resultList;
	}

	// Check if operator 2 is higher priority than operator 1
	private boolean comparePriority(String operator1, String operator2) {
		if ((operator2.equals("+") || operator2.equals("-"))
				&& (operator1.equals("+") || operator1.equals("-")))
			return true;
		else if ((operator2.equals("*") || operator2.equals("/"))
				&& (operator1.equals("+") || operator1.equals("-")
						|| operator1.equals("*") || operator1.equals("/")))
			return true;
		else if ((operator2.equals("^"))
				&& (operator1.equals("+") || operator1.equals("-")
						|| operator1.equals("*") || operator1.equals("/")))
			return true;
		else
			return false;
	}

	// Convert infix to postfix: (1*2)+3 -> 12*3+
	private ArrayList<String> toPostfix(ArrayList<String> arrayList) {
		ArrayList<String> postfix = new ArrayList<String>();
		Stack<String> operatorStack = new Stack<String>(); // stack to hold symbols
		operatorStack.push("#"); // symbol to denote end of stack
		for (int i = 0; i < arrayList.size(); i++) {
			String currentChar = arrayList.get(i);
			// if a operator repeatedly pops if stack top has same or higher
			// precedence
			if (isOperator(currentChar)) {
				while (comparePriority(currentChar, operatorStack.peek()))
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

	@Override
	public String output() {
		// TODO Auto-generated method stub
		return postfix.toString();
	}

}
