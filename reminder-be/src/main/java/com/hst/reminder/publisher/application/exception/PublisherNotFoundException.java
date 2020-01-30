package com.hst.reminder.publisher.application.exception;

import com.hst.reminder.common.exception.NotFoundException;

/**
 * @author dlgusrb0808@gmail.com
 */
public class PublisherNotFoundException extends NotFoundException {
	private static final long serialVersionUID = -4849616454050079202L;
	public PublisherNotFoundException(Long id) {
		super("Publisher", id);
	}
}
