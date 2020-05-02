package com.hst.reminder.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author dlgusrb0808@gmail.com
 */
public class ForbiddenException extends ReportableException {
	private static final long serialVersionUID = 4277415668534140140L;

	public ForbiddenException(String message, Object... args) {
		super(message, args);
	}

	@Override
	public ErrorDescription toErrorDescription() {
		return ErrorDescription.create(HttpStatus.FORBIDDEN, this);
	}
}
