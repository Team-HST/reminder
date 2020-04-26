package com.hst.reminder.channel.ui.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@NoArgsConstructor
public class ChannelModifyingRequest {
	@ApiModelProperty(position = 1, value = "회원 ID", example = "2717283")
	private Long memberId;
	@ApiModelProperty(position = 1, value = "채널명", example = "HST 일반알림 채널")
	private String title;
	@ApiModelProperty(position = 1, value = "채널설명", example = "HST 멤버 일반 알림 채널입니다")
	private String description;
	@ApiModelProperty(position = 1, value = "채널설명")
	private List<Long> publisherIds;
}
