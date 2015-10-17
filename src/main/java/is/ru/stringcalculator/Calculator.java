package is.ru.stringcalculator;
import java.util.*;
import is.ru.stringcalculator.*;

public class Calculator {

	public Calculator(){

	}

	public int add(String text)throws NegativeException{
		int sum = 0;
		if(text.equals("")){
			return 0;
		}
		else{
			try{
				sum = getSumOfMultiple(text);
			}
			catch(NegativeException e){
				throw e;
			}
		}
		return sum;
	}

	public int getSumOfMultiple(String text) throws NegativeException{
		String numbers[];
		List<String> negativeNumbers = new ArrayList<String>();
		if(!Character.isDigit(text.charAt(0)) && text.charAt(0) != '-'){
			char del = text.charAt(1);
			text = text.substring(3);
			numbers = text.split(Character.toString(del));
		}
		else{
			numbers = text.split(",|\\\n");
		}
		int result = 0;
		int number;
		for(int i = 0; i < numbers.length; i++){
			number = Integer.parseInt(numbers[i]);
			if(number < 0){
				negativeNumbers.add(numbers[i]);
			}
			else{
				result += number;
			}
		}
		if(!negativeNumbers.isEmpty()){
			String message = "";
			for(int i = 0; i < negativeNumbers.size() - 1; i++){
				message += negativeNumbers.get(i) + ",";
			}
			message += negativeNumbers.get(negativeNumbers.size() - 1);
			throw new NegativeException("Negatives not allowed: " + message);
		}
		return result;
	}
}