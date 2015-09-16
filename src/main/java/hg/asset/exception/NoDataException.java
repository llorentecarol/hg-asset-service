package hg.asset.exception;

public class NoDataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataException() {
		super();
	}

	public NoDataException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoDataException(String message) {
		super(message);
	}

	public NoDataException(Throwable cause) {
		super(cause);
	}

}
