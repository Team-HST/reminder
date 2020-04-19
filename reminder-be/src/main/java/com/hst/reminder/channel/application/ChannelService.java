package com.hst.reminder.channel.application;

import com.hst.reminder.channel.domain.ChannelRepository;
import org.springframework.stereotype.Service;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class ChannelService {
	private final ChannelRepository channelRepository;

	public ChannelService(ChannelRepository channelRepository) {
		this.channelRepository = channelRepository;
	}
}
