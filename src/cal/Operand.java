package cal;

// TODO: Auto-generated Javadoc
/**
 * The class is a Tree node that act as Operand in ExpressionTree. Only the
 * floating point value is being stored and have no child node.
 */
public class Operand extends TreeNode {
	
	/** The val. */
	double val;

	/**
	 * Instantiates a new operand.
	 * 
	 * @param value
	 *            value of the operand
	 */
	public Operand(double value) {
		val = value;
		left = null;
		right = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(val);
	}
}