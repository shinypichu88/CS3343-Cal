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
			if (BasicMathsMethods.isDigit(val)) {
				stack.push(val);
			} else if (BasicMathsMethods.isOperator(String.valueOf(val))) {
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

	public int parseResult(String inputExpression) {
		input(inputExpression);
		return Integer.parseInt(output());
	}

	@Override
	public boolean input(String infixInput) {
		// TODO Auto-generated method stub
		String input = infixInput.replace(" ", "");
		postfix = AffixConverter.toPostfix(toStringArray(input));
		return true;
	}

	// Convert string input to array list of operator/operand
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
//		System.out.println(input.trim());
		String[] resultArray = input.trim().split(" ");
		Collections.addAll(resultList, resultArray);
		return resultList;
	}

	@Override
	public String output() {
		// TODO Auto-generated method stub
		return postfix.toString();
	}

}
