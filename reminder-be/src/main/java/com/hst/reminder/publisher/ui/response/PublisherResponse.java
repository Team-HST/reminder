package com.hst.reminder.publisher.ui.response;

import lombok.Builder;
import lombok.Getter;

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
	private String description;
}
