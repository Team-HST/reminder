package com.hst.reminder.channel.domain;

import com.hst.reminder.publisher.domain.Publisher;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "channel_publisher_map")
@NoArgsConstructor
@Getter
public class ChannelPublisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "channel_id")
	private Channel channel;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	public static ChannelPublisher of(Channel channel, Publisher publisher) {
		ChannelPublisher channelPublisher = new ChannelPublisher();
		channelPublisher.channel = channel;
		channelPublisher.publisher = publisher;
		return channelPublisher;
	}
}
