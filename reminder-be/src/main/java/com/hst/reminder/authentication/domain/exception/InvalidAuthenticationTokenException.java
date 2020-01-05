package com.hst.reminder.authentication.domain.exception;

import com.hst.reminder.common.exception.ReportableException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author dlgusrb0808@gmail.com
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidAuthenticationTokenException extends ReportableException {
	public InvalidAuthenticationTokenException(String message, Object... args) {
		super(message, args);
	}
}
