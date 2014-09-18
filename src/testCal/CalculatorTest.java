package testCal;

import cal.Calculator;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

  /** The calculator. */
  private Calculator calculator;
  private static final double DELTA = 1e-15;
  
  protected void setUp() throws Exception {
    super.setUp();
    calculator = new Calculator();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
    calculator = null;
  }


  /**
   * testExecute1 - simple system test
   */
  public void testExecute1() {
    int expected = 1;
    calculator.setInputExpression("1");
    int result = calculator.execute();
    assertEquals(expected, result);
  }
  
  public void testExecute2() {
    int expected = 7;
    calculator.setInputExpression("3+4");
    int result = calculator.execute();
    assertEquals(expected, result);
  }

  /**
   * Test for operator priority 
   */
  public void testExecute3() {
    int expected = 7;
    calculator.setInputExpression("1+4*3/2");
    int result = calculator.execute();
    assertEquals(expected, result);
  }

  /**
   * Test for Distributive Law
   */
  public void testExecute4() {
    int expected = 6;
    calculator.setInputExpression("2*(2+1)");
    int result = calculator.execute();
    assertEquals(expected, result);
  }
  
  /**
   * Test for Associative Law
   */
  public void testExecute5() {
    int expected = 6;
    calculator.setInputExpression("2-(2-1)");
    int result = calculator.execute();
    assertEquals(expected, result);
  }
  
  public void testExecute6() {
    int expected = 9;
    calculator.setInputExpression("24/4+24/8");
    int result = calculator.execute();
    assertEquals(expected, result);
  }
  
  public void testExecute7() {
    double expected = 4.25;
    calculator.setInputExpression("4*x+2=19");
    double result = calculator.execute();
    assertEquals(expected, result, DELTA);
  }

}
