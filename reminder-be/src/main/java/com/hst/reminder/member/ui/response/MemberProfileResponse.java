package com.hst.reminder.member.ui.response;

import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class MemberProfileResponse {
	private Long id;
	private String name;
	private String email;
	private String profileImageUrl;
}
