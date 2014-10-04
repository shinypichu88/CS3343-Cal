package testCal;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.TestCase;
import cal.AffixConverter;

public class AffixConverterTest extends TestCase{
	// Test AffixConverter.toStringArray
	// Case: Basic
	public void testToStringArray1() {
		String input = "1+2";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","+","2"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	// Case: multi-digit and floating numbers
	public void testToStringArray2() {
		String input = "1*(22+3.33)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","*","(","22","+","3.33",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray3() {
		String input = "(1+22)*3";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"(","1","+","22",")","*","3"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	// Case: digit stick with bracket
	public void testToStringArray4() {
		String input = "(1+22)3";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"(","1","+","22",")","3"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray5() {
		String input = "3(1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","1","+","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray6() {
		String input = "(1+22)3(1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"(","1","+","22",")","3","(","1","+","22",")" };
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	// Case: negative numbers
	public void testToStringArray7() {
		String input = "3(1+-22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","1","+","-22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray8() {
		String input = "3(-1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","-1","+","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray9() {
		String input = "-3(1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"-3","(","1","+","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	// Case: sin, cos, etc
	public void testToStringArray10() {
		String input = "3(1+sin22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","1","+","sin","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray11() {
		String input = "3(cos1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","cos","1","+","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}


	// Test AffixConverter.toPostfix
	// Case: basic 1+1 to 12+
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

	// Case: basic 1+1 to 12+
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

	public void testInfixToPostfix4() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","22",")","3"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","+","3","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix5() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","1","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix6() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","22",")","3","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","+","3","*","1","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}
}
