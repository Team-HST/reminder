package com.hst.reminder.channel.infra;

import com.hst.reminder.channel.domain.Channel;
import com.hst.reminder.channel.domain.ChannelRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface JpaChannelRepository extends ChannelRepository, JpaRepository<Channel, Long> {
}
