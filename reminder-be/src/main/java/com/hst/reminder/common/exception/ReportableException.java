package com.hst.reminder.common.exception;

/**
 * @author dlgusrb0808@gmail.com
 */
public abstract class ReportableException extends RuntimeException {
	private static final long serialVersionUID = -52870795050449474L;

	public ReportableException(String message, Object...args) {
		super(String.format(message, args));
	}

	public ReportableException(Exception cause) {
		super(cause);
	}

	public abstract ErrorDescription toErrorDescription();
}
