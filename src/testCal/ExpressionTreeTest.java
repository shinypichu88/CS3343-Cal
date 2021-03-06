package testCal;

import cal.expressionTree.ExpressionTreeController;
import junit.framework.TestCase;

public class ExpressionTreeTest extends TestCase {

    private ExpressionTreeController expTree;

    @Override
    public void setUp() throws Exception {
    }

    @Override
    public void tearDown() throws Exception {
	expTree = null;
    }

    // nested parentheses
    public void testParseResult() {
	String expected = "-10.0";
	expTree = new ExpressionTreeController("((2-1)-(3+(4*2)))");
	String actual = expTree.execute();
	assertEquals(expected, actual);
    }

    // simple calculation
    public void testParseResult2() {
	String expected = "8.0";
	expTree = new ExpressionTreeController("(1+2)*3-1");
	String actual = expTree.execute();
	assertEquals(expected, actual);
    }

    // two parentheses
    public void testParseResult3() {
	String expected = "7.0";
	expTree = new ExpressionTreeController("(1+2)*3-(1*2)");
	String actual = expTree.execute();
	assertEquals(expected, actual);
    }

    public void testParseResult4() {
	String expected = "81.0";
	expTree = new ExpressionTreeController("((1+2)*3)^(1*2)");
	String actual = expTree.execute();
	assertEquals(expected, actual);
    }

    // nested parentheses
    public void testParseResult5() {
	String expected = "4.0";
	expTree = new ExpressionTreeController("(1-2)*3-((1*2)-9)");
	String actual = expTree.execute();
	assertEquals(expected, actual);
    }

    // nested parentheses
    public void testParseResult6() {
	String expected = "10.0";
	expTree = new ExpressionTreeController("(2-1)*3-((1*2)-9)");
	String actual = expTree.execute();
	assertEquals(expected, actual);
    }

    // more complicate case of single level parentheses
    public void testParseResult7() {
	String expected = "64.0";
	expTree = new ExpressionTreeController("(6+2)*(10*4)/(2*2.5)");
	String actual = expTree.execute();
	assertEquals(expected, actual);
    }

    // nested parentheses with addition only
    public void testParseResult8() {
	String expected = "27.0";
	expTree = new ExpressionTreeController("((2+3)+5)+((2+8)+(4+3))");
	String actual = expTree.execute();
	assertEquals(expected, actual);
    }

    // sin cos tan
    public void testParseResult9() {
	String expected = "0.5";
	expTree = new ExpressionTreeController("sin45*cos45*tan45");
	String actual = expTree.execute();
	assertEquals(expected, actual);
    }

    public void testOutputStep1() {
	String expected = "Step 1: 2.0 + 3.0";
	expTree = new ExpressionTreeController("2+3");
	expTree.execute();

	String actual = "";
	for (String step : expTree.stepsListGetter()) {
	    actual += step;
	}

	assertEquals(expected, actual);
    }

    public void testOutputStep2() {
	String expected = "Step 1: 3.0 * 3.0" + "Step 2: 2.0 + 9.0";
	expTree = new ExpressionTreeController("2+3*3");
	expTree.execute();

	String actual = "";
	for (String step : expTree.stepsListGetter()) {
	    actual += step;
	}
	assertEquals(expected, actual);
    }

    public void testOutputStep3() {
	String expected = "Step 1: 2.0 + 3.0" + "Step 2: 5.0 * 3.0"
		+ "Step 3: 9.0 / 3.0" + "Step 4: 15.0 - 3.0";

	expTree = new ExpressionTreeController("((2+3)*3)-(9/3)");
	expTree.execute();

	String actual = "";
	for (String step : expTree.stepsListGetter()) {
	    actual += step;
	}
	assertEquals(expected, actual);
    }
}
