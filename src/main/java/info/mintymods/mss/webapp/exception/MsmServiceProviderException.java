package info.mintymods.mss.webapp.exception;

public class MsmServiceProviderException extends RuntimeException {

	private static final long serialVersionUID = -4954278198730709922L;

	public MsmServiceProviderException() {
		super();
	}

	public MsmServiceProviderException(String message) {
		super(message);
	}

	public MsmServiceProviderException(Throwable cause) {
		super(cause);
	}

	public MsmServiceProviderException(String message, Throwable cause) {
		super(message, cause);
	}

	public MsmServiceProviderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}