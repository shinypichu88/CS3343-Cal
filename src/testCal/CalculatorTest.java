package testCal;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cal.Calculator;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculatorTest.
 */
public class CalculatorTest extends TestCase{

  /** The calculator. */
  private Calculator calculator;

  /* (non-Javadoc)
   * @see junit.framework.TestCase#setUp()
   */
  @Before
  public void setUp() throws Exception {
    calculator = new Calculator();
  }

  /* (non-Javadoc)
   * @see junit.framework.TestCase#tearDown()
   */
  @After
  public void tearDown() throws Exception {
    calculator = null;
  }

  /**
   * Test1 - simple system test
   */
  @Test
  public void test1() {
    int expected = 2;
    calculator.setInputExpression("1+1");
    int result = calculator.execute();
    assertEquals(expected, result);
  }

}
