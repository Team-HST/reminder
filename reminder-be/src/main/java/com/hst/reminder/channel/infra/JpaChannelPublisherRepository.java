package com.hst.reminder.channel.infra;

import com.hst.reminder.channel.domain.ChannelPublisher;
import com.hst.reminder.channel.domain.ChannelPublisherRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface JpaChannelPublisherRepository extends ChannelPublisherRepository, JpaRepository<ChannelPublisher, Long> {
	@Query("select cp from ChannelPublisher cp " +
		   " where cp.publisher.id in (:publisherIds)")
	List<ChannelPublisher> findAllByPublisherIdIn(List<Long> publisherIds);
}
