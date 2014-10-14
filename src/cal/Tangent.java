package cal;

public class Tangent extends TrigoOperator{
	public Tangent(String value) {
		super(value);	
	}
	
	@Override
	public double calculate() {
		return Math.tan(super.getVal());
	}
}
