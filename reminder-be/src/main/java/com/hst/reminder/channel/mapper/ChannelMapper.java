package com.hst.reminder.channel.mapper;

import com.hst.reminder.channel.domain.Channel;
import com.hst.reminder.channel.ui.response.ChannelResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author dlgusrb0808@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChannelMapper {

	public static ChannelResponse toChannelResponse(Channel channel) {
		return ChannelResponse.builder()
				.id(channel.getId())
				.title(channel.getTitle())
				.description(channel.getDescription())
				.ownerId(channel.getMemberId())
				.createdDate(channel.getCreatedDate())
				.modifiedDate(channel.getModifiedDate())
				.build();
	}

}
