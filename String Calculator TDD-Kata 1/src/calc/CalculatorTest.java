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

}