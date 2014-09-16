package cal;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionTree implements InputOutput {

	private TreeNode headTreeNode;
	private String posfixInput;
	private Stack<Character> stack;

	public ExpressionTree() {
		// TODO Auto-generated constructor stub
		stack = new Stack<Character>();
	}

	public void buildTree(String inputExpr) {
		for (int i = inputExpr.length() - 1; i >= 0; i--)
			insert(inputExpr.charAt(i));
		System.out.println(headTreeNode.toString());

	}

	private void insert(char val) {
		try {
			if (isDigit(val)) {
				stack.push(val);
			} else if (isOperator(val)) {
				Operator operator = new Operator(val);
				Operand operand = new Operand(stack.pop());

				if (headTreeNode == null) {
					headTreeNode = operator;
					operator.left = operand;
				} else if (headTreeNode.right == null) {
					operator.right = operand;
				} else {
					operator.left = headTreeNode;
					headTreeNode = operator;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Expression");
		}
	}

	private boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}

	private boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
	}

	public int parseResult(String inputExpression) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean input(String infixInput) {
		// TODO Auto-generated method stub
		posfixInput = toPostfix(infixInput);
		return true;
	}

	// Check if operator 2 is higher priority than operator 1
	private boolean comparePriority(char operator1, char operator2) {
		if ((operator2 == '+' || operator2 == '-') && (operator1 == '+' || operator1 == '-'))
			return true;
		else if ((operator2 == '*' || operator2 == '/')
				&& (operator1 == '+' || operator1 == '-' || operator1 == '*' || operator1 == '/'))
			return true;
		else if ((operator2 == '^')
				&& (operator1 == '+' || operator1 == '-' || operator1 == '*' || operator1 == '/'))
			return true;
		else
			return false;
	}

	private String toPostfix(String infix) {
		String postfix = ""; // equivalent postfix is empty initially
		Stack<Character> operatorStack = new Stack<>(); // stack to hold symbols
		operatorStack.push('#'); // symbol to denote end of stack
		for (int i = 0; i < infix.length(); i++) {
			char currentChar = infix.charAt(i);// symbol to be processed
			if (isOperator(currentChar)) {// if a operator
				// repeatedly pops if stack top has same or higher precedence
				while (comparePriority(currentChar, operatorStack.peek()))
					postfix += operatorStack.pop();
				operatorStack.push(currentChar);
			} else if (currentChar == '(')
				operatorStack.push(currentChar);// push if left parenthesis
			else if (currentChar == ')') {
				// repeatedly pops if right parenthesis until left parenthesis is found
				while (operatorStack.peek() != '(')
					postfix += operatorStack.pop();
				operatorStack.pop();
			} else
				postfix += currentChar;
		}
		// pops all elements of stack left
		while (operatorStack.peek() != '#') {
			postfix += operatorStack.pop();
		}

		return postfix;
	}

	@Override
	public String output() {
		// TODO Auto-generated method stub
		return posfixInput;
	}

}
