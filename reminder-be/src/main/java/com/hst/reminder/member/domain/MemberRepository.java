package com.hst.reminder.member.domain;

import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface MemberRepository {
	Optional<Member> findById(MemberId memberId);

	Member save(Member member);

	Optional<Member> findByEmail(String email);
}
