package testCal;

import cal.ExpressionTree;
import junit.framework.TestCase;

public class ExpressionTreeTest extends TestCase{

  private ExpressionTree expTree;

  public void setUp() throws Exception {
    expTree = new ExpressionTree();
  }

  public void tearDown() throws Exception {
    expTree = null;
  }

//  
//  public void testParseToPostfix() {
//    String expected = "21-342*+-";
//    String result = expTree.parseToPostfix("((2-1)-(3+(4*2)))");
//    assertEquals(expected, result);
//  }

  
  public void testParseResult() {
    int expected = -10;
    int result = expTree.parseResult("((2-1)-(3+(4*2)))");
    assertEquals(expected, result);
  }

}
