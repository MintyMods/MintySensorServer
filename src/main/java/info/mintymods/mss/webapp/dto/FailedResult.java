package info.mintymods.mss.webapp.dto;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class FailedResult extends RequestResult {

	private Map<String, String> errors;

	public FailedResult() {
		super(false, null);
	}

	public FailedResult(BindingResult bindingResult) {
		super(false, null);
		errorsToMap(bindingResult);
	}

	public FailedResult(String message, BindingResult bindingResult) {
		super(false, message);
		errorsToMap(bindingResult);
	}

	public FailedResult(String message) {
		super(false, message);
	}

	private void errorsToMap(BindingResult bindingResult) {
		errors = bindingResult.getFieldErrors().stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
	}

	public Map<String, String> getErrors() { return this.errors; }

	public void setErrors(final Map<String, String> errors) { this.errors = errors; }

	@java.lang.Override
	public java.lang.String toString() {
		return "FailedResult(errors=" + this.getErrors() + ")";
	}
}
