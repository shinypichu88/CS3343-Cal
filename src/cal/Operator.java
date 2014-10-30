package cal;

/**
 * The class is a Tree node that act as Operand in ExpressionTree. Only the
 * character is being stored.
 */
public abstract class Operator extends TreeNode {

    /** The sign. */
    private String sign;

    /**
     * Instantiates a new operator.
     * 
     * @param sign
     *            of the operator
     */
    public Operator(String sign) {
	this.sign = sign;
    }

    /**
     * Calculate the result of left & right node under the operator
     * 
     * @param val1
     *            , left value
     * 
     * @param val2
     *            , right value
     * 
     * @return the expression result
     */
    public abstract double calculate(double val1, double val2);

    /**
     * Sign getter
     * 
     * @return the String of sign
     */
    public String getSign() {
	return sign;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return sign;
    }
}
