package is.ru.stringcalculator;
import java.lang.Exception;

public class NegativeException extends Exception {
	public NegativeException(String message) {
		super(message);
	}
}