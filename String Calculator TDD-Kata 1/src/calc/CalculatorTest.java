package calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void empty_string()
	{
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	public void single_argument()
	{
		assertEquals(2, Calculator.add("2"));
	}
	
	@Test
	public void sum_of_two_numbers()
	{
		assertEquals(5, Calculator.add("3,2"));
	}

	@Test
	public void sum_of_more_numbers()
	{
		assertEquals(16, Calculator.add("1,3,5,7"));
	}
	
	@Test
	public void new_line_as_delimeter()
	{
		assertEquals(12, Calculator.add("2\n4,6"));
	}
	
	@Test
	public void accept_custom_delimeter()
	{
		assertEquals(8, Calculator.add("//;\n4;4"));
	}
	
	@Test
	public void raiseExceptionOnNegativeNumbers()
	{
		try {
			Calculator.add("1,-2,-3");
			fail("Exception is expected.");
		}
		
		catch(RuntimeException e)
		{
			assertEquals("Negative numbers are not allowed: [-2, -3]", e.getMessage());
		}
	}
	
	@Test
	public void ignore_greater_than_1000_numbers()
	{
		assertEquals(4, Calculator.add("4,3000"));
	}
	
	@Test
	public void accept_any_lenght_delimeter()
	{
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	
}
