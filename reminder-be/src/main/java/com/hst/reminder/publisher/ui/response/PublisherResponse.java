package com.hst.reminder.publisher.ui.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class PublisherResponse {
	@ApiModelProperty(position = 1, value = "발행자 ID", example = "2717283")
	private Long id;

	@ApiModelProperty(position = 2, value = "프로토콜", example = "email")
	private String protocol;

	@ApiModelProperty(position = 3, value = "대상", example = "gusrb0808@naver.com")
	private String target;

	@ApiModelProperty(position = 4, value = "파라미터 (프로토콜마다 다른 포맷)")
	private String parameters;

	@ApiModelProperty(position = 5, value = "발행자의 설명", example = "네이버 이메일 발행자")
	private String description;

	@ApiModelProperty(position = 6, value = "등록일자", example = "2020-04-19 11:22:33")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate;

	@ApiModelProperty(position = 7, value = "변경일자", example = "2020-04-19 11:22:33")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifiedDate;
}
