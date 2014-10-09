package cal;

import java.util.ArrayList;
import java.util.Stack;

// TODO: Auto-generated Javadoc
/**
 * ExpressionTree Class model the users input expression as an expression tree
 * It firstly convert the infix input into postfix input. Then it transforms the
 * postfix input as a tree After conversion into an expression tree, it then
 * evaluates the tree and return the result
 * 
 * This is a <ConcreteProduct> that should be created by ParserFactory<Factory>
 */
public class ExpressionTreeController implements Parser {

    private ExpressionTree exprTree;

    /** The postfix. */
    private ArrayList<String> postfix;
//
//    /** The stack. */
//    private Stack<String> stack;
//
//    /** The result. */
//    private double result;

    /**
     * Constructor for Expression Tree.
     */
    public ExpressionTreeController() {
    	exprTree = new ExpressionTree();
//	stack = new Stack<String>();
    }

    /**
     * Read input string from caller, convert infix to post-fix and finally
     * build the expression tree.
     * 
     * @param infixInput
     *            , String of equation in infix form
     * @return true, If build tree is finished successfully
     */
    @Override
    public boolean read(String infixInput) {
		String input = infixInput.replace(" ", "");
		postfix = AffixConverter.toPostfix(input);
		buildTree();
		return true;
    }

    private void buildTree() {
    	if(postfix.size() > 0)
    	{
    		int[] index = { postfix.size()-1};
    		exprTree.setHeadNode(buildTree(index));
    	}
	}
    
    private TreeNode buildTree(int[] index) {
    	String val = postfix.get(index[0]);
    	
		index[0]--;
    	
    	if(MathHelper.isDigit(val)){ 
			return new Operand(Double.parseDouble(val));
		}
		else {
			Operator node = OperatorFactory.typeOfOperator(val.charAt(0));
			node.addRight(buildTree(index));
			node.addLeft(buildTree(index));
			return node;
		} 
    }

	/*
     * (non-Javadoc)
     * 
     * @see cal.Parser#execute()
     */
    @Override
    public String execute() {
    	return String.valueOf(evaluate(exprTree.getHeadNode()));
    }

//    /**
//     * Method to build the tree and calculate the result First use the post-fix
//     * expression to build tree Then evaluate the result.
//     */
//    public void buildTree() {
//	for (int i = 0; i < postfix.size(); i++)
//	    insert(postfix.get(i));
//	this.result = evaluate(exprTree.getHeadNode());
//    }
//    /**
//     * This method is to insert node and create tree.
//     * 
//     * @param val
//     *            an input that needs to be placed into the tree as a node
//     */
//    private void insert(String val) {
//	try {
//
//	    TreeNode headTreeNode = exprTree.getHeadNode();
//
//	    if (MathHelper.isDigit(val)) {
//
//		if (headTreeNode == null) {
//		    exprTree.setHeadNode(new Operand(Double.parseDouble(val)));
//		} else if (headTreeNode instanceof Operand) {
//		    stack.push(((Operand) headTreeNode).toString());
//		    stack.push(val);
//		    exprTree.setHeadNode(null);
//		} else if (headTreeNode instanceof NullOperator ){
//		    if(headTreeNode.getRight() instanceof Operand)
//		    {
//			stack.push(((Operand)headTreeNode.getRight()).toString());
//			headTreeNode.addRight(null);
//		    }
//		    
//		    stack.push(val);
//		} else if (headTreeNode instanceof Operator) {
//		    
//		    Operator emptyValNode = new NullOperator();
//		    emptyValNode.addLeft(headTreeNode);
//		    emptyValNode.addRight(new Operand(Double.parseDouble(val)));
//		    exprTree.setHeadNode(emptyValNode);
//		
//		}
//
//	    } else if (MathHelper.isOperator(val)) { // XXX:already check it is
//						     // not a digit
//
//		Operator oper = typeOfOperator(val.charAt(0));
//
//		if (headTreeNode == null) {
//
//		    Operand leftOperand = new Operand(Double.parseDouble(stack
//			    .pop()));
//		    Operand rightOperand = new Operand(Double.parseDouble(stack
//			    .pop()));
//
//		    oper.addLeft(leftOperand);
//		    oper.addRight(rightOperand);
//
//		    exprTree.setHeadNode(oper);
//
//		} else if (headTreeNode instanceof NullOperator) {
//		    oper.addLeft(headTreeNode.getLeft());
//		    oper.addRight(headTreeNode.getRight());
//		    exprTree.setHeadNode(oper);
//
//		} else if (stack.size() == 1 || headTreeNode instanceof Operand) {
//
//		    Operand leftOperand = new Operand(Double.parseDouble(stack
//			    .pop()));
//		    oper.addLeft(leftOperand);
//		    oper.addRight(headTreeNode);
//
//		    exprTree.setHeadNode(oper);
//
//		} else {
//
//		    Operand leftOperand = new Operand(Double.parseDouble(stack
//			    .pop()));
//		    Operand rightOperand = new Operand(Double.parseDouble(stack
//			    .pop()));
//
//		    oper.addLeft(leftOperand);
//		    oper.addRight(rightOperand);
//
//		    Operator emptyValNode = new NullOperator();
//		    emptyValNode.addLeft(headTreeNode);
//		    emptyValNode.addRight(oper);
//		    exprTree.setHeadNode(emptyValNode);
//		}
//	    }
//
//	} catch (Exception e) {
//	    System.out.println("Invalid Expression" + e);
//	}
//    }

    /**
     * Evalute method is to calculate the result of the tree.
     * 
     * @param node
     *            represents root node of the expression tree to be calculated
     * @return the evaluated result
     */
    private double evaluate(TreeNode node) {
	double result = 0; // Value to be returned

	if (node == null) {
	    return 0.0; // TODO: check if node itself == null
	}

	if (node.getLeft() == null && node.getRight() == null) { // Just get the
								 // value of
								 // the leaf
	    result = ((Operand)node).getVal();
	} else {
	    // We've got work to do, evaluating the expression
	    char operator = ((Operator) node).getVal();
	    // Capture the values of the left and right subexpressions
	    double leftVal = evaluate(node.getLeft());
	    double rightVal = evaluate(node.getRight());
	    // Do the arithmetic, based on the operator
	    result=((Operator)node).calculate(leftVal, rightVal);

//	    // NOTE: allow fall-through from default to case '+'
//	    default:
		System.out.println("Unrecognized operator " + operator
			+ " treated as +.");
	}
	// Return either the leaf's value or the one we just calculated.
	return result;
    }

}
