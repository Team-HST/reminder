package com.hst.reminder.publisher.domain;

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

	public Publisher(Long memberId, String protocol, String target, String parameters, String description) {
		this.memberId = memberId;
		this.protocol = PublisherProtocol.get(protocol);
		this.destination = new PublisherDestination(target, parameters);
		this.description = description;
	}
}
