package ash.com.exceptions;

import java.io.IOException;

public class CheckedException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3420342941626327502L;
	
	public CheckedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CheckedException(String message) {
		super(message);
	}
}
