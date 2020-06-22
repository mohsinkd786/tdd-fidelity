package apis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalculatorApiTest {

	double first;
	double next;
	
	@BeforeEach
	public void startUp() {
		first = 10;
		next = 12;
	}
	
	@Test
	public void testCalculateSum() {
		CalculatorApi calculatorApi = new CalculatorApi();
		double sum = calculatorApi.calculate("SUM", first, next);
		//Assert.assertEq
		assertEquals(sum, first + next);
	}
	
	@Test
	public void testCalculateDiff() {
		CalculatorApi calculatorApi = new CalculatorApi();
		double result = calculatorApi.calculate("DIF", first, next);
		//Assert.assertEq
		assertEquals(result, first - next);
	}
}
