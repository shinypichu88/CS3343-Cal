package testCal;

import cal.expressionTree.Operator.Addition;
import cal.expressionTree.Operator.Division;
import cal.expressionTree.Operator.Exponentiation;
import cal.expressionTree.Operator.Multiplication;
import cal.expressionTree.Operator.Operator;
import cal.expressionTree.Operator.OperatorFactory;
import cal.expressionTree.Operator.Subtraction;
import junit.framework.TestCase;

public class OperatorFactoryTest extends TestCase {

    public void testTypeOfOperator1() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("+");
	boolean condition = op instanceof Addition;
	assertTrue(condition);
    }

    public void testTypeOfOperator2() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("-");
	boolean condition = op instanceof Subtraction;
	assertTrue(condition);
    }

    public void testTypeOfOperator3() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("*");
	boolean condition = op instanceof Multiplication;
	assertTrue(condition);
    }

    public void testTypeOfOperator4() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("/");
	boolean condition = op instanceof Division;
	assertTrue(condition);
    }

    public void testTypeOfOperator5() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("^");
	boolean condition = op instanceof Exponentiation;
	assertTrue(condition);
    }
}
