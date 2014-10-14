package cal;

public class Sine extends TrigoOperator{
	public Sine(String value) {
		super(value);	
	}

	@Override
	public double calculate() {
		return Math.sin(super.getVal());
	}
}
