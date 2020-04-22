package com.hst.reminder.channel.ui.response;

import com.hst.reminder.channel.domain.Channel;
import com.hst.reminder.channel.mapper.ChannelMapper;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
public class ChannelListResponse {
	@ApiModelProperty(position = 1, value = "채널 목록")
	private List<ChannelResponse> channels;

	public List<ChannelResponse> getChannels() {
		return channels;
	}

	public static ChannelListResponse from(List<Channel> channels) {
		ChannelListResponse response = new ChannelListResponse();
		response.channels = channels.stream().map(ChannelMapper::toChannelResponse).collect(Collectors.toList());
		return response;
	}
}
