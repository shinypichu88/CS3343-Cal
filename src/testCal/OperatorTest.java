package testCal;

import junit.framework.TestCase;
import cal.Addition;
import cal.Division;
import cal.Exponentiation;
import cal.Multiplication;
import cal.Operator;
import cal.Subtraction;
import cal.TrigoOperator;

public class OperatorTest extends TestCase{

	  private Operator factory;
	  
	  @Override
	public void tearDown() throws Exception {
	    factory = null;
	  }
	  
	  public void testCalculate1() {
		double expected = 3+4;
		factory = new Addition();
	    double actual = factory.calculate(3, 4);
	    assertEquals(expected, actual);
	  }
	  
	  public void testCalculate2() {
		double expected = 5-2;
		factory = new Subtraction();
	    double actual = factory.calculate(5, 2);
	    assertEquals(expected, actual);
	  }
	  
	  public void testCalculate3() {
		double expected = 4*5;
		factory = new Multiplication();
	    double actual = factory.calculate(4, 5);
	    assertEquals(expected, actual);
	  }
	  
	  public void testCalculate4() {
		double expected = 4/2;
		factory = new Division();
	    double actual = factory.calculate(4, 2);
	    assertEquals(expected, actual);
	  }
	  
	  public void testCalculate5() {
		double expected = Math.pow(2, 4);
		factory = new Exponentiation();
	    double actual = factory.calculate(2, 4);
	    assertEquals(expected, actual);
	  }
	  
	  public void testCalculate6(){
		  class StubSine extends TrigoOperator{
				public StubSine() {
					super("sin");	
				}

				@Override
				public double calculate(double val1, double val2) {
					return Math.sin(val2);
				}
			}
		  double expected = 0.5;
		  factory = new StubSine();
		  double actual = factory.calculate(0, 30);
		  assertEquals(expected, actual);
	  }
	  
	  public void testCalculate7(){
		  class StubCosine extends TrigoOperator{
				public StubCosine() {
					super("cos");	
				}

				@Override
				public double calculate(double val1, double val2) {
					return Math.cos(val2);
				}
			}
		  double expected = 0.5;
		  factory = new StubCosine();
		  double actual = factory.calculate(0, 60);
		  assertEquals(expected, actual);
	  }
	  
	  public void testCalculate8(){
		  class StubTangent extends TrigoOperator{
				public StubTangent() {
					super("tan");	
				}

				@Override
				public double calculate(double val1, double val2) {
					return Math.tan(val2);
				}
			}
		  double expected = 1;
		  factory = new StubTangent();
		  double actual = factory.calculate(0, 45);
		  assertEquals(expected, actual);
	  }
	  
}
