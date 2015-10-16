package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testAdd() {
		assertEquals(0, Calculator.add(""));
		assertEquals(1, Calculator.add("1"));
		assertEquals(8, Calculator.add("3,5"));
	}
}