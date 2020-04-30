package com.hst.reminder.channel.domain;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface ChannelPublisherRepository {
	List<ChannelPublisher> findAllByPublisherIdIn(List<Long> publisherIds);

	ChannelPublisher save(ChannelPublisher channelPublisher);

}
