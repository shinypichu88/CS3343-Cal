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
    int expected = 1;
    calculator.setInputExpression("1");
    int result = calculator.execute();
    assertEquals(expected, result);
  }
  
  public void sysTest2() {
    int expected = 7;
    calculator.setInputExpression("3+4");
    int result = calculator.execute();
    assertEquals(expected, result);
  }

  /**
   * Test for operator priority 
   */
  public void sysTest3() {
    int expected = 7;
    calculator.setInputExpression("1+4*3/2");
    int result = calculator.execute();
    assertEquals(expected, result);
  }

  /**
   * Test for Distributive Law
   */
  public void sysTest4() {
    int expected = 6;
    calculator.setInputExpression("2*(2+1)");
    int result = calculator.execute();
    assertEquals(expected, result);
  }
  
  /**
   * Test for Associative Law
   */
  public void sysTest5() {
    int expected = 6;
    calculator.setInputExpression("2-(2-1)");
    int result = calculator.execute();
    assertEquals(expected, result);
  }
  
  public void sysTest6() {
    int expected = 9;
    calculator.setInputExpression("24/4+24/8");
    int result = calculator.execute();
    assertEquals(expected, result);
  }
  
  public void sysTest7() {
    double expected = 4.25;
    calculator.setInputExpression("4*x+2=19");
    double result = calculator.execute();
    assertEquals(expected, result);
  }

}
