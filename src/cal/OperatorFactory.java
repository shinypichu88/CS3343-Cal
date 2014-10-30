package cal;

public class OperatorFactory {
    private static Operator[] registeredOperator = { new Addition(), // +
	    new Subtraction(), // -
	    new Multiplication(), // *
	    new Division(), // /
	    new Exponentiation(), // ^
	    new Cosine(), // cos
	    new Tangent(), // tan
	    new Sine(), // sin
	    new Factorial(), // !
	    new Cosecant(), // csc
	    new Cotangent(), // cot
	    new Secant() // sec
    };

    public static Operator typeOfOperator(String stringOp) {
	for (Operator operator : registeredOperator) {
	    if (operator.getSign().equals(stringOp)) {
		try {
		    return operator.getClass().newInstance();
		} catch (InstantiationException e) {
		    e.printStackTrace();
		} catch (IllegalAccessException e) {
		    e.printStackTrace();
		}
	    }
	}
	return null;
    }
}
