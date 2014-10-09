package cal;

public class OperatorFactory {
	 public static Operator typeOfOperator(char op) {
			// TODO what happen if null
			Operator result = null;

			switch (op) {
			case '+':
			    result = new Addition();
			    break;
			case '-':
			    result = new Subtraction();
			    break;
			case '*':
			    result = new Multiplication();
			    break;
			case '/':
			    result = new Division();
			    break;
			case '^':
			    result = new Exponentiation();
			    break;
			}
			return result;
		    }
}
