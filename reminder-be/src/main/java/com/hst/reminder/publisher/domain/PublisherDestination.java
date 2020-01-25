package com.hst.reminder.publisher.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
}
