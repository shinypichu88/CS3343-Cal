package cal;

/**
 * This is an abstract class representing the Trigonometry function 
 * (i.e. Sine, Cosine, Tangent)
 * It extends Operator as it is also a kind of Operator.
 * This abstract class provides only a constructor which calls the init function of the Operator Class.
 * @author Cal
 *
 */
public abstract class TrigoOperator extends Operator{

	/**
	 * This is a constructor for TrigoOperator
	 * It calls its super class
	 * @param sign it determine the types of the Trigonometry Operator
	 * (i.e. sin = Sine, cos = Cosine, tan = Tangent)
	 */
	public TrigoOperator(String sign) {
		super(sign);
	}
}
