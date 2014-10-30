package testCal;

import java.text.DecimalFormat;

import junit.framework.TestCase;
import cal.Addition;
import cal.Cosecant;
import cal.Cosine;
import cal.Cotangent;
import cal.Division;
import cal.Exponentiation;
import cal.Multiplication;
import cal.Operator;
import cal.Secant;
import cal.Sine;
import cal.Subtraction;
import cal.Tangent;
import cal.TrigoOperator;

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
	actual = Double.parseDouble(new DecimalFormat("0.0#")
	.format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate7() {
	double expected = 0.5;
	operator = new Cosine();
	double actual = operator.calculate(0, 60);
	actual = Double.parseDouble(new DecimalFormat("0.0#")
	.format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate8() {
	double expected = 1;
	operator = new Tangent();
	double actual = operator.calculate(0, 45);
	actual = Double.parseDouble(new DecimalFormat("0.0#")
	.format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate9() {
	double expected = 2;
	operator = new Cosecant();
	double actual = operator.calculate(0, 30);
	actual = Double.parseDouble(new DecimalFormat("0.0#")
	.format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate10() {
	double expected = 1.41;
	operator = new Secant();
	double actual = operator.calculate(0, 45);
	actual = Double.parseDouble(new DecimalFormat("0.0#")
	.format(actual));
	assertEquals(expected, actual);
    }

    public void testCalculate11() {
	double expected = 1;
	operator = new Cotangent();
	double actual = operator.calculate(0, 45);
	actual = Double.parseDouble(new DecimalFormat("0.0#")
	.format(actual));
	assertEquals(expected, actual);
    }
    
    public void testCalculate12() {
	double expected = 1.73;
	operator = new Cotangent();
	double actual = operator.calculate(0, 30);
	actual = Double.parseDouble(new DecimalFormat("0.0#")
	.format(actual));
	assertEquals(expected, actual);
    }
    
    public void testCalculate13() {
 	double expected = 57.3;	//57.298
 	operator = new Cosecant();
 	double actual = operator.calculate(0, 1);
 	actual = Double.parseDouble(new DecimalFormat("0.0#")
 	.format(actual));
 	assertEquals(expected, actual);
     }

}
