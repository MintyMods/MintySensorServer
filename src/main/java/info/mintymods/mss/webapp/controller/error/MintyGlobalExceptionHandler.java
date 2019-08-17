package info.mintymods.mss.webapp.controller.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import info.mintymods.mss.webapp.exception.MsmServiceProviderUnavailableException;

@ControllerAdvice
public class MintyGlobalExceptionHandler {

	@ExceptionHandler(MsmServiceProviderUnavailableException.class)
	public ResponseEntity<MintyErrorResponse> customHandleNotFound(final Exception ex, final WebRequest request) {
		final MintyErrorResponse errors = new MintyErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
		return new ResponseEntity<>(errors, HttpStatus.SERVICE_UNAVAILABLE);
	}
}
