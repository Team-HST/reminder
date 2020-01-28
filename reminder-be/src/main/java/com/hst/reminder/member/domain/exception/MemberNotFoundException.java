package com.hst.reminder.member.domain.exception;

import com.hst.reminder.common.exception.ReportableException;

/**
 * @author dlgusrb0808@gmail.com
 */
public class MemberNotFoundException extends ReportableException {
	private static final long serialVersionUID = -5443619991547614625L;

	public MemberNotFoundException(String message, Object... args) {
		super(message, args);
	}
}
