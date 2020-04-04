package com.hst.reminder.code.ui.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class CodeResponse {
	@ApiModelProperty(position = 1, value = "코드명", example = "email")
	private String code;
	@ApiModelProperty(position = 2, value = "코드이름", example = "Email")
	private String codeName;
	@ApiModelProperty(position = 3, value = "코드설명", example = "이메일 타입")
	private String description;
}
