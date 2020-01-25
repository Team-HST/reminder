package com.hst.reminder.member;

import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.member.application.command.MemberProfileResponse;
import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberId;
import com.hst.reminder.member.domain.MemberRepository;
import com.hst.reminder.member.domain.exception.MemberNotFoundException;
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
 * 블로그 쓰기!!!!!
 * 1. JUnit 5는 @RunWith가 필요없음
 * 2. Spring Bean 테스트를 위해 @Autowired 등 어노테이션 필요한경우, @ExtendWith(SpringExtension.class) 사용
 * 3. private 필드 값 세팅을 위해 ReflectionTestUtils 사용
 * 4. Exception 체크는 assertThrows 활용
 *
 * @author dlgusrb0808@gmail.com
 */
@ExtendWith(SpringExtension.class)
public class MemberServiceTest {

	@Mock
	private MemberRepository memberRepository;

	@InjectMocks
	private MemberService memberService;

	@Test
	public void 멤버_프로필_조회() {
		// given
		Member member = createMember(1L);
		when(memberRepository.findById(member.getId())).thenReturn(Optional.of(member));

		// when
		MemberProfileResponse memberProfileResponse = memberService.getMemberProfile(member.getId());

		// then
		verify(memberRepository).findById(member.getId());
		assertEquals(member.getId().getValue(), memberProfileResponse.getId());
		assertEquals(member.getName(), memberProfileResponse.getName());
		assertEquals(member.getEmail(), memberProfileResponse.getEmail());
		assertEquals(member.getProfileImageUrl(), memberProfileResponse.getProfileImageUrl());
	}

	@Test
	public void 멤버_프로필_조회_실패() {
		MemberId memberId = new MemberId(1L);
		when(memberRepository.findById(memberId)).thenReturn(Optional.empty());

		MemberNotFoundException e = assertThrows(MemberNotFoundException.class, () -> {
			memberService.getMemberProfile(memberId);
		});

		verify(memberRepository).findById(memberId);
		assertEquals(String.format("사용자 정보를 찾을수 없습니다. memberId: %d", memberId.getValue()), e.getMessage());
	}

	private Member createMember(Long id) {
		Member member = new Member();
		ReflectionTestUtils.setField(member, "memberId", new MemberId(id));
		ReflectionTestUtils.setField(member, "name", "이현규");
		ReflectionTestUtils.setField(member, "email", "gusrb0808@naver.com");
		ReflectionTestUtils.setField(member, "profileImageUrl", "profile.com/profile.jpg");
		return member;
	}

 }
