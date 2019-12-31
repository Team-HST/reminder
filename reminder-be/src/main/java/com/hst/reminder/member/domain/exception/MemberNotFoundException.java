package com.hst.reminder.member.domain.exception;

import com.hst.reminder.common.exception.ReportableException;

/**
 * @author dlgusrb0808@gmail.com
 */
public class MemberNotFoundException extends ReportableException {
	public MemberNotFoundException(String message, Object... args) {
		super(message, args);
	}
}
