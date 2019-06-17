package info.mintymods.msm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.mss.utils.MssJSONUtils;

public class MsmException {

	private Exception exception;
	private String message;
	private MsmExceptionHint hint;
	private Date date;

	@JsonProperty("exception")
	public Exception getException() {
		return exception;
	}

	@JsonProperty("exception")
	public void setException(Exception exception) {
		this.exception = exception;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("hint")
	public MsmExceptionHint getHint() {
		return hint;
	}

	@JsonProperty("hint")
	public void setHint(MsmExceptionHint hint) {
		this.hint = hint;
	}

	@JsonProperty("date")
	public Date getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		try {
			return MssJSONUtils.getMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
