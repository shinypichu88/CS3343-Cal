package cal;

public class OperatorFactory {
    private static Operator[] registeredOperator = { 
	new Addition(), new Subtraction(), 
	new Multiplication(), new Division(),
	new Exponentiation() };

    public static Operator typeOfOperator(String stringOp) throws InstantiationException, IllegalAccessException {
	for (Operator operator : registeredOperator) {
	    if (operator.getSign().equals(stringOp)) {
		return operator.getClass().newInstance();
	    }
	}
	return null;
    }
}
