package com.hst.reminder.publisher.domain.exception;

import com.hst.reminder.common.exception.ReportableException;

/**
 * @author dlgusrb0808@gmail.com
 */
public class PublisherNotFoundException extends ReportableException {
	private static final long serialVersionUID = -4849616454050079202L;
	public PublisherNotFoundException(String message, Object... args) {
		super(message, args);
	}
}
