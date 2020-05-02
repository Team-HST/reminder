package com.hst.reminder.channel.application.exceptionn;

import com.hst.reminder.common.exception.NotFoundException;

/**
 * @author dlgusrb0808@gmail.com
 */
public class ChannelNotFoundException extends NotFoundException {
	private static final long serialVersionUID = -1061467291984693280L;

	public ChannelNotFoundException(Long id) {
		super("Channel", id);
	}
}
