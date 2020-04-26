package com.hst.reminder.channel.application;

import com.hst.reminder.channel.domain.Channel;
import com.hst.reminder.channel.domain.ChannelPublisher;
import com.hst.reminder.channel.domain.ChannelPublisherRepository;
import com.hst.reminder.channel.domain.ChannelRepository;
import com.hst.reminder.channel.ui.request.ChannelModifyingRequest;
import com.hst.reminder.channel.ui.response.ChannelListResponse;
import com.hst.reminder.publisher.application.PublisherService;
import com.hst.reminder.publisher.domain.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
public class ChannelService {
	private final ChannelRepository channelRepository;
	private final ChannelPublisherRepository channelPublisherRepository;
	private final PublisherService publisherService;

	/***
	 * 회원이 등록한 채널 조회
	 * @param memberId 회원 ID
	 * @return 채널 목록
	 */
	public ChannelListResponse getChannelsByMemberId(Long memberId) {
		List<Channel> channels = channelRepository.findByMemberId(memberId);
		return ChannelListResponse.from(channels);
	}

	/***
	 * 채널 등록
	 * @param request 채널 등록 요청
	 * @return 등록된 채널 ID
	 */
	@Transactional
	public Long createChannel(ChannelModifyingRequest request) {
		Channel channel = channelRepository.save(Channel.from(request));
		for (Long publisherId : request.getPublisherIds()) {
			Publisher publisher = publisherService.findPublisher(publisherId);
			channelPublisherRepository.save(ChannelPublisher.of(channel, publisher));
		}
		return channel.getId();
	}
}
