package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.length() == 1){
			return Integer.parseInt(text);
		}
		else{
			return getSumOfMultiple(text);
		}
	}

	public static int getSumOfMultiple(String text){
		String numbers[] = text.split(",|\\\n");
		int result = 0;
		for(int i = 0; i < numbers.length; i++){
			result += Integer.parseInt(numbers[i]);
		}
		return result;
	}
}