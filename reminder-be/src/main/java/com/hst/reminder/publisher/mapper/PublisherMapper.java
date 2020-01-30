package com.hst.reminder.publisher.mapper;

import com.hst.reminder.publisher.domain.Publisher;
import com.hst.reminder.publisher.ui.response.PublisherResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author dlgusrb0808@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublisherMapper {

	public static PublisherResponse toPublisherResponse(Publisher entity) {
		return PublisherResponse.builder()
				.id(entity.getId())
				.protocol(entity.getProtocol().getCode())
				.target(entity.getDestination().getTarget())
				.parameters(entity.getDestination().getParamterValue())
				.description(entity.getDescription())
				.build();
	}

}
