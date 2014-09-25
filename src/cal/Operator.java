package cal;

/**
 * The class is a Tree node that act as Operand in ExpressionTree. Only the
 * character is being stored. 
 */
public class Operator extends TreeNode {
	
	/** The val. */
	char val;

	/**
	 * Instantiates a new operator.
	 *
	 * @param value character of the operator
	 */
	public Operator(char value) {
		val = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(val);
	}
}