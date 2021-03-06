package cal.expressionTree;

import java.text.DecimalFormat;
import java.util.ArrayList;

import cal.Parser;
import cal.expressionTree.Operator.Factorial;
import cal.expressionTree.Operator.Operator;
import cal.expressionTree.Operator.TrigoOperator.TrigoOperator;
import cal.util.AffixConverter;

/**
 * ExpressionTree Class model the users input expression as an expression tree
 * It firstly convert the infix input into postfix input. Then it transforms the
 * postfix input as a tree After conversion into an expression tree, it then
 * evaluates the tree and return the result
 * 
 * This is a <ConcreteProduct> that should be created by ParserFactory<Factory>
 */
public class ExpressionTreeController extends Parser {

    private ExpressionTree exprTree;

    /** The result. */
    private double result;

    /** The step counter */
    private int stepCounter = 1;

    /** The steps list */
    private ArrayList<String> stepsList;

    /**
     * Constructor for Expression Tree.
     */
    public ExpressionTreeController(String infixInput) {
	super(infixInput);
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
    protected void read(String infixInput) {
	String input = infixInput.replace(" ", "");
	ArrayList<String> postfix = AffixConverter.toPostfix(input);
	exprTree = new ExpressionTree(postfix);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cal.Parser#execute()
     */
    @Override
    public String execute() {
	this.result = evaluate(exprTree.getHeadNode());
	return new DecimalFormat("0.0#").format(this.result);
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
	    double leftVal = evaluate(node.getLeft());
	    double rightVal = evaluate(node.getRight());

	    // add the steps into steps list array list
	    stepsList.add(outputStep(leftVal, (Operator)node, rightVal));
	    // Printing the steps
	    System.out.println(stepsList.get(stepCounter - 2));

	    result = ((Operator) node).calculate(leftVal, rightVal);
	}
	return result;
    }

    /**
     * Output the each step as String
     * 
     * @param leftVal
     *            the left value
     * @param operator
     *            the operator of the step
     * @param rightVal
     *            the right value
     * @return each step
     */
    private String outputStep(double leftVal, Operator node, double rightVal) {
    String operator = ((Operator) node).getSign();
	String result = "Step " + stepCounter++ + ": ";
    if (!(node instanceof TrigoOperator))
    	result += leftVal;
    result +=  " " + operator + " " ;
    if (!(node instanceof Factorial))
    	result += rightVal;
    	return result;
    }

    public ArrayList<String> stepsListGetter() {
	return this.stepsList;
    }
}
