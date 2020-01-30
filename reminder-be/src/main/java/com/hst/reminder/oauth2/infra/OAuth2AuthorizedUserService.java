package com.hst.reminder.oauth2.infra;

import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberRepository;
import com.hst.reminder.oauth2.application.OAuth2AuthorizedUserFactory;
import com.hst.reminder.oauth2.domain.OAuth2AuthorizedUser;
import com.hst.reminder.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class OAuth2AuthorizedUserService extends DefaultOAuth2UserService {

	private MemberRepository memberRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		OAuth2User oauth2User = super.loadUser(userRequest);
		OAuth2AuthorizedUser userInfo = OAuth2AuthorizedUserFactory.createOAuth2AuthorizedUser(registrationId,
				oauth2User.getAttributes());

		if (StringUtils.isBlank(userInfo.getEmail())) {
			throw new AccessDeniedException("OAuth2 제공자로부터 이메일 정보를 확인할 수 없습니다.");
		}

		Member member = processOAuth2User(userInfo);
		return memberRepository.save(member);
	}

	// OAuth2 가입 여부 확인 & 가입 처리
	private Member processOAuth2User(OAuth2AuthorizedUser userInfo) {
		Member member;
		Optional<Member> memberOpt = memberRepository.findByEmail(userInfo.getEmail());
		if (memberOpt.isPresent()) {
			member = memberOpt.get();
			if (!member.isOriginalSSOProvider(userInfo.getoAuth2ProviderType())) {
				throw new AccessDeniedException(String.format("동일한 메일로 가입한 계정이 존재합니다. %s(%s)",
						userInfo.getEmail(), member.getSsoProvider().getDescription()));
			}
			member.updateMemberInfo(userInfo);
		} else {
			member = Member.createMemberBySocial(userInfo);
		}
		return member;
	}

	@Autowired
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
}
