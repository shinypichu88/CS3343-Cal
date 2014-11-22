package cal.expressionTree;

import java.util.ArrayList;

import cal.expressionTree.Operator.Operator;
import cal.expressionTree.Operator.OperatorFactory;
import cal.util.MathHelper;

public class ExpressionTree {

    /** The head node. */
    private TreeNode headNode;

    /** The postfix. */
    private ArrayList<String> postfix;

    public ExpressionTree(ArrayList<String> postfix) {
	this.postfix = postfix;
	buildTree();
    }

    private void setHeadNode(TreeNode headNode) {
	this.headNode = headNode;
    }

    public TreeNode getHeadNode() {
	return headNode;
    }

    /**
     * Method to build the tree and calculate the result First use the post-fix
     * expression to build tree Then evaluate the result.
     */
    private void buildTree() {
	try {
	    if (postfix.size() > 0) {
		TreeNode head = buildTree(new ArrayList<String>(postfix));
		setHeadNode(head);
	    }
	} catch (Exception e) {
	    System.out.println("Invalid Expression" + e);
	}
    }

    private TreeNode buildTree(ArrayList<String> postfix) {
	String val = postfix.get(postfix.size() - 1);
	postfix.remove(postfix.size() - 1);

	if (val.equals(" "))
	    val = "0";

	if (MathHelper.isDigit(val)) {
	    return new Operand(Double.parseDouble(val));
	} else {
	    Operator node = OperatorFactory.typeOfOperator(val);
	    node.addRight(buildTree(postfix));
	    node.addLeft(buildTree(postfix));
	    return node;
	}
    }

}
