package com.hst.reminder.publisher.ui.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author dlgusrb0808@gmail.com
 */
@ToString
@Getter
public class PublisherModifyingRequest {
	@ApiModelProperty(position = 1, value = "회원 ID", example = "2717283")
	private Long memberId;
	@ApiModelProperty(position = 1, value = "프로토콜", example = "email")
	private String protocol;
	@ApiModelProperty(position = 1, value = "대상", example = "gusrb0808@naver.com")
	private String target;
	@ApiModelProperty(position = 1, value = "발행자 ID")
	private String parameters;
	@ApiModelProperty(position = 1, value = "발행자의 설명", example = "네이버 메일 발행자")
	private String description;
}
