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
	public void testToStringArray_MultiDigitOrFloatingPointHandling_1() {
		String input = "1*(22+3.33)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","*","(","22","+","3.33",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray_MultiDigitOrFloatingPointHandling_2() {
		String input = "(1+22)*3";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"(","1","+","22",")","*","3"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	// Case: digit stick with bracket
	public void testToStringArray_BracketHandling_1() {
		String input = "(1+22)3";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"(","1","+","22",")","3"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray_BracketHandling_2() {
		String input = "3(1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","1","+","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray_BracketHandling_3() {
		String input = "(1+22)3(1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"(","1","+","22",")","3","(","1","+","22",")" };
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	// Case: negative numbers
	public void testToStringArray_NegativeSignHandling_1() {
		String input = "3(1+-22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","1","+","-","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray_NegativeSignHandling_2() {
		String input = "3(-1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","-","1","+","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray_NegativeSignHandling_3() {
		String input = "-3(1+22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"-","3","(","1","+","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	// Case: sin, cos, etc
	public void testToStringArray_SinCosTan_1() {
		String input = "3(1+sin22)";
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","(","1","+","sin","22",")"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toStringArray(input);
		assertEquals(expected, actual);
	}

	public void testToStringArray_SinCosTan_2() {
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

	// Case: ((2-1)-(3+(4*2)))
	public void testInfixToPostfix2() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","(","2","-","1",")","-","(","3","+","(","4","*","2",")",")",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"2","1","-","3","4","2","*","+","-"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	// Case: bracket testing
	public void testInfixToPostfix_BracketHandling_1() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"1","*","(","22","+","3.33",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","3.33","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_BracketHandling_2() {
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
	public void testInfixToPostfix_AutoAddMultipleHandling_1() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","22",")","3"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","+","3","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_AutoAddMultipleHandling_2() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","1","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_AutoAddMultipleHandling_3() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","22",")","3","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","+","3","*","1","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_AutoAddMultipleHandling_4() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","1","+","22",")","+","3","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"1","22","+","3","1","22","+","*","+"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_AutoAddMultipleHandling_5() {
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
	public void testInfixToPostfix_negativeSignHandling_1() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","(","-","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","0","1","-","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_negativeSignHandling_2() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","3","*","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"0","3","-","1","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_negativeSignHandling_3() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","3","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"0","3","1","22","+","*","-"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_negativeSignHandling_4() {
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
	public void testInfixToPostfix_prefixOperatorHandling_1() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"cos","30"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {" ","30","cos"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_prefixOperatorHandling_2() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"cot","30","+","2"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {" ","30","cot","2","+"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_prefixOperatorHandling_3() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","(","csc","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3"," ","1","csc","22","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_prefixOperatorHandling_4() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","(","1","+","sec","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","1"," ","22","sec","+","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_prefixOperatorHandling_5() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","*","tan","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3"," ","1","22","+","tan","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_prefixOperatorHandling_6() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"3","sin","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3"," ","1","22","+","sin","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_prefixOperatorHandling_7() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","sin","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"0"," ","1","22","+","sin","-"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_prefixOperatorHandling_8() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"-","sin","-","30"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"0"," ","0","30","-","sin","-"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_prefixOperatorHandling_9() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","3","/","4",")" ,"tan","(","1","+","22",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"3","4","/"," ","1","22","+","tan","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	// Case: postfix operator handling
	public void testInfixToPostfix_postfixOperatorHandling_1() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"30","!"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"30"," ","!"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_postfixOperatorHandling_2() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"30","!","*","4"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"30"," ","!","4","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_postfixOperatorHandling_3() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"30","!","4"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"30"," ","!","4","*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_postfixOperatorHandling_4() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"30","!","(","4","!",")"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"30"," ","!","4"," ","!" ,"*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_postfixOperatorHandling_5() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"30","!","4","!"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"30"," ","!","4"," ","!" ,"*"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}

	public void testInfixToPostfix_postfixOperatorHandling_6() {
		ArrayList<String> input = new ArrayList<String>();
		String[] inArray = {"(","30","+","1",")","!"};
		Collections.addAll(input,inArray);
		ArrayList<String> expected = new ArrayList<String>();
		String[] outArray = {"30","1","+"," ","!"};
		Collections.addAll(expected,outArray);
		ArrayList<String> actual = AffixConverter.toPostfix(input);
		assertEquals(expected, actual);
	}
}
