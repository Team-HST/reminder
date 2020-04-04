package com.hst.reminder.publisher.infra;

import com.hst.reminder.publisher.domain.Publisher;
import com.hst.reminder.publisher.domain.PublisherRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface JpaPublisherRepository extends PublisherRepository, JpaRepository<Publisher, Long> {
	void deleteByIdIn(List<Long> publisherIds);
}
