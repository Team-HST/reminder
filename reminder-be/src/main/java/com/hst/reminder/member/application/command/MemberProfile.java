package com.hst.reminder.member.application.command;

import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class MemberProfile {

	private Long id;
	private String name;
	private String email;
	private String profileImageUrl;

}
