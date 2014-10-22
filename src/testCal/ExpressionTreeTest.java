package testCal;

import junit.framework.TestCase;
import cal.ExpressionTreeController;

public class ExpressionTreeTest extends TestCase {

    private ExpressionTreeController expTree;

    @Override
    public void setUp() throws Exception {
    }

    @Override
    public void tearDown() throws Exception {
        expTree = null;
    }

    //
    // public void testParseToPostfix() {
    // String expected = "21-342*+-";
    // String result = expTree.parseToPostfix("((2-1)-(3+(4*2)))");
    // assertEquals(expected, result);
    // }

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
        expTree= new ExpressionTreeController("(1+2)*3-1");
        String actual = expTree.execute();
        assertEquals(expected, actual);
    }
    // two parentheses 
    public void testParseResult3() {
        String expected = "7.0";
        expTree= new ExpressionTreeController("(1+2)*3-(1*2)");
        String actual = expTree.execute();
        assertEquals(expected, actual);
    }
    
    public void testParseResult4() {
        String expected = "81.0";
        expTree= new ExpressionTreeController("((1+2)*3)^(1*2)");
        String actual = expTree.execute();
        assertEquals(expected, actual);
    }
    //nested parentheses
    public void testParseResult5() {
        String expected = "4.0";
        expTree= new ExpressionTreeController("(1-2)*3-((1*2)-9)");
        String actual = expTree.execute();
        assertEquals(expected, actual);
    }
    // nested parentheses
    public void testParseResult6() {
        String expected = "10.0";
        expTree= new ExpressionTreeController("(2-1)*3-((1*2)-9)");
        String actual = expTree.execute();
        assertEquals(expected, actual);
    }
    // more complicate case of single level parentheses 
    public void testParseResult7() {
        String expected = "64.0";
        expTree= new ExpressionTreeController("(6+2)*(10*4)/(2*2.5)");
        String actual = expTree.execute();
        assertEquals(expected, actual);
    }
    // nested parentheses with addition only
    public void testParseResult8() {
        String expected = "27.0";
        expTree= new ExpressionTreeController("((2+3)+5)+((2+8)+(4+3))");
        String actual = expTree.execute();
        assertEquals(expected, actual);
    }
}
