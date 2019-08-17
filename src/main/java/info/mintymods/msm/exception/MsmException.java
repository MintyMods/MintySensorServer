package info.mintymods.msm.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmException {

	private MsmNativeException exception;
	private MsmNativeException innerException;
	private MsmStackTrace stackTrace;
	private String message;
	private String helpLink;
	private String source;
	private int hResult;
	private MsmExceptionHint hint;
	private MsmExceptionData data;

	public MsmNativeException getException() {
		return exception;
	}

	@JsonProperty("exception")
	public void setException(MsmNativeException exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	public MsmExceptionHint getHint() {
		return hint;
	}

	@JsonProperty("hint")
	public void setHint(MsmExceptionHint hint) {
		this.hint = hint;
	}

	public MsmExceptionData getDate() {
		return data;
	}

	@JsonProperty("data")
	public void setDate(MsmExceptionData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		try {
			return MintyJsonUtils.getMapper().writeValueAsString(this);
		} catch (final JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public MsmNativeException getInnerException() {
		return innerException;
	}

	@JsonProperty("InnerException")
	public void setInnerException(MsmNativeException innerException) {
		this.innerException = innerException;
	}

	public MsmStackTrace getStackTrace() {
		return stackTrace;
	}

	@JsonProperty("StackTrace")
	public void setStackTrace(MsmStackTrace stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getHelpLink() {
		return helpLink;
	}

	@JsonProperty("HelpLink")
	public void setHelpLink(String helpLink) {
		this.helpLink = helpLink;
	}

	public String getSource() {
		return source;
	}

	@JsonProperty("Source")
	public void setSource(String source) {
		this.source = source;
	}

	public int gethResult() {
		return hResult;
	}

	@JsonProperty("HResult")
	public void sethResult(int hResult) {
		this.hResult = hResult;
	}
}
