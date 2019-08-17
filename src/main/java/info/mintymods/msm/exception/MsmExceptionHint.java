package info.mintymods.msm.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmExceptionHint {

	private String message;
	private String input;
	private String output;
	private String result;

	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	public String getInput() {
		return input;
	}

	@JsonProperty("input")
	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	@JsonProperty("output")
	public void setOutput(String output) {
		this.output = output;
	}

	public String getResult() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		try {
			return MintyJsonUtils.getMapper().writeValueAsString(this);
		} catch (final JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
