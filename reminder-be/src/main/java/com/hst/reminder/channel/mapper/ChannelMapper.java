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

	/***
	 * 채널 Entity를 조회 API응답으로 변환
	 * @param channel 채널 entity
	 * @return 조회 API Format
	 */
	public static ChannelResponse toChannelResponse(Channel channel) {
		return ChannelResponse.builder()
				.id(channel.getId())
				.title(channel.getTitle())
				.description(channel.getDescription())
				.active(channel.getActive())
				.ownerId(channel.getMemberId())
				.createdDate(channel.getCreatedDate())
				.modifiedDate(channel.getModifiedDate())
				.build();
	}

}
