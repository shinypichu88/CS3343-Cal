package cal;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionTree {

	private TreeNode headTreeNode;

	public ExpressionTree() {
		// TODO Auto-generated constructor stub
	}
	
	public void buildTree(String inputExpression) {
		
	}
	
	private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch =='('
        		|| ch == ')';
    }
	
	private void push(TreeNode node) {
		
	}
	
	private TreeNode pop() {
		return null;
	}
	
	public int parseResult(String inputExpression) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
