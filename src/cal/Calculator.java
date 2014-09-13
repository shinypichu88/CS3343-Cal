package cal;

import java.util.Scanner;

/**
 * The Class Calculator.
 */
public class Calculator {

  private static String inputExpression;
  private ExpressionTree expTree;
  
  public static void main(String[] args) {
    System.out.println("Enter an expression");
    inputExpression = scanInput();
    System.out.println("You entered: " + inputExpression);
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
