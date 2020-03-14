package com.hst.reminder.publisher.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author dlgusrb0808@gmail.com
 */
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDestination implements Serializable {
	private static final long serialVersionUID = 3669097821823719066L;

	@Column
	private String target;

	@Column(name = "parameters")
	private String paramterValue;

	public void changeTarget(String target) {
		this.target = target;
	}

	public void changeParameters(String parameters) {
		this.paramterValue = parameters;
	}

	public static PublisherDestination of(String target, String parameters) {
		PublisherDestination destination = new PublisherDestination();
		destination.target = target;
		destination.paramterValue = parameters;
		return destination;
	}
}
