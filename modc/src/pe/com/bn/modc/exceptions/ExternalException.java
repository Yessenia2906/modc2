package pe.com.bn.modc.exceptions;

public class ExternalException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4571081733282918288L;

	public ExternalException() {
		super();
		 
	}

	public ExternalException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		 
	}

	public ExternalException(String message, Throwable cause) {
		super(message, cause);
		 
	}

	public ExternalException(String message) {
		super(message);
		 
	}

	public ExternalException(Throwable cause) {
		super(cause);
		 
	}

}
