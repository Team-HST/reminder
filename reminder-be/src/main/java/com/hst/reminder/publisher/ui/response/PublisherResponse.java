package com.hst.reminder.publisher.ui.response;

import com.hst.reminder.publisher.domain.Publisher;
import lombok.*;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class PublisherResponse {
	private Long id;
	private String protocol;
	private String target;
	private String parameters;

	public static PublisherResponse of(Publisher entity) {
		return PublisherResponse.builder()
				.id(entity.getId())
				.protocol(entity.getProtocol().getCode())
				.target(entity.getDestination().getTarget())
				.parameters(entity.getDestination().getParamterValue())
				.build();
	}
}
