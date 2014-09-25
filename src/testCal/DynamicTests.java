package testCal;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import cal.Calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DynamicTests extends TestCase {

    private String expected;
    private String input;

    public DynamicTests(String input, String expected) {
	this.expected = expected;
	this.input = input;
	setName(input);
    }

    protected void runTest() throws Throwable {
	Calculator calculator = new Calculator();
	calculator.setInputExpression(input);
	String actual = calculator.execute();
	assertEquals(expected, actual);
    }

    public static TestSuite suite() {
	TestSuite suite = new TestSuite(DynamicTests.class.getName());
	String filePath = new File("").getAbsolutePath();
	BufferedReader br = null;
	String line = "";
	try {
	    br = new BufferedReader(new FileReader(filePath+"/DataSet.csv"));
	    while ((line = br.readLine()) != null) {
		String[] data = line.split(",");
		suite.addTest(new DynamicTests(data[0], data[1]));
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (br != null) {
		try {
		    br.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}

	return suite;
    }

}
