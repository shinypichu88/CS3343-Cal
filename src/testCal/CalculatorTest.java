package testCal;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cal.Calculator;
import cal.ExpressionTree;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculatorTest.
 */
public class CalculatorTest extends TestCase {

  /** The calculator. */
  private Calculator calculator;

  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#setUp()
   */
  @Before
  public void setUp() throws Exception {
    calculator = new Calculator();
  }

  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#tearDown()
   */
  @After
  public void tearDown() throws Exception {
    calculator = null;
  }

  /**
   * sysTest1 - simple system test
   */
  @Test
  public void sysTest1() {
    int expected = 2;
    calculator.setInputExpression("1+1");
    int result = calculator.execute();
    assertEquals(expected, result);
  }

  public void sysTest2() {
    double expected = 4.25;
    calculator.setInputExpression("4*x+2=19");
    double result = calculator.execute();
    assertEquals(expected, result);
  }

  public void untiTest1() {
    String expected = "21-342*+-";
    ExpressionTree expTree = new ExpressionTree();
    String result = expTree.parseToPostfix("((2−1)−(3+(4*2)))");
    assertEquals(expected, result);
  }

}
