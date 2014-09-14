package cal;

public class Operand extends TreeNode {
	int val;
	
	public Operand(int value) {
		val = value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(val);
	}
}