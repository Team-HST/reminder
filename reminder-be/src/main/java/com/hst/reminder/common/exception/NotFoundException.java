package com.hst.reminder.common.exception;

/**
 * @author dlgusrb0808@gmail.com
 */
public class NotFoundException extends ReportableException {
	private static final long serialVersionUID = 9066291726475966430L;

	public NotFoundException(Object... args) {
		super("%s(Id: %s)를 찾을 수 없습니다.", args);
	}
}
