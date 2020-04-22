package com.hst.reminder.channel.ui.response;

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
public class ChannelResponse {
	@ApiModelProperty(position = 1, value = "채널 ID", example = "2717283")
	private Long id;

	@ApiModelProperty(position = 2, value = "채널명", example = "2717283")
	private String title;

	@ApiModelProperty(position = 3, value = "채널 설명", example = "2717283")
	private String description;

	@ApiModelProperty(position = 4, value = "채널 등록자 ID", example = "2717283")
	private Long ownerId;

	@ApiModelProperty(position = 5, value = "등록일자", example = "2020-04-19 11:22:33")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate;

	@ApiModelProperty(position = 6, value = "변경일자", example = "2020-04-19 11:22:33")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifiedDate;
}
