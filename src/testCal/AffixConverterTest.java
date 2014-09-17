package testCal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import cal.AffixConverter;

public class AffixConverterTest {

	@Test
	public void testInfixToPostfix1() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"1","+","2"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","2","+"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testInfixToPostfix2() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"1","*","(","22","+","3.33",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","3.33","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	@Test
	public void testInfixToPostfix3() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","22",")","*","3"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","+","3","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}
}
