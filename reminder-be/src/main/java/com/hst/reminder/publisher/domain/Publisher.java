package com.hst.reminder.publisher.domain;

import com.hst.reminder.channel.domain.ChannelPublisher;
import com.hst.reminder.common.entity.BaseTimeEntity;
import com.hst.reminder.publisher.ui.request.PublisherModifyingRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "PUBLISHER")
@NoArgsConstructor
@Getter
public class Publisher extends BaseTimeEntity implements Serializable {
	private static final long serialVersionUID = 1865565771900706900L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "protocol")
	@Convert(converter = PublisherProtocol.Converter.class)
	private PublisherProtocol protocol;

	@Embedded
	private PublisherDestination destination;

	@Column
	private String description;

	@Column(name = "member_id")
	private Long memberId;

	@OneToMany(mappedBy = "publisher")
	private List<ChannelPublisher> channels = new ArrayList<>();

	public static Publisher from(PublisherModifyingRequest request) {
		Publisher publisher = new Publisher();
		publisher.memberId = request.getMemberId();
		publisher.protocol = PublisherProtocol.get(request.getProtocol());
		publisher.destination = PublisherDestination.of(request.getTarget(), request.getParameters());
		publisher.description = request.getDescription();
		return publisher;
	}

	public void changeContent(PublisherModifyingRequest request) {
		if (Objects.nonNull(request.getProtocol())) {
			this.protocol = PublisherProtocol.get(request.getProtocol());
		}
		if (Objects.nonNull(request.getTarget())) {
			this.destination.changeTarget(request.getTarget());
		}
		if (Objects.nonNull(request.getParameters())) {
			this.destination.changeParameters(request.getParameters());
		}
		if (Objects.nonNull(request.getDescription())) {
			this.description = request.getDescription();
		}
	}
}
