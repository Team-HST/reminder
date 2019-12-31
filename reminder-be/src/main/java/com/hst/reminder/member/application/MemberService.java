package com.hst.reminder.member.application;

import com.hst.reminder.member.application.command.MemberProfile;
import com.hst.reminder.member.application.command.SignupRequest;
import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberRepository;
import com.hst.reminder.member.domain.exception.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	public void signup(SignupRequest request) {
		Member member = new Member();
		memberRepository.save(member);
	}

	/***
	 * 멤버 프로필 조회
	 * @param memberId 멤버 ID
	 * @return 멤버 프로필
	 */
	public MemberProfile getMemberProfile(Long memberId) {
		Optional<Member> memberOpt = memberRepository.findById(memberId);
		if (!memberOpt.isPresent()) {
			throw new MemberNotFoundException("사용자 정보를 찾을수 없습니다. memberId: %d", memberId);
		}
		return memberOpt.get().getMemberProfile();
	}

	@Override
	public UserDetails loadUserByUsername(String memberIdStr) {
		Long memberId = Long.valueOf(memberIdStr);
		return memberRepository.findById(memberId)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Not found id %d", memberId)));
	}

}
