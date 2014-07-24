package ca.bcit.comp2613.a00192788.util.except;

@SuppressWarnings("serial")
public class IllegalSizeException extends Exception {

	public IllegalSizeException() {
		super();
	}

	public IllegalSizeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalSizeException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalSizeException(String message) {
		super(message);
	}

	public IllegalSizeException(Throwable cause) {
		super(cause);
	}

}
