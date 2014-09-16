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
    execute();
  }
  
  private static String getPostfixExpression(String infix) {
	// TODO Auto-generated method stub
	
	return null;
}

// XXX : need to reflector this method to expends InputHandle
  public static String scanInput() {
    Scanner in = new Scanner(System.in);
    return in.nextLine();
  }

  public void setInputExpression(final String inputString) {
    inputExpression = inputString;
  }

  public static int execute() {
    expTree = new ExpressionTree();
    expTree.buildTree(inputExpression);
    return expTree.parseResult(inputExpression);
  }

}
