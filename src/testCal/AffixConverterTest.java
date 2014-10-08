package testCal;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.TestCase;
import cal.AffixConverter;
import cal.MathHelper;

public class AffixConverterTest extends TestCase{
	// Test BasicMathsMethods.isNegativeSign
	public void testIsNegativeSign1() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","22",")","*","3"};
		Collections.addAll(input,inArray);
		boolean actual = MathHelper.isNegativeSign(input,2);
		assertEquals(false, actual);
	}

	public void testIsNegativeSign2() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","(","1","+","22",")","*","3"};
		Collections.addAll(input,inArray);
		boolean actual = MathHelper.isNegativeSign(input,0);
		assertEquals(true, actual);
	}

	public void testIsNegativeSign3() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","-","22",")","*","3" };
		Collections.addAll(input,inArray);
		boolean actual = MathHelper.isNegativeSign(input,2);
		assertEquals(false, actual);
	}

	public void testIsNegativeSign4() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","-","22",")","*","3"};
		Collections.addAll(input,inArray);
		boolean actual = MathHelper.isNegativeSign(input,3);
		assertEquals(true, actual);
	}

	public void testIsNegativeSign5() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","(","-","1","+","22",")"};
		Collections.addAll(input,inArray);
		boolean actual = MathHelper.isNegativeSign(input,2);
		assertEquals(true, actual);
	}

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
		String[] outArray = {"3","(","1","+","-","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray8() {
		String input = "3(-1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","-","1","+","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray9() {
		String input = "-3(1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"-","3","(","1","+","22",")"};
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

	// Case: bracket testing
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

	// Case: testing bracket without * sign
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

	public void testInfixToPostfix7() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","22",")","+","3","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","+","3","1","22","+","*","+"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix8() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","22",")","3","+","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","+","3","*","1","22","+","+"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	// Case: negative sign handling
	public void testInfixToPostfix9() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","(","-","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","0","1","-","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix10() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","3","*","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"0","3","-","1","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix11() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","3","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"0","3","1","22","+","*","-"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix12() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"0","1","22","+","-"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	// Case: prefix operator handling
	public void testInfixToPostfix13() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"cos","30"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {" ","30","cos"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix14() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"cot","30","+","2"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {" ","30","cot","2","+"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix15() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","(","csc","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3"," ","1","csc","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix16() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","(","1","+","sec","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","1"," ","22","sec","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix17() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","*","tan","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3"," ","1","22","+","tan","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix18() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","sin","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3"," ","1","22","+","sin","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix19() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","sin","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"0"," ","1","22","+","sin","-"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix20() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","sin","-","30"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"0"," ","0","30","-","sin","-"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}
}
