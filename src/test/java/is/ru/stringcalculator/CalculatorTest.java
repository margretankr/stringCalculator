package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
	
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test 
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test 
	public void testTwoNumber(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers(){
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testNewLine(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}


	@Test
	public void testDelimiter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testDelimitervol2(){
		assertEquals(3, Calculator.add("//!\n1!2"));
	}

	@Test
	(expected = IllegalArgumentException.class)
	public void testNegativeNumbers(){
		assertEquals("Negatives not allowed: -1", Calculator.add("//,\n-1,1000"));

	}

	@Test
	(expected = IllegalArgumentException.class)
	public void testNegativeNumbersvol2(){
		assertEquals("Negatives not allowed: -5", Calculator.add("2,-5,100"));

	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNegativeNumbersvol3(){
		assertEquals("Negatives not allowed: -2, -5", Calculator.add("-2,-5,100"));
	}









}