package com.hst.reminder.member.mapper;

import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.ui.response.MemberProfileResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author dlgusrb0808@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMapper {

	/***
	 * Member 엔티티를 MemberProfileResponse API응답으로 변환
	 * @param member 멤버 엔티티
	 * @return MemberProfileResponse API응답
	 */
	public static MemberProfileResponse toMemberProfileResponse(Member member) {
		return MemberProfileResponse.builder()
				.id(member.getId())
				.name(member.getName())
				.email(member.getEmail())
				.profileImageUrl(member.getProfileImageUrl())
				.build();
	}
}
