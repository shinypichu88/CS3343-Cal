package testCal;

import junit.framework.TestCase;

import cal.InputHandler;

public class InputHandlerTest extends TestCase{

  private InputHandler inputHandler;
  
  
  public void setUp() throws Exception {
    inputHandler = new InputHandler();
    
  }

  
  public void tearDown() throws Exception {
    inputHandler = null;
  }

  
  public void testIsExpression1() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("1");
    assertEquals(expected, actual);
  }

  
  public void testIsExpression2() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("10+1-1*100/10");
    assertEquals(expected, actual);
  }
  
  
  public void testIsExpression3() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("(1+22)*3");
    assertEquals(expected, actual);
  }
  
  
  public void testIsExpression4() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("(-1)-1");
    assertEquals(expected, actual);
  }
  
  
  public void testIsExpression5() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("2.11*3.99999");
    assertEquals(expected, actual);
  }
  
  
  public void testIsExpression6() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("1*(22+3.33)");
    assertEquals(expected, actual);
  }

  
  public void testIsExpression7() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("1*(2+3)");
    assertEquals(expected, actual);
  }
}
