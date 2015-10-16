package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
    /* First step */
	@Test
	public void testAdd() {
		assertEquals(0, Calculator.add(""));
		assertEquals(1, Calculator.add("1"));
		assertEquals(8, Calculator.add("3,5"));
	}

	/* Second step */
	@Test
	public void testAddTriangle() {
		String test = "";
		for(int i = 1; i < 99; i++){
			test += Integer.toString(i) + ",";
		}
		test += Integer.toString(99);
		assertEquals(4950, Calculator.add(test));
	}

	/* Third step */
	@Test
	public void testAddTriangleNL() {
		String test = "";
		for(int i = 1; i < 99; i++){
			if(i % 2 == 0){
				test += Integer.toString(i) + "\n";
			}
			else{
				test += Integer.toString(i) + ",";
			}
		}
		test += Integer.toString(99);
		assertEquals(4950, Calculator.add(test));
	}

	/* Fourth step */
	@Test
	public void testAddTriangleDL() {
		String test = "\\;\n";
		for(int i = 1; i < 99; i++){
			test += Integer.toString(i) + ";";
		}
		test += Integer.toString(99);
		assertEquals(4950, Calculator.add(test));

		test = "\\!\n";
		for(int i = 1; i < 99; i++){
			test += Integer.toString(i) + "!";
		}
		test += Integer.toString(99);
		assertEquals(4950, Calculator.add(test));
	}


}