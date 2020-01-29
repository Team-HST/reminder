package com.hst.reminder.member.domain.exception;

import com.hst.reminder.common.exception.NotFoundException;

/**
 * @author dlgusrb0808@gmail.com
 */
public class MemberNotFoundException extends NotFoundException {
	private static final long serialVersionUID = -5443619991547614625L;

	public MemberNotFoundException(Long id) {
		super("Member", id);
	}
}
