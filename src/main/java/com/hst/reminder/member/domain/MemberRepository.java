package com.hst.reminder.member.domain;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface MemberRepository {

	List<Member> findAll();

	Member findById(MemberId memberId);

	void save(Member member);
}
