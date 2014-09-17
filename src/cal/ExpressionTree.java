package cal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionTree implements InputOutput {

	private TreeNode headTreeNode;
	private ArrayList<String> postfix;
	private Stack<Character> stack;

	public ExpressionTree() {
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
			} else if (isOperator(String.valueOf(val))) {
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

	private boolean isOperator(String currentChar) {
		return currentChar.equals("+") || currentChar.equals("-")
				|| currentChar.equals("*") || currentChar.equals("/")
				|| currentChar.equals("^");
	}

	public int parseResult(String inputExpression) {
		input(inputExpression);
		return Integer.parseInt(output());
	}

	@Override
	public boolean input(String infixInput) {
		// TODO Auto-generated method stub
		String input = infixInput.replace(" ", "");
		postfix = toPostfix(toStringArray(input));
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
		Stack<String> operatorStack = new Stack<>(); // stack to hold symbols
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
