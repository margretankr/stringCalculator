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
	public void testNegativeNumbersVol2(){
		assertEquals("Negatives not allowed: -5", Calculator.add("2,-5,100"));

	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNegativeNumbersVol3(){
		assertEquals("Negatives not allowed: -2, -5", Calculator.add("-2,-5,100"));
	}

	@Test
	public void testBigNumber() {
		assertEquals(5, Calculator.add("9000,5"));
	}

	@Test 
	public void testBigNumberVol2(){
		assertEquals(0,Calculator.add("10000,4000"));
	}

	@Test 
	public void testDelimiterOfAnyLength(){
		assertEquals(6,Calculator.add("//[...]\n1...2...3"));
	}

	@Test
	public void testMultipleDelimiters(){
		assertEquals(6,Calculator.add("//[*][%]\n1*2%3"));

	}

	@Test
	public void testMultipleDelimitersOfAnyLenght(){
		assertEquals(6,Calculator.add("//[***][%%%]\n1***2%%%3"));

	}




}