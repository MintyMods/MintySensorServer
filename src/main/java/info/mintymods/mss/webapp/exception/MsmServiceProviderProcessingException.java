package info.mintymods.mss.webapp.exception;

public class MsmServiceProviderProcessingException extends MsmServiceProviderException {

	private static final long serialVersionUID = -2838923592480733222L;

	@SuppressWarnings("unused")
	private MsmServiceProviderProcessingException() {
	}

	public MsmServiceProviderProcessingException(String message, Exception exception) {
		super(message, exception);
	}
}
