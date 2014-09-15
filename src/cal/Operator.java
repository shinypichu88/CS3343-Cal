package cal;

public class Operator extends TreeNode {
	
	private char val;

	public Operator(char value) {
		val = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(val);
	}
}