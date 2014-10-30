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
	new Factorial(),
	new Cosecant(),
	new Cotangent(),
	new Secant()
    };

    public static Operator typeOfOperator(String stringOp){
	for (Operator operator : registeredOperator) {
	    if (operator.getSign().equals(stringOp)) {
		try {
		    return operator.getClass().newInstance();
		} catch (InstantiationException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (IllegalAccessException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
	return null;
    }
}
