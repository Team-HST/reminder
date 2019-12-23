package com.hst.reminder.member.application.command;

import lombok.Data;

/**
 * @author dlgusrb0808@gmail.com
 */
@Data
public class SignupRequest {
	private String email;

	private String name;

	private String password;
}
