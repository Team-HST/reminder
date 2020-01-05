package com.hst.reminder.oauth2.application;

import com.hst.reminder.oauth2.domain.OAuth2ProviderType;
import com.hst.reminder.oauth2.domain.OAuth2AuthorizedUser;
import com.hst.reminder.oauth2.domain.GithubOAuth2AuthorizedUser;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public class OAuth2AuthorizedUserFactory {

	private OAuth2AuthorizedUserFactory() {}

	public static OAuth2AuthorizedUser getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
		if (registrationId.equalsIgnoreCase(OAuth2ProviderType.GITHUB.toString())) {
			return new GithubOAuth2AuthorizedUser(attributes);
		} else {
			throw new UnsupportedOperationException(String.format("지원하지 않는 OAuth2 제공자입니다. %s", registrationId));
		}
	}

}
