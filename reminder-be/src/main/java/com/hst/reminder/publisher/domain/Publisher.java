package com.hst.reminder.publisher.domain;

import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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

	@Embedded
	@AttributeOverrides(
		@AttributeOverride(name = "value", column = @Column(name = "member_id"))
	)
	private MemberId memberId;

	public Publisher(Long memberId, String protocol, String target, String parameters) {
		this.memberId = new MemberId(memberId);
		this.protocol = PublisherProtocol.get(protocol);
		this.destination = new PublisherDestination(target, parameters);
	}
}
