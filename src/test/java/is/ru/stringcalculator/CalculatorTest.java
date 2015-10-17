package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import is.ru.stringcalculator.*;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
    Calculator calc = new Calculator();
    /* First step */
	@Test
	public void testAdd() throws NegativeException{
		assertEquals(0, calc.add(""));
		assertEquals(1, calc.add("1"));
		assertEquals(8, calc.add("3,5"));
	}

	/* Second step */
	@Test
	public void testAddTriangle() throws NegativeException{
		String test = "";
		for(int i = 1; i < 99; i++){
			test += Integer.toString(i) + ",";
		}
		test += Integer.toString(99);
		assertEquals(4950, calc.add(test));
	}

	/* Third step */
	@Test
	public void testAddTriangleNL() throws NegativeException{
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
		assertEquals(4950, calc.add(test));
	}

	/* Fourth step */
	@Test
	public void testAddTriangleDL() throws NegativeException{
		String test = "\\;\n";
		for(int i = 1; i < 99; i++){
			test += Integer.toString(i) + ";";
		}
		test += Integer.toString(99);
		assertEquals(4950, calc.add(test));

		test = "\\!\n";
		for(int i = 1; i < 99; i++){
			test += Integer.toString(i) + "!";
		}
		test += Integer.toString(99);
		assertEquals(4950, calc.add(test));
	}

	/*Fifth step */
	@Test
	public void testTriangleN(){
		String test = "\\;\n-1";
		int n;
		try{
			n = calc.add(test);
		}
		catch(NegativeException e){
			System.out.println(e.getMessage());
			assertEquals(NegativeException.class, e.getClass());
		}
		test = "";
		for(int i = 1; i < 99; i++){
			if(i % 2 == 0){
				test += "-" + Integer.toString(i) + "\n";
			}
			else{
				test += Integer.toString(i) + ",";
			}
		}
		test += Integer.toString(99);
		try{
			n = calc.add(test);
		}
		catch(NegativeException e){
			System.out.println(e.getMessage());
			assertEquals(NegativeException.class, e.getClass());
		}
	}

	/* Sixth step */
	@Test
	public void testAddTriangleDL() throws NegativeException{
		String test = "\\;\n";
		for(int i = 1; i < 2001; i++){
			test += Integer.toString(i) + ";";
		}
		test += Integer.toString(2000);
		assertEquals(500500, calc.add(test));
		test = "1001";
		assertEquals(0, calc.add(test));
	}