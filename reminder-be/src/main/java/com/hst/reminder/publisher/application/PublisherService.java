package com.hst.reminder.publisher.application;

import com.hst.reminder.publisher.domain.Publisher;
import com.hst.reminder.publisher.domain.PublisherRepository;
import com.hst.reminder.publisher.domain.exception.PublisherNotFoundException;
import com.hst.reminder.publisher.ui.request.CreatePublisherRequest;
import com.hst.reminder.publisher.ui.response.PublisherListResponse;
import com.hst.reminder.publisher.ui.response.PublisherResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
	@Transactional
	public Long createPublisher(CreatePublisherRequest request) {
		Publisher publisher = new Publisher(request.getMemberId(), request.getProtocol(), request.getTarget(),
				request.getParameters(), request.getDescription());
		publisherRepository.save(publisher);
		return publisher.getId();
	}

	/***
	 * 멤버ID로 발행자 목록 조회
	 * @param memberId 멤버ID
	 * @return 발행자 목록
	 */
	public PublisherListResponse getPublishersByMemberId(Long memberId) {
		List<Publisher> publishers = publisherRepository.findByMemberId(memberId);
		return PublisherListResponse.of(publishers);
	}

	/***
	 * 발행자 조회
	 * @param publisherId 발행자 ID
	 * @return 발행자
	 */
	public PublisherResponse getPublisher(Long publisherId) {
		Optional<Publisher> publisherOpt = publisherRepository.findById(publisherId);
		if (!publisherOpt.isPresent()) {
			throw new PublisherNotFoundException(publisherId);
		}
		return publisherOpt.map(PublisherResponse::of).get();
	}
}
