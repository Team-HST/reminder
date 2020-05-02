package com.hst.reminder.member.infra;

import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface JpaMemberRepository extends MemberRepository, JpaRepository<Member, Long> {
	List<Member> findByNameContains(String name);
}
