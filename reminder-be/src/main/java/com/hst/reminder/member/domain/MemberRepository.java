package com.hst.reminder.member.domain;

import java.util.List;
import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface MemberRepository {
	Optional<Member> findById(Long memberId);

	Member save(Member member);

	Optional<Member> findByEmail(String email);
}
