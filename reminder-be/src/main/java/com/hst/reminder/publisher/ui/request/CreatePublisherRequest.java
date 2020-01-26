package com.hst.reminder.publisher.ui.request;

import lombok.Getter;
import lombok.ToString;

/**
 * @author dlgusrb0808@gmail.com
 */
@ToString
@Getter
public class CreatePublisherRequest {
	private Long memberId;
	private String protocol;
	private String target;
	private String parameters;
	private String description;
}
