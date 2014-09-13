package cal;

import java.util.Scanner;

/**
 * The Class Calculator.
 */
public class Calculator {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
	  scanInput();
  }
  
  public static void scanInput()
  {
	  String s;
	  Scanner in = new Scanner(System.in);
	  System.out.println("Enter an expression");
      s = in.nextLine();
      System.out.println("You entered: "+s);
  }

  public void setInputExpression(String string) {
    // TODO Auto-generated method stub
  }

  public int execute() {
    // TODO Auto-generated method stub
    return 0;
  }

}
