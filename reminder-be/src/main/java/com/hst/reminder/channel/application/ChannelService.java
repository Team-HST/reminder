package com.hst.reminder.channel.application;

import com.hst.reminder.channel.domain.Channel;
import com.hst.reminder.channel.domain.ChannelRepository;
import com.hst.reminder.channel.ui.response.ChannelListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class ChannelService {
	private final ChannelRepository channelRepository;

	public ChannelService(ChannelRepository channelRepository) {
		this.channelRepository = channelRepository;
	}

	/***
	 * 회원이 등록한 채널 조회
	 * @param memberId 회원 ID
	 * @return 채널 목록
	 */
	public ChannelListResponse getChannelsByMemberId(Long memberId) {
		List<Channel> channels = channelRepository.findByMemberId(memberId);
		return ChannelListResponse.from(channels);
	}

}
