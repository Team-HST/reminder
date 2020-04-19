package com.hst.reminder.publisher.application;

import com.hst.reminder.publisher.application.exception.PublisherNotFoundException;
import com.hst.reminder.publisher.domain.Publisher;
import com.hst.reminder.publisher.domain.PublisherRepository;
import com.hst.reminder.publisher.mapper.PublisherMapper;
import com.hst.reminder.publisher.ui.request.PublisherModifyingRequest;
import com.hst.reminder.publisher.ui.response.PublisherListResponse;
import com.hst.reminder.publisher.ui.response.PublisherResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	 * 발행자 조회
	 * @param publisherId 발행자 ID
	 * @return 발행자
	 */
	private Publisher findPublisher(Long publisherId) {
		return publisherRepository.findById(publisherId)
				.orElseThrow(() -> new PublisherNotFoundException(publisherId));
	}

	/***
	 * 발행자 생성
	 * @param request 발행자 생성 요청
	 * @return 생성된 발행자 ID
	 */
	@Transactional
	public Long createPublisher(PublisherModifyingRequest request) {
		Publisher publisher = Publisher.from(request);
		return publisherRepository.save(publisher).getId();
	}

	/***
	 * 멤버ID로 발행자 목록 조회
	 * @param memberId 멤버ID
	 * @return 발행자 목록
	 */
	public PublisherListResponse getPublishersByMemberId(Long memberId) {
		List<Publisher> publishers = publisherRepository.findByMemberId(memberId);
		return PublisherListResponse.from(publishers);
	}

	/***
	 * 발행자 조회
	 * @param publisherId 발행자 ID
	 * @return 발행자
	 */
	public PublisherResponse getPublisher(Long publisherId) {
		Publisher publisher = findPublisher(publisherId);
		return PublisherMapper.toPublisherResponse(publisher);
	}

	/***
	 * 발행자 수정
	 * @param publisherId 발행자 ID
	 * @param request 요청
	 */
	@Transactional
	public void modifyPublisher(Long publisherId, PublisherModifyingRequest request) {
		Publisher publisher = findPublisher(publisherId);
		publisher.changeContent(request);
	}

	/***
	 * 발행자 삭제
	 * @param publisherId 발행자ID
	 */
	@Transactional
	public void deletePublisher(Long publisherId) {
		publisherRepository.delete(findPublisher(publisherId));
	}

	/***
	 * 발행자 다 건 삭제
	 * @param publisherIds 발행자 ID 목록
	 */
	@Transactional
	public void deletePublishers(List<Long> publisherIds) {
		publisherRepository.deleteByIdIn(publisherIds);
	}
}
