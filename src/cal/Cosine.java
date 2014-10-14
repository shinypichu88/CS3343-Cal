package cal;

public class Cosine extends TrigoOperator{
	public Cosine(String value) {
		super(value);	
	}
	
	@Override
	public double calculate() {
		return Math.cos(super.getVal());
	}
}
