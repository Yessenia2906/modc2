package pe.com.bn.modc.exceptions;

public class FtpException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1708116956816020065L;

	public FtpException() {
		super();
		 
	}

	public FtpException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		 
	}

	public FtpException(String message, Throwable cause) {
		super(message, cause);
		 
	}

	public FtpException(String message) {
		super(message);
		 
	}

	public FtpException(Throwable cause) {
		super(cause);
		 
	}

}
