package com.hst.reminder.code.ui.response;

import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class CodeResponse {
	private String code;
	private String description;
}
