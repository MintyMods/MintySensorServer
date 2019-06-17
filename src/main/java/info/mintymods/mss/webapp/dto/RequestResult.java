package info.mintymods.mss.webapp.dto;

public class RequestResult {

	boolean success;
	String message;

	public boolean isSuccess() { return this.success; }

	public String getMessage() { return this.message; }

	public void setSuccess(final boolean success) { this.success = success; }

	public void setMessage(final String message) { this.message = message; }

	@java.lang.Override
	public java.lang.String toString() {
		return "RequestResult(success=" + this.isSuccess() + ", message=" + this.getMessage() + ")";
	}

	public RequestResult(final boolean success, final String message) {
		this.success = success;
		this.message = message;
	}
}
