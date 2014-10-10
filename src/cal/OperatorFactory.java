package cal;

public class OperatorFactory {
    private static Operator[] registeredOperator = { 
	new Addition(), new Subtraction(), 
	new Multiplication(), new Division(),
	new Exponentiation() };

    public static Operator typeOfOperator(char charOp) throws InstantiationException, IllegalAccessException {
	for (Operator operator : registeredOperator) {
	    if (operator.getVal() == charOp) {
		return operator.getClass().newInstance();
	    }
	}
	return null;
    }
}
