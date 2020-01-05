package com.hst.reminder.authentication.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class AuthenticationToken {
	private String token;
	private Long tokenOwnerId;
}
