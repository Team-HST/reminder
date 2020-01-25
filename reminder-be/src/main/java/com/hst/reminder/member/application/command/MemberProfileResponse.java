package com.hst.reminder.member.application.command;

import com.hst.reminder.member.domain.Member;
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

	public static MemberProfileResponse of(Member member) {
		return MemberProfileResponse.builder()
				.id(member.getId().getValue())
				.name(member.getName())
				.email(member.getEmail())
				.profileImageUrl(member.getProfileImageUrl())
				.build();
	}
}
