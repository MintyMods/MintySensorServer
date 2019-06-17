package info.mintymods.mss.webapp.exception;

public class PasswordEmptyException extends RuntimeException {

	private static final long serialVersionUID = 5895472013943908642L;

	public PasswordEmptyException(String message) {
		super(message);
	}
}
