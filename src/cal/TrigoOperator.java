package cal;

public abstract class TrigoOperator {

	private double rad;
	
	public TrigoOperator(String value) {
		rad = Double.parseDouble(value)/180*3.14;
	}
	
	public abstract double calculate();
	
	public double getVal()
	{
		return rad;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(rad);
	}
}
