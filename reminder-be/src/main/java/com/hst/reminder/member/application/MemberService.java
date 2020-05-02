package com.hst.reminder.member.application;

import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberRepository;
import com.hst.reminder.member.application.exception.MemberNotFoundException;
import com.hst.reminder.member.mapper.MemberMapper;
import com.hst.reminder.common.ui.request.SearchCriteria;
import com.hst.reminder.member.ui.response.MemberDetailResponse;
import com.hst.reminder.member.ui.response.MemberProfileResponse;
import com.hst.reminder.member.ui.response.MemberDetailListResponse;
import com.hst.reminder.publisher.application.PublisherService;
import com.hst.reminder.publisher.ui.response.PublisherListResponse;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;
	private final PublisherService publisherService;

	/***
	 * 멤버 프로필 조회
	 * @param memberId 멤버 ID
	 * @return 멤버 프로필
	 */
	public MemberProfileResponse getMemberProfile(Long memberId) {
		Optional<Member> memberOpt = memberRepository.findById(memberId);
		if (!memberOpt.isPresent()) {
			throw new MemberNotFoundException(memberId);
		}
		return MemberMapper.toMemberProfileResponse(memberOpt.get());
	}

	@Override
	public UserDetails loadUserByUsername(String memberIdStr) {
		return memberRepository.findById(Long.valueOf(memberIdStr))
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Not found id %s", memberIdStr)));
	}

	/***
	 * 멤버 검색
	 * @param request 멤버 검색 요청
	 */
	public MemberDetailListResponse findMembers(SearchCriteria request) {
		List<Member> members = memberRepository.findByNameContains(request.getKeyword());
		List<MemberDetailResponse> memberDetails = new ArrayList<>();

		if (!Collections.isEmpty(members)) {
			for (Member member : members) {
				MemberProfileResponse profile = MemberMapper.toMemberProfileResponse(member);
				PublisherListResponse publishers = publisherService.getPublishersByMemberId(member.getId());
				memberDetails.add(MemberDetailResponse.of(profile, publishers));
			}
		}

		return MemberDetailListResponse.from(memberDetails);
	}
}
