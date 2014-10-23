package cal;

public class Factorial extends Operator {

	public Factorial() {
		super("!");
	}

	@Override
	public double calculate(double val1, double val2) {
		if (val1 == 0)
			return 1;
		else if (val1%1 == 0)
			return val1*calculate(val1-1,val2);
		
		return Math.exp(logGamma(val1));
	}
	
	private double logGamma(double x) {
	      double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
	      double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
	                       + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
	                       +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
	      return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
	   }
	 
}
