package com.hst.reminder.publisher.ui.response;

import com.hst.reminder.publisher.domain.Publisher;
import com.hst.reminder.publisher.mapper.PublisherMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
public class PublisherListResponse {
	@ApiModelProperty(position = 1, value = "발행자 목록")
	private List<PublisherResponse> publishers;

	public static PublisherListResponse from(List<Publisher> publishers) {
		PublisherListResponse response = new PublisherListResponse();
		response.publishers = publishers.stream().map(PublisherMapper::toPublisherResponse).collect(Collectors.toList());
		return response;
	}
}
