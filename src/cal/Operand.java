package cal;

public class Operand extends TreeNode {
	double val;
	
	public Operand(double value) {
		val = value;
		left = null;
		right = null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(val);
	}
}