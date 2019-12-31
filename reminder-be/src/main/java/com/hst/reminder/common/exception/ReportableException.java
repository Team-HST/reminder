package com.hst.reminder.common.exception;

/**
 * @author dlgusrb0808@gmail.com
 */
public class ReportableException extends RuntimeException {

	public ReportableException(String message, Object...args) {
		super(String.format(message, args));
	}

	public ReportableException(Exception cause) {
		super(cause);
	}

}
