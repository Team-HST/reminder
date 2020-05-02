package com.hst.reminder.channel.domain;

import java.util.List;
import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface ChannelRepository {

	Optional<Channel> findById(Long channelId);

	Channel save(Channel channel);

	List<Channel> findByMemberId(Long memberId);

	void delete(Channel channel);

	void deleteByIdIn(List<Long> channelIds);
}
