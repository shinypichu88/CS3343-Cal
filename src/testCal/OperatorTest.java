package testCal;

import java.text.DecimalFormat;

import junit.framework.TestCase;
import cal.expressionTree.Operator.Addition;
import cal.expressionTree.Operator.Division;
import cal.expressionTree.Operator.Exponentiation;
import cal.expressionTree.Operator.Factorial;
import cal.expressionTree.Operator.Multiplication;
import cal.expressionTree.Operator.Operator;
import cal.expressionTree.Operator.Subtraction;
import cal.expressionTree.Operator.TrigoOperator.Cosecant;
import cal.expressionTree.Operator.TrigoOperator.Cosine;
import cal.expressionTree.Operator.TrigoOperator.Cotangent;
import cal.expressionTree.Operator.TrigoOperator.Secant;
import cal.expressionTree.Operator.TrigoOperator.Sine;
import cal.expressionTree.Operator.TrigoOperator.Tangent;

public class OperatorTest extends TestCase {

    private Operator operator;

    @Override
    public void tearDown() throws Exception {
	operator = null;
    }

    public void testCalculate1() {
	double expected = 3 + 4;
	operator = new Addition();
	double actual = operator.calculate(3, 4);
	assertEquals(expected, actual);
    }

    public void testCalculate2() {
	double expected = 5 - 2;
	operator = new Subtraction();
	double actual = operator.calculate(5, 2);
	assertEquals(expected, actual);
    }

    public void testCalculate3() {
	double expected = 4 * 5;
	operator = new Multiplication();
	double actual = operator.calculate(4, 5);
	assertEquals(expected, actual);
    }

    public void testCalculate4() {
	double expected = 4 / 2;
	operator = new Division();
	double actual = operator.calculate(4, 2);
	assertEquals(expected, actual);
    }

    public void testCalculate5() {
	double expected = Math.pow(2, 4);
	operator = new Exponentiation();
	double actual = operator.calculate(2, 4);
	assertEquals(expected, actual);
    }

    public void testCalculate6() {
	double expected = 0.5;
	operator = new Sine();
	double actual = operator.calculate(0, 30);
	actual = Double.parseDouble(new DecimalFormat("0.0#").format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate7() {
	double expected = 0.5;
	operator = new Cosine();
	double actual = operator.calculate(0, 60);
	actual = Double.parseDouble(new DecimalFormat("0.0#").format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate8() {
	double expected = 1;
	operator = new Tangent();
	double actual = operator.calculate(0, 45);
	actual = Double.parseDouble(new DecimalFormat("0.0#").format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate9() {
	double expected = 2;
	operator = new Cosecant();
	double actual = operator.calculate(0, 30);
	actual = Double.parseDouble(new DecimalFormat("0.0#").format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate10() {
	double expected = 1.41;
	operator = new Secant();
	double actual = operator.calculate(0, 45);
	actual = Double.parseDouble(new DecimalFormat("0.0#").format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate11() {
	double expected = 1;
	operator = new Cotangent();
	double actual = operator.calculate(0, 45);
	actual = Double.parseDouble(new DecimalFormat("0.0#").format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate12() {
	double expected = 1.73;
	operator = new Cotangent();
	double actual = operator.calculate(0, 30);
	actual = Double.parseDouble(new DecimalFormat("0.0#").format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate13() {
	double expected = 57.3; // 57.298
	operator = new Cosecant();
	double actual = operator.calculate(0, 1);
	actual = Double.parseDouble(new DecimalFormat("0.0#").format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate14() {
    double expected = 24;
    operator = new Factorial();
    double actual = operator.calculate(4, 0);
	assertEquals(expected, actual);
    }
    
    public void testCalculate15() {
    double expected = 7.76;
    operator = new Factorial();
    double actual = operator.calculate(4.2, 0);
    actual = Double.parseDouble(new DecimalFormat("0.0#").format(actual));
	assertEquals(expected, actual);
    }
}
