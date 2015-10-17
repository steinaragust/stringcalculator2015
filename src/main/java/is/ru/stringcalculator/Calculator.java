package is.ru.stringcalculator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import is.ru.stringcalculator.*;
import org.apache.commons.lang3.StringUtils;

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
		String numbers[] = splitString(text);
		int result = 0, number;
		List<String> negativeNumbers = new ArrayList<String>();
		for(int i = 0; i < numbers.length; i++){
			number = Integer.parseInt(numbers[i]);
			if(number < 0){
				negativeNumbers.add(numbers[i]);
			}
			else if(number < 1001){
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
		if(result == 0){
			return 0;
		}
		return result;
	}

	public String[] splitString(String text){
		if(!Character.isDigit(text.charAt(0)) && text.charAt(0) != '-'){
			String del[] = text.split("\n", 2);
			text = del[1];
			del[0] = del[0].substring(1);
			if(del[0].charAt(0) == '['){
				String delimits = "";
			    Pattern p = Pattern.compile("\\[(.*?)\\]");
				Matcher m = p.matcher(del[0]);
				while(m.find()) {
					delimits += StringUtils.repeat(("\\" + m.group(1).charAt(0)), m.group(1).length()) + "|";
				}
				delimits = delimits.substring(0, delimits.length() - 1);
				return text.split(delimits);	
			}
			return text.split(del[0]);
		}
		return text.split(",|\\\n");
	}
}