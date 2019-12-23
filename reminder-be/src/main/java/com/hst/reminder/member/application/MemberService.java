package com.hst.reminder.member.application;

import com.hst.reminder.member.application.command.SignupRequest;
import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberId;
import com.hst.reminder.member.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class MemberService implements UserDetailsService {

	private MemberRepository memberRepository;

	public void signup(SignupRequest request) {
		Member member = new Member();
		memberRepository.save(member);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return memberRepository.findById(MemberId.of(Long.valueOf(username)));
	}

	@Autowired
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

}
