package com.hst.reminder.publisher.domain;

import java.util.List;
import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface PublisherRepository {
	Optional<Publisher> findById(Long publisherId);

	Publisher save(Publisher publisher);

	List<Publisher> findByMemberId(Long memberId);
}
