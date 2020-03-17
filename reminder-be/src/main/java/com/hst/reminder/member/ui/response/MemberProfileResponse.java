package com.hst.reminder.member.ui.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class MemberProfileResponse {
	@ApiModelProperty(position = 1, value = "회원 ID", example = "2717283")
	private Long id;
	@ApiModelProperty(position = 2, value = "회원명", example = "이현규")
	private String name;
	@ApiModelProperty(position = 3, value = "회원 이메일", example = "deveely@kakao.com")
	private String email;
	@ApiModelProperty(position = 4, value = "회원 프포필 이미지 URL", example = "https://cdn.hst.com/pics/12")
	private String profileImageUrl;
}
