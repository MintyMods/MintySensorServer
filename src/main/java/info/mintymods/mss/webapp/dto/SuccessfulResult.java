package info.mintymods.mss.webapp.dto;

public class SuccessfulResult extends RequestResult {

	public SuccessfulResult() {
		super(true, null);
	}

	public SuccessfulResult(String message) {
		super(true, message);
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "SuccessfulResult()";
	}
}
