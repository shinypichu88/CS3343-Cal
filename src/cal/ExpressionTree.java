package cal;

import java.util.ArrayList;
import java.util.Collections;
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
public class ExpressionTree implements Parser {

	/** The head tree node. */
	private TreeNode headTreeNode;

	/** The postfix. */
	private ArrayList<String> postfix;

	/** The stack. */
	private Stack<String> stack;

	/** The result. */
	private double result;

	/**
	 * Constructor for Expression Tree.
	 */
	public ExpressionTree() {
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
		// TODO Auto-generated method stub
		String input = infixInput.replace(" ", "");
		postfix = AffixConverter.toPostfix(toStringArray(input));
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
		this.result = evaluate(headTreeNode);
	}

	/**
	 * This method is to insert node and create tree.
	 * 
	 * @param val
	 *            an input that needs to be placed into the tree as a node
	 */
	private void insert(String val) {
		try {
			if (BasicMathsMethods.isDigit(val)) {
				stack.push(val);
			} else if (BasicMathsMethods.isOperator(val)) {
				Operator operator = BasicMathsMethods.typeOfOperator(val);
				if (headTreeNode == null) {
					Operand rightOperand = new Operand(Double.parseDouble(stack
							.pop()));
					Operand leftOperand = new Operand(Double.parseDouble(stack
							.pop()));
					headTreeNode = operator;
					headTreeNode.left = leftOperand;
					headTreeNode.right = rightOperand;

				} else {
					char headTreeNodeVal = ((Operator) headTreeNode).val;
					if (!BasicMathsMethods.isOperator(headTreeNodeVal)) {
						operator.left = headTreeNode.left;
						operator.right = headTreeNode.right;
						headTreeNode = operator;
					} else if (stack.size() == 1) {
						Operand rightOperand = new Operand(
								Double.parseDouble(stack.pop()));
						operator.left = headTreeNode;
						operator.right = rightOperand;
						headTreeNode = operator;
					} else {
						Operand rightOperand = new Operand(
								Double.parseDouble(stack.pop()));
						Operand leftOperand = new Operand(
								Double.parseDouble(stack.pop()));
						operator.left = leftOperand;
						operator.right = rightOperand;
						Operator emptyValNode = new Addition('n');
						emptyValNode.left = headTreeNode;
						emptyValNode.right = operator;
						headTreeNode = emptyValNode;
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
		if (node.left == null && node.right == null) { // Just get the value of
														// the leaf
			Operand op = (Operand) node;
			result = (double) op.val;
		} else {
			// We've got work to do, evaluating the expression
			double left, right;
			Operator opt = (Operator) node;
			char operator = (char) opt.val;
			// Capture the values of the left and right subexpressions
			left = evaluate(node.left);
			right = evaluate(node.right);
			
			// Printing the steps
			System.out.println("Step: " + left + " " + operator + " " + right);
			
			// Do the arithmetic, based on the operator
			switch (operator) {
			case '+':
				result = left + right;
				break;
			case '-':
				result = left - right;
				break;
			case '*':
				result = left * right;
				break;
			case '/':
				result = left / right;
				break;
			case '^':
				result = Math.pow(left, right);
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

	/**
	 * Convert string input to array list of operator/operand.
	 * 
	 * @param input
	 *            a user input expression
	 * @return resultlist an ArrayList of operator and operand in each slot
	 */
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
		// System.out.println(input.trim());
		String[] resultArray = input.trim().split(" ");
		Collections.addAll(resultList, resultArray);
		return resultList;
	}

}
