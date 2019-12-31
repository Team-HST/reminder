package com.hst.reminder.common.exception;

import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class ErrorDescription {

	private int statusCode;
	private String message;

}
