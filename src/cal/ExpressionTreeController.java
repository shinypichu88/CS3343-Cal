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

    /** The stack. */
    private Stack<String> stack;

    /** The result. */
    private double result;

    /**
     * Constructor for Expression Tree.
     */
    public ExpressionTreeController() {
	exprTree = new ExpressionTree();
	stack = new Stack<String>();
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

    /*
     * (non-Javadoc)
     * 
     * @see cal.Parser#execute()
     */
    @Override
    public String execute() {
	return String.valueOf(result);
    }

    /**
     * Method to build the tree and calculate the result First use the post-fix
     * expression to build tree Then evaluate the result.
     */
    public void buildTree() {
	for (int i = 0; i < postfix.size(); i++)
	    insert(postfix.get(i));
	this.result = evaluate(exprTree.getHeadNode());
    }

    private Operator typeOfOperator(char op) {
	// TODO what happen if null
	Operator result = null;

	switch (op) {
	case '+':
	    result = new Addition();
	    break;
	case '-':
	    result = new Subtraction();
	    break;
	case '*':
	    result = new Multiplication();
	    break;
	case '/':
	    result = new Division();
	    break;
	}
	return result;

	// else if (chr.equals("^"))
	// return result = new Subtraction('^');
    }

    /**
     * This method is to insert node and create tree.
     * 
     * @param val
     *            an input that needs to be placed into the tree as a node
     */
    private void insert(String val) {
	try {

	    TreeNode headTreeNode = exprTree.getHeadNode();

	    if (MathHelper.isDigit(val)) {

		if (headTreeNode == null) {
		    exprTree.setHeadNode(new Operand(Double.parseDouble(val)));
		} else if (headTreeNode instanceof Operand) {
		    stack.push(((Operand) headTreeNode).toString());
		    stack.push(val);
		    exprTree.setHeadNode(null);
		} else if (headTreeNode instanceof Operator) {
		    stack.push(val);
		}
		

	    } else if (MathHelper.isOperator(val)) { // XXX:already check it is
						     // not a digit

		Operator oper = typeOfOperator(val.charAt(0));

		if (headTreeNode instanceof Operand || headTreeNode == null) {

		    // TODO if only one operand in stack?
		    Operand leftOperand = new Operand(Double.parseDouble(stack
			    .pop()));
		    Operand rightOperand = new Operand(Double.parseDouble(stack
			    .pop()));

		    oper.addLeft(leftOperand);
		    oper.addRight(rightOperand);

		    exprTree.setHeadNode(oper);

		} else {

		    if (headTreeNode instanceof NullOperator) {
			oper.addLeft(headTreeNode.getLeft());
			oper.addRight(headTreeNode.getRight());
			exprTree.setHeadNode(oper);

		    } else

		    if (stack.size() == 1) {

			Operand rightOperand = new Operand(
				Double.parseDouble(stack.pop()));
			oper.addLeft(headTreeNode);
			oper.addRight(rightOperand);

			exprTree.setHeadNode(oper);

		    } else {

			Operand rightOperand = new Operand(
				Double.parseDouble(stack.pop()));
			Operand leftOperand = new Operand(
				Double.parseDouble(stack.pop()));

			oper.addLeft(leftOperand);
			oper.addRight(rightOperand);

			Operator emptyValNode = new NullOperator();
			emptyValNode.addLeft(headTreeNode);
			emptyValNode.addRight(oper);
			exprTree.setHeadNode(emptyValNode);
		    }
		}
	    }

	} catch (Exception e) {
	    System.out.println("Invalid Expression" + e);
	}
    }

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
	    result = ((Operand) node).getVal();
	} else {
	    // We've got work to do, evaluating the expression
	    char operator = ((Operator) node).getVal();
	    // Capture the values of the left and right subexpressions
	    double leftVal = evaluate(node.getLeft());
	    double rightVal = evaluate(node.getRight());
	    // Do the arithmetic, based on the operator
	    switch (operator) {
	    case '+':
		result = leftVal + rightVal;
		break;
	    case '-':
		result = leftVal - rightVal;
		break;
	    case '*':
		result = leftVal * rightVal;
		break;
	    case '/':
		result = leftVal / rightVal;
		break;
	    case '^':
		result = Math.pow(leftVal, rightVal);
		break;
	    // NOTE: allow fall-through from default to case '+'
	    default:
		System.out.println("Unrecognized operator " + operator
			+ " treated as +.");
	    }
	}
	// Return either the leaf's value or the one we just calculated.
	return result;
    }

}
