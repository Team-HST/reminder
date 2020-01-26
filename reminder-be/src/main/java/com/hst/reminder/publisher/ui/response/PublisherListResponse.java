package com.hst.reminder.publisher.ui.response;

import com.hst.reminder.publisher.domain.Publisher;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
public class PublisherListResponse {
	private List<PublisherResponse> publishers;

	public static PublisherListResponse of(List<Publisher> publishers) {
		PublisherListResponse response = new PublisherListResponse();
		response.publishers = publishers.stream().map(PublisherResponse::of).collect(Collectors.toList());
		return response;
	}
}
