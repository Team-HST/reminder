package com.hst.reminder.member;

import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.member.ui.MemberController;
import com.hst.reminder.member.ui.response.MemberProfileResponse;
import com.hst.reminder.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author dlgusrb0808@gmail.com
 */
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class MemberApiTest {

	@Mock
	private MemberService mockMemberService;

	@InjectMocks
	private MemberController memberController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp(RestDocumentationContextProvider restDocumentation) {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(memberController)
				.addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))	// 한글 처리를 위해 추가
				.apply(
					documentationConfiguration(restDocumentation)
						.uris()
							.withScheme("http")
							.withHost("dev-api.reminder.com")
							.withPort(8000)

				)
				.alwaysDo(print())
				.build();
	}

	/***
	 * 3가지 빌더를 주로 사용
	 * MockMvcRequestBuilders
	 * MockMvcResultHandlers
	 * MockMvcResultMatchers
	 * @throws Exception
	 */
	@Test
	public void getMemberProfile() throws Exception {
		// given
		Long memberId = 1L;

		MemberProfileResponse mockMemberProfile = mockMemberProfile(memberId);
		String getMemberProfileUrl = StringUtils.template("/members/${memberId}", "memberId", memberId); //"/members/" + memberId;
		Mockito.when(mockMemberService.getMemberProfile(Mockito.anyLong())).thenReturn(mockMemberProfile);

		// when
		ResultActions resultActions = this.mockMvc.perform(
			get(getMemberProfileUrl)
		);

		// then
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("id").value(isA(Number.class)))
			.andExpect(jsonPath("id").value( anyOf(is(memberId), is(memberId.intValue()))))
			.andExpect(jsonPath("name").value(mockMemberProfile.getName()))
			.andExpect(jsonPath("email").value(mockMemberProfile.getEmail()))
			.andExpect(jsonPath("profileImageUrl").value(mockMemberProfile.getProfileImageUrl()))
			.andDo(document("member-api/get-member-profile"));
	}

	private MemberProfileResponse mockMemberProfile(Long memberId) {
		return MemberProfileResponse.builder()
				.id(memberId)
				.name("leehg")
				.email("leehg@hst.com")
				.profileImageUrl("https://cdn.leehg.com/leehg")
				.build();
	}

}
