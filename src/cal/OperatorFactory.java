package cal;

public class OperatorFactory {
    private static Operator[] registeredOperator = { 
	new Addition(), 
	new Subtraction(), 
	new Multiplication(), 
	new Division(),
	new Exponentiation(),
	new Cosine(),
	new Tangent(),
	new Sine(),
	new Factorial()
    };

    //XXX refactor exception handle logic
    public static Operator typeOfOperator(String stringOp) throws InstantiationException, IllegalAccessException {
	for (Operator operator : registeredOperator) {
	    if (operator.getSign().equals(stringOp)) {
		return operator.getClass().newInstance();
	    }
	}
	return null;
    }
}
