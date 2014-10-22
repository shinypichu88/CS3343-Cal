package cal;

/**
 * The class is a Tree node that act as Operand in ExpressionTree. Only the
 * floating point value is being stored and have no child node.
 */
public class Operand extends TreeNode {
	
	/** The val. */
	private double val;

	/**
	 * Instantiates a new operand.
	 * 
	 * @param value
	 *            value of the operand
	 */
	public Operand(double value) {
		val = value;
		addLeft(null);
		addRight(null);
	}
	
	public double getVal()
	{
		return val;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(val);
	}
}