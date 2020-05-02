package com.hst.reminder.authentication.application.exception;

import com.hst.reminder.common.exception.ErrorDescription;
import com.hst.reminder.common.exception.ReportableException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author dlgusrb0808@gmail.com
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidAuthenticationTokenException extends ReportableException {
	private static final long serialVersionUID = 4370982065562193777L;

	public InvalidAuthenticationTokenException(String message, Object... args) {
		super(message, args);
	}

	@Override
	public ErrorDescription toErrorDescription() {
		return ErrorDescription.create(HttpStatus.NOT_ACCEPTABLE, this);
	}
}
