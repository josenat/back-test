package renfe.com.pdf.core;

public class InternalErrorException extends Exception {
	
	public InternalErrorException() {
		super();
	}

	public InternalErrorException(String message) {
		super(message);
	}
 
	public InternalErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public InternalErrorException(Throwable cause) {
		super(cause);
	}
}
