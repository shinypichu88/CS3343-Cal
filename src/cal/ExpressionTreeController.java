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

    /** The result. */
    private double result;
    
    /** The step counter */
    private int stepCounter = 1;
    
    /** The steps list */
    private ArrayList<String> stepsList;

    /**
     * Constructor for Expression Tree.
     */
    public ExpressionTreeController() {
	exprTree = new ExpressionTree();
	stepsList = new ArrayList<String>();
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
	this.result = evaluate(exprTree.getHeadNode());
	return true; //XXX meaningless, don't always true;
    }

    /**
     * Method to build the tree and calculate the result First use the post-fix
     * expression to build tree Then evaluate the result.
     */
    private void buildTree() {
	try {
	    if (postfix.size() > 0) {
		exprTree.setHeadNode(buildTree(new ArrayList<String>(postfix)));
	    }
	} catch (Exception e) {
	    System.out.println("Invalid Expression" + e);
	}
    }

    private TreeNode buildTree(ArrayList<String> postfix) throws InstantiationException, IllegalAccessException {
	String val = postfix.get(postfix.size()-1);
	postfix.remove(postfix.size()-1);

	if (MathHelper.isDigit(val)) {
	    return new Operand(Double.parseDouble(val));
	} else {
	    Operator node = OperatorFactory.typeOfOperator(val.charAt(0));
	    node.addRight(buildTree(postfix));
	    node.addLeft(buildTree(postfix));
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
	return String.valueOf(this.result);
    }



    /**
     * Evaluate method is to calculate the result of the tree.
     * 
     * @param node
     *            represents root node of the expression tree to be calculated
     * @return the evaluated result
     */
    private double evaluate(TreeNode node) {
	double result = 0; 

	if (node == null) {
	    return 0.0; // TODO: check if node itself == null
	}

	if (node.getLeft() == null && node.getRight() == null) { 
	    result = ((Operand) node).getVal();
	} else {
	    char operator = ((Operator) node).getVal();
	    double leftVal = evaluate(node.getLeft());
	    double rightVal = evaluate(node.getRight());
	    
	    // add the steps into steps list array list
	    stepsList.add(outputStep(leftVal, operator, rightVal));
	    // Printing the steps
	    System.out.println(stepsList.get(stepCounter-2));
	    
	    result = ((Operator) node).calculate(leftVal, rightVal);
	}
	return result;
    }
    
    /**
     * Output the each step as String
     * @param leftVal
     * 					the left value
     * @param operator
     * 					the operator of the step
     * @param rightVal
     * 					the right value
     * @return each step
     */
    private String outputStep(double leftVal, char operator, double rightVal)
    {
    	return "Step "+ stepCounter++ +": " + leftVal + " " + operator + " " + rightVal;
    }
    
    public ArrayList<String> stepsListGetter() {
    	return this.stepsList;
    }
}
