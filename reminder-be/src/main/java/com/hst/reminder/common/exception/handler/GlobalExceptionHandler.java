package com.hst.reminder.common.exception.handler;

import com.hst.reminder.common.exception.ErrorDescription;
import com.hst.reminder.common.exception.ReportableException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ReportableException.class)
	public ResponseEntity<ErrorDescription> handleInvalidTokenException(ReportableException e) {
		ErrorDescription error = e.toErrorDescription();
		return ResponseEntity.status(error.getStatusCode()).body(error);
	}

}
