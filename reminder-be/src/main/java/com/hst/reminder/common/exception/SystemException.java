package com.hst.reminder.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author dlgusrb0808@gmail.com
 */
public class SystemException extends ReportableException {
	private static final long serialVersionUID = -5318222511546494076L;

	public SystemException(Exception cause) {
		super(cause);
	}

	@Override
	public ErrorDescription toErrorDescription() {
		return ErrorDescription.create(HttpStatus.INTERNAL_SERVER_ERROR, this);
	}
}
