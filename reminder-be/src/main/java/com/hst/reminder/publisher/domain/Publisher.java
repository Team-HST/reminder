package com.hst.reminder.publisher.domain;

import com.hst.reminder.publisher.ui.request.PublisherModifyingRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "PUBLISHER")
@NoArgsConstructor
@Getter
public class Publisher implements Serializable {
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

	public static Publisher of(PublisherModifyingRequest request) {
		Publisher publisher = new Publisher();
		publisher.memberId = request.getMemberId();
		publisher.protocol = PublisherProtocol.get(request.getProtocol());
		publisher.destination = PublisherDestination.of(request.getTarget(), request.getParameters());
		publisher.description = request.getDescription();
		return publisher;
	}

	public void modify(PublisherModifyingRequest request) {
		this.memberId = request.getMemberId();
		this.protocol = PublisherProtocol.get(request.getProtocol());
		this.destination = PublisherDestination.of(request.getTarget(), request.getParameters());
		this.description = request.getDescription();
	}
}
