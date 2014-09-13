package cal;

import java.util.Scanner;

/**
 * The Class Calculator.
 */
public class Calculator {

  private static String inputExpression;
  private static ExpressionTree expTree;
  
  public static void main(String[] args) {
    System.out.println("Enter an expression");
    inputExpression = scanInput();
    System.out.println("You entered: " + inputExpression);
    System.out.println(getPostfixExpression(inputExpression));
  }
  
  private static String getPostfixExpression(String infix) {
	// TODO Auto-generated method stub
	expTree = new ExpressionTree();
	return expTree.parseToPostfix(infix);
}

// XXX : need to reflector this method to expends InputHandle
  public static String scanInput() {
    Scanner in = new Scanner(System.in);
    return in.nextLine();
  }

  public void setInputExpression(final String inputString) {
    inputExpression = inputString;
  }

  public int execute() {
    expTree = new ExpressionTree();
    return expTree.parseResult(inputExpression);
  }

}
