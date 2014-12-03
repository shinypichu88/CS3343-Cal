package testCal;

import junit.framework.TestCase;
import cal.ParserFactory;

public class ParserFactoryTest extends TestCase {

    private ParserFactory factory;

    @Override
    public void setUp() throws Exception {
	factory = new ParserFactory();

    }

    @Override
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
    
    public void testIsExpression8() {
	boolean expected = true;
	boolean actual = factory.isExpression("sin90+cos30+tan45");
	assertEquals(expected, actual);
    }
    
    public void testIsExpression9() {
	boolean expected = true;
	boolean actual = factory.isExpression("csc30-(sec30*cot45)");
	assertEquals(expected, actual);
    }
    
	public void testIsExpression10() {
		boolean expected = true;
		boolean actual = factory.isExpression("2^4.3!");
		assertEquals(expected, actual);
    }
	
	public void testIsExpression11() {
		boolean expected = true;
		boolean actual = factory.isExpression("cos30+(4!-3)^2");
		assertEquals(expected, actual);
	}
}
