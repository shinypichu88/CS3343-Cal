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
		return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'
				|| ch == '(' || ch == ')';
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

	private String toPostfix(String infixBuffer) {
		int priority = 0;
		String postfixBuffer = "";

		Stack s1 = new Stack();

		for (int i = 0; i < infixBuffer.length(); i++) {
			char ch = infixBuffer.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				// check the precedence
				if (s1.size() <= 0)
					s1.push(ch);
				else {
					Character chTop = (Character) s1.peek();
					if (chTop == '*' || chTop == '/')
						priority = 1;
					else
						priority = 0;
					if (priority == 1) {
						if (ch == '+' || ch == '-') {
							postfixBuffer += s1.pop();
							i--;
						} else { // Same
							postfixBuffer += s1.pop();
							i--;
						}
					} else {
						if (ch == '+' || ch == '-') {
							postfixBuffer += s1.pop();
							s1.push(ch);
						} else
							s1.push(ch);
					}
				}
			} else {
				postfixBuffer += ch;
			}
		}
		int len = s1.size();
		for (int j = 0; j < len; j++)
			postfixBuffer += s1.pop();
		return postfixBuffer;
	}

	@Override
	public String output() {
		// TODO Auto-generated method stub
		return posfixInput;
	}

}
