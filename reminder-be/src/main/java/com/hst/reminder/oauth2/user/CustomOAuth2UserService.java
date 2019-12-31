package com.hst.reminder.oauth2.user;

import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberRepository;
import com.hst.reminder.oauth2.OAuth2ProviderType;
import org.apache.commons.lang3.StringUtils;
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
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		OAuth2ProviderType oAuth2ProviderType = OAuth2ProviderType.get(registrationId);
		OAuth2User oauth2User = super.loadUser(userRequest);
		OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, oauth2User.getAttributes());

		if (StringUtils.isEmpty(userInfo.getEmail())) {
			throw new AccessDeniedException("Email not present from OAuth2 Provider Information");
		}

		Member member = processOAuth2User(oAuth2ProviderType, userInfo);
		return memberRepository.save(member);
	}

	// OAuth2 가입 여부 확인 & 가입 처리
	private Member processOAuth2User(OAuth2ProviderType oAuth2ProviderType, OAuth2UserInfo userInfo) {
		Member member;
		Optional<Member> memberOpt = memberRepository.findByEmail(userInfo.getEmail());
		if (memberOpt.isPresent()) {
			member = memberOpt.get();
			if (member.getSsoProvider() != oAuth2ProviderType) {
				throw new AccessDeniedException(String.format("Already authorized email address. %s", member.getSsoProvider()));
			}
			member.updateMemberInfo(userInfo);
		} else {
			member = Member.createMemberBySocial(userInfo, oAuth2ProviderType);
		}
		return member;
	}

}
