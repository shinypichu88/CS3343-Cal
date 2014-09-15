package testCal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cal.ExpressionTree;

public class ExpressionTreeTest {

  private ExpressionTree expTree;

  @Before
  public void setUp() throws Exception {
    expTree = new ExpressionTree();
  }

  @After
  public void tearDown() throws Exception {
    expTree = null;
  }

  @Test
  public void testParseToPostfix() {
    String expected = "21-342*+-";
    String result = expTree.parseToPostfix("((2-1)-(3+(4*2)))");
    assertEquals(expected, result);
  }

  @Test
  public void testParseResult() {
    int expected = -10;
    int result = expTree.parseResult("((2-1)-(3+(4*2)))");
    assertEquals(expected, result);
  }

}
