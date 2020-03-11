package com.hst.reminder.member;

import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.member.ui.response.MemberProfileResponse;
import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberRepository;
import com.hst.reminder.member.application.exception.MemberNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author dlgusrb0808@gmail.com
 */
@ExtendWith(SpringExtension.class)
public class MemberServiceTest {

	@Mock
	private MemberRepository memberRepository;

	@InjectMocks
	private MemberService memberService;

	@DisplayName("멤버 프로필 조회 성공")
	@Test
	public void successToGetMemberProfile() {
		// given
		Member member = createSampleMember(1L);
		when(memberRepository.findById(member.getId())).thenReturn(Optional.of(member));

		// when
		MemberProfileResponse memberProfileResponse = memberService.getMemberProfile(member.getId());

		// then
		verify(memberRepository).findById(member.getId());
		assertEquals(member.getId(), memberProfileResponse.getId());
		assertEquals(member.getName(), memberProfileResponse.getName());
		assertEquals(member.getEmail(), memberProfileResponse.getEmail());
		assertEquals(member.getProfileImageUrl(), memberProfileResponse.getProfileImageUrl());
	}

	@DisplayName("멤버 프로필 조회 실패")
	@Test
	public void failToGetMemberProfile() {
		Long memberId = 1L;
		when(memberRepository.findById(memberId)).thenReturn(Optional.empty());

		MemberNotFoundException e = assertThrows(MemberNotFoundException.class, () -> {
			memberService.getMemberProfile(memberId);
		});

		verify(memberRepository).findById(memberId);
		assertEquals(String.format("Member(Id: %s)를 찾을 수 없습니다.", memberId), e.getMessage());
	}

	private Member createSampleMember(Long id) {
		Member member = new Member();
		ReflectionTestUtils.setField(member, "id", id);
		ReflectionTestUtils.setField(member, "name", "이현규");
		ReflectionTestUtils.setField(member, "email", "gusrb0808@naver.com");
		ReflectionTestUtils.setField(member, "profileImageUrl", "profile.com/profile.jpg");
		return member;
	}

 }
