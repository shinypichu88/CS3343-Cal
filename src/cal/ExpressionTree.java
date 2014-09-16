package cal;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionTree implements InputOutput{

	private TreeNode headTreeNode;
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
            }
            else if (isOperator(val)) {
            	Operator operator = new Operator(val);
            	Operand operand = new Operand(stack.pop());

            	if(headTreeNode == null) {
            		headTreeNode = operator;
            		operator.left = operand;
            	}
            	else if (headTreeNode.right == null) {
            		operator.right = operand;
            	}
            	else {
            		operator.left = headTreeNode;
            		headTreeNode = operator;
            	}
            }
        }
        catch (Exception e) {
            System.out.println("Invalid Expression");
        }
    }
	
	private boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}
	
	private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '(' || ch == ')';
    }
	
	public int parseResult(String inputExpression) {
		// TODO Auto-generated method stub
		return 0;
	}
	

@Override
public boolean input(String inString) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public String output() {
	// TODO Auto-generated method stub
	return "0";
}

}
