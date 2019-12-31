package com.hst.reminder.common.exception.handler;

import com.hst.reminder.security.exception.InvalidTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidTokenException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public String handleInvalidTokenException() {
		return null;
	}

}
