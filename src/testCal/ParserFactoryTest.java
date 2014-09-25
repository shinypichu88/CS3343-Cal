package testCal;

import junit.framework.TestCase;

import cal.ParserFactory;
public class ParserFactoryTest extends TestCase{

  private ParserFactory factory;

  public void setUp() throws Exception {
    factory = new ParserFactory();

  }


  public void tearDown() throws Exception {
    factory = null;
  }


  public void testIsExpression1() {
    boolean expected = true;
    boolean actual = factory.isExpression("1");
    assertEquals(expected, actual);
  }

  public void testIsExpression2() {
    boolean expected = true;
    boolean actual = factory.isExpression("10+1-1*100/10");
    assertEquals(expected, actual);
  }

  public void testIsExpression3() {
    boolean expected = true;
    boolean actual = factory.isExpression("(1+22)*3");
    assertEquals(expected, actual);
  }

  public void testIsExpression4() {
    boolean expected = true;
    boolean actual = factory.isExpression("(-1)-1");
    assertEquals(expected, actual);
  }

  public void testIsExpression5() {
    boolean expected = true;
    boolean actual = factory.isExpression("2.11*3.99999");
    assertEquals(expected, actual);
  }

  public void testIsExpression6() {
    boolean expected = true;
    boolean actual = factory.isExpression("1*(22+3.33)");
    assertEquals(expected, actual);
  }


  public void testIsExpression7() {
    boolean expected = true;
    boolean actual = factory.isExpression("1*(2+3)");
    assertEquals(expected, actual);
  }
}
