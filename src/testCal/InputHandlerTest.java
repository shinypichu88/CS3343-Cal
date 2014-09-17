package testCal;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cal.InputHandler;

public class InputHandlerTest {

  private InputHandler inputHandler;
  
  @Before
  public void setUp() throws Exception {
    inputHandler = new InputHandler();
    
  }

  @After
  public void tearDown() throws Exception {
    inputHandler = null;
  }

  @Test
  public void testIsExpression1() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("1");
    assertEquals(expected, actual);
  }

  @Test
  public void testIsExpression2() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("10+1-1*100/10");
    assertEquals(expected, actual);
  }
  
  @Test
  public void testIsExpression3() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("(1+22)*3");
    assertEquals(expected, actual);
  }
  
  @Test
  public void testIsExpression4() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("(-1)-1");
    assertEquals(expected, actual);
  }
  
  @Test
  public void testIsExpression5() {
    boolean expected = true;
    boolean actual = inputHandler.setInput("2.11*3.99999");
    assertEquals(expected, actual);
  }
  

}
