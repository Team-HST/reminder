package com.hst.reminder.common.exception.handler;

import com.hst.reminder.common.exception.ErrorDescription;
import com.hst.reminder.common.exception.ReportableException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ReportableException.class)
	public ResponseEntity<ErrorDescription> handleGlobalException(ReportableException e) {
		ErrorDescription error = e.toErrorDescription();
		return ResponseEntity.status(error.getStatusCode()).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
														 WebRequest request) {
		ErrorDescription error = ErrorDescription.create(HttpStatus.BAD_REQUEST, ex.getBindingResult());
		return ResponseEntity.status(status).headers(headers).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDescription error = ErrorDescription.create(HttpStatus.BAD_REQUEST, ex.getBindingResult());
		return ResponseEntity.status(status).headers(headers).body(error);
	}
}
