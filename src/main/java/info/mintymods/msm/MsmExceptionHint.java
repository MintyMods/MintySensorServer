package info.mintymods.msm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import info.mintymods.utils.MintyJsonUtils;

public class MsmExceptionHint {

	private String message;
	private String input;
	private String output;
	private String result;

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("input")
	public String getInput() {
		return input;
	}

	@JsonProperty("input")
	public void setInput(String input) {
		this.input = input;
	}

	@JsonProperty("output")
	public String getOutput() {
		return output;
	}

	@JsonProperty("output")
	public void setOutput(String output) {
		this.output = output;
	}

	@JsonProperty("result")
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
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
