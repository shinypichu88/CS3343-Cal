package testCal;

import junit.framework.TestCase;
import cal.Addition;
import cal.Division;
import cal.Exponentiation;
import cal.Multiplication;
import cal.Operator;
import cal.Subtraction;

public class OperatorTest extends TestCase{

	  private Operator factory;
	  
	  @Override
	public void tearDown() throws Exception {
	    factory = null;
	  }
	  
	  public void testCalculate1() {
		double expected = 3+4;
		factory = new Addition();
	    double actual = factory.calculate(3, 4);
	    assertEquals(expected, actual);
	  }
	  
	  public void testCalculate2() {
		double expected = 5-2;
		factory = new Subtraction();
	    double actual = factory.calculate(5, 2);
	    assertEquals(expected, actual);
	  }
	  
	  public void testCalculate3() {
		double expected = 4*5;
		factory = new Multiplication();
	    double actual = factory.calculate(4, 5);
	    assertEquals(expected, actual);
	  }
	  
	  public void testCalculate4() {
		double expected = 4/2;
		factory = new Division();
	    double actual = factory.calculate(4, 2);
	    assertEquals(expected, actual);
	  }
	  
	  public void testCalculate5() {
		double expected = Math.pow(2, 4);
		factory = new Exponentiation();
	    double actual = factory.calculate(2, 4);
	    assertEquals(expected, actual);
	  }
}
