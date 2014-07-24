package ca.bcit.comp2613.a00192788.util.except;

@SuppressWarnings("serial")
public class IllegalLengthException extends RuntimeException {

	public IllegalLengthException() {
		super();
	}
	public IllegalLengthException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalLengthException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalLengthException(String message) {
		super(message);
	}

	public IllegalLengthException(Throwable cause) {
		super(cause);
	}

}
