package testCal;

import junit.framework.TestCase;
import cal.expressionTree.Operator.Addition;
import cal.expressionTree.Operator.Division;
import cal.expressionTree.Operator.Exponentiation;
import cal.expressionTree.Operator.Factorial;
import cal.expressionTree.Operator.Multiplication;
import cal.expressionTree.Operator.Operator;
import cal.expressionTree.Operator.OperatorFactory;
import cal.expressionTree.Operator.Subtraction;
import cal.expressionTree.Operator.TrigoOperator.Cosecant;
import cal.expressionTree.Operator.TrigoOperator.Cosine;
import cal.expressionTree.Operator.TrigoOperator.Cotangent;
import cal.expressionTree.Operator.TrigoOperator.Secant;
import cal.expressionTree.Operator.TrigoOperator.Sine;
import cal.expressionTree.Operator.TrigoOperator.Tangent;

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
    

    public void testTypeOfOperator6() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("sin");
	boolean condition = op instanceof Sine;
	assertTrue(condition);
    }
    

    public void testTypeOfOperator7() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("cos");
	boolean condition = op instanceof Cosine;
	assertTrue(condition);
    }
    

    public void testTypeOfOperator8() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("tan");
	boolean condition = op instanceof Tangent;
	assertTrue(condition);
    }
    

    public void testTypeOfOperator9() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("csc");
	boolean condition = op instanceof Cosecant;
	assertTrue(condition);
    }
    

    public void testTypeOfOperator10() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("sec");
	boolean condition = op instanceof Secant;
	assertTrue(condition);
    }
    

    public void testTypeOfOperator11() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("cot");
	boolean condition = op instanceof Cotangent;
	assertTrue(condition);
    }
    

    public void testTypeOfOperator12() throws InstantiationException,
	    IllegalAccessException {
	Operator op = OperatorFactory.typeOfOperator("!");
	boolean condition = op instanceof Factorial;
	assertTrue(condition);
    }
}
