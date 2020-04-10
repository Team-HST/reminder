package com.hst.reminder.publisher.ui.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class PublisherResponse {
	@ApiModelProperty(position = 1, value = "발행자 ID", example = "2717283")
	private Long id;
	@ApiModelProperty(position = 1, value = "프로토콜", example = "email")
	private String protocol;
	@ApiModelProperty(position = 1, value = "대상", example = "gusrb0808@naver.com")
	private String target;
	@ApiModelProperty(position = 1, value = "파라미터 (프로토콜마다 다른 포맷)")
	private String parameters;
	@ApiModelProperty(position = 1, value = "발행자의 설명", example = "네이버 이메일 발행자")
	private String description;
}
