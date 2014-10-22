package testCal;

import junit.framework.TestCase;
import cal.Addition;
import cal.Division;
import cal.Exponentiation;
import cal.Multiplication;
import cal.Operator;
import cal.OperatorFactory;
import cal.Subtraction;

public class OperatorFactoryTest extends TestCase{

	
	  
	  public void testTypeOfOperator1() throws InstantiationException, IllegalAccessException {
		Operator op = OperatorFactory.typeOfOperator("+");
		boolean condition = op instanceof Addition;
		assertTrue(condition);
	  }
	  
	  public void testTypeOfOperator2() throws InstantiationException, IllegalAccessException {
	    Operator op = OperatorFactory.typeOfOperator("-");
	    boolean condition = op instanceof Subtraction;
	    assertTrue(condition);
	  }

	  public void testTypeOfOperator3() throws InstantiationException, IllegalAccessException {
	    Operator op = OperatorFactory.typeOfOperator("*");
	    boolean condition = op instanceof Multiplication;
	    assertTrue(condition);
	  }
	  
	  public void testTypeOfOperator4() throws InstantiationException, IllegalAccessException {
	    Operator op = OperatorFactory.typeOfOperator("/");
	    boolean condition = op instanceof Division;
	    assertTrue(condition);
	  }
	  
	  public void testTypeOfOperator5() throws InstantiationException, IllegalAccessException {
	    Operator op = OperatorFactory.typeOfOperator("^");
	    boolean condition = op instanceof Exponentiation;
	    assertTrue(condition);
	  }
}
