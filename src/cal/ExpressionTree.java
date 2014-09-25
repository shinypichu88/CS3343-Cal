package cal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ExpressionTree implements Parser {

    private TreeNode headTreeNode;
    private ArrayList<String> postfix;
    private Stack<String> stack;
    private double result;

    // Constructor
    public ExpressionTree() {
        stack = new Stack<String>();
    }

    @Override
    public boolean read(String infixInput) {
        // TODO Auto-generated method stub
        String input = infixInput.replace(" ", "");
        postfix = AffixConverter.toPostfix(toStringArray(input));
        buildTree();
        return true;
    }

    @Override
    public String execute() {
        return String.valueOf(result);
    }

    // Method to build the tree and calculate the result
    public void buildTree() {
        for (int i = 0; i < postfix.size(); i++){
        	 insert(postfix.get(i));
        }
           
        this.result = evaluate(headTreeNode);
    }

    // Method to insert node
    private void insert(String val) {
        try {
            if (BasicMathsMethods.isDigit(val)) {
                stack.push(val);
            } else if (BasicMathsMethods.isOperator(val)) {
                Operator operator = new Operator(val.charAt(0));
                if (headTreeNode == null) {
                    Operand rightOperand =
                            new Operand(Double.parseDouble(stack.pop()));
                    Operand leftOperand =
                            new Operand(Double.parseDouble(stack.pop()));
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
                        Operand rightOperand =
                                new Operand(Double.parseDouble(stack.pop()));
                        operator.left = headTreeNode;
                        operator.right = rightOperand;
                        headTreeNode = operator;
                    } else {
                        Operand rightOperand =
                                new Operand(Double.parseDouble(stack.pop()));
                        Operand leftOperand =
                                new Operand(Double.parseDouble(stack.pop()));
                        operator.left = leftOperand;
                        operator.right = rightOperand;
                        Operator emptyValNode = new Operator('n');
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

    // Calculate the result of the tree
    private double evaluate(TreeNode node) {

    	// Value to be returned
    	double result = 0;

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
        // System.out.println(input.trim());
        String[] resultArray = input.trim().split(" ");
        Collections.addAll(resultList, resultArray);
        return resultList;
    }

}
