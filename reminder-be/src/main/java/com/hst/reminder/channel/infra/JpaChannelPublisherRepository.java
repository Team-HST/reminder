package com.hst.reminder.channel.infra;

import com.hst.reminder.channel.domain.ChannelPublisher;
import com.hst.reminder.channel.domain.ChannelPublisherRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface JpaChannelPublisherRepository extends ChannelPublisherRepository, JpaRepository<ChannelPublisher, Long> {
}
