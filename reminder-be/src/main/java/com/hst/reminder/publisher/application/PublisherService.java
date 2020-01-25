package com.hst.reminder.publisher.application;

import com.hst.reminder.publisher.domain.Publisher;
import com.hst.reminder.publisher.domain.PublisherRepository;
import com.hst.reminder.publisher.domain.exception.PublisherNotFoundException;
import com.hst.reminder.publisher.ui.request.CreatePublisherRequest;
import com.hst.reminder.publisher.ui.response.PublisherResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class PublisherService {

	private final PublisherRepository publisherRepository;

	public PublisherService(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}

	/***
	 * 발행자 생성
	 * @param request 발행자 생성 요청
	 * @return 생성된 발행자 ID
	 */
	public Long createPublisher(CreatePublisherRequest request) {
		Publisher publisher = new Publisher(request.getMemberId(), request.getProtocol(), request.getTarget(),
				request.getParameters());
		publisherRepository.save(publisher);
		return publisher.getId();
	}

	/***
	 * 발행자 조회
	 * @param publisherId 발행자 ID
	 * @return 발행자
	 */
	public PublisherResponse getPublisher(Long publisherId) {
		Optional<Publisher> publisherOpt = publisherRepository.findById(publisherId);
		if (!publisherOpt.isPresent())
			throw new PublisherNotFoundException("발행자 정보를 찾을수 없습니다. publisherId: %d", publisherId);
		return publisherOpt.map(PublisherResponse::of).get();
	}
}
