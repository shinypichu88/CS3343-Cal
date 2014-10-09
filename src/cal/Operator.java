package cal;

/**
 * The class is a Tree node that act as Operand in ExpressionTree. Only the
 * character is being stored. 
 */
public abstract class Operator extends TreeNode {
	
	/** The val. */
	private char val;

	/**
	 * Instantiates a new operator.
	 *
	 * @param value character of the operator
	 */
	public Operator(char value) {
		val = value;
	}
	
	public abstract double calculate(double val1, double val2);
	
	public char getVal()
	{
		return val;
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