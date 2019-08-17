package info.mintymods.mss.webapp.exception;

public class MsmServiceProviderUnavailableException extends MsmServiceProviderException {

	private static final long serialVersionUID = -2270798632327163432L;

	@SuppressWarnings("unused")
	private MsmServiceProviderUnavailableException() {
	}

	public MsmServiceProviderUnavailableException(String message, Exception exception) {
		super(message, exception);
	}
}
