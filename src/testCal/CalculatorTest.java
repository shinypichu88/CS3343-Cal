package testCal;

import cal.Calculator;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    /** The calculator. */
    private Calculator calculator;

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
        String expected = "1.0";
        calculator.setInputExpression("1");
        String actual = calculator.execute();
        assertEquals(expected, actual);
    }

    public void testExecute2() {
        String expected = "7.0";
        calculator.setInputExpression("3+4");
        String actual = calculator.execute();
        assertEquals(expected, actual);
    }

    /**
     * Test for operator priority
     */
    public void testExecute3() {
        String expected = "7.0";
        calculator.setInputExpression("1+4*3/2");
        String actual = calculator.execute();
        assertEquals(expected, actual);
    }

    /**
     * Test for Distributive Law
     */
    public void testExecute4() {
        String expected = "6.0";
        calculator.setInputExpression("2*(2+1)");
        String actual = calculator.execute();
        assertEquals(expected, actual);
    }
    /**
     * Test for Associative Law
     */
    public void testExecute5() {
        String expected = "1.0";
        calculator.setInputExpression("2-(2-1)");
        String actual = calculator.execute();
        assertEquals(expected, actual);
    }

    public void testExecute6() {
        String expected = "9.0";
        calculator.setInputExpression("24/4+24/8");
        String actual = calculator.execute();
        assertEquals(expected, actual);
    }

    public void testExecute7() {
        String expected = "-10.0";
        calculator.setInputExpression("((2-1)-(3+(4*2)))");
        String actual = calculator.execute();
        assertEquals(expected, actual);
    }

}
