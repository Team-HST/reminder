package com.hst.reminder.common.exception.handler;

import com.hst.reminder.common.exception.ErrorDescription;
import com.hst.reminder.common.exception.ReportableException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ReportableException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDescription handleInvalidTokenException(ReportableException e) {
		return ErrorDescription.internalServerError(e);
	}

}
