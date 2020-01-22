package com.hst.reminder.publisher.domain;

import lombok.Getter;

import javax.persistence.*;

/**
 * @author dlgusrb0808@gmail.com
 */
@Embeddable
@Getter
public class PublisherProtocol {

	@Column(name = "protocol")
	@Convert(converter = PublisherProtocolType.Converter.class)
	private PublisherProtocolType protocolType;

	@Column
	private String target;

	@Column(name = "paramters")
	private String paramterValue;

}
