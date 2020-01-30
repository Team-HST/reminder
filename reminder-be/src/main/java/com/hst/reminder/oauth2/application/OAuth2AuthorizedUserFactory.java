package com.hst.reminder.oauth2.application;

import com.hst.reminder.oauth2.domain.GithubOAuth2AuthorizedUser;
import com.hst.reminder.oauth2.domain.OAuth2AuthorizedUser;
import com.hst.reminder.oauth2.domain.OAuth2ProviderType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OAuth2AuthorizedUserFactory {

	public static OAuth2AuthorizedUser createOAuth2AuthorizedUser(String registrationId, Map<String, Object> attributes) {
		OAuth2ProviderType type = OAuth2ProviderType.of(registrationId);
		switch (type) {
			case GITHUB:
				return new GithubOAuth2AuthorizedUser(attributes);
		}
		throw new UnsupportedOperationException(String.format("지원하지 않는 OAuth2 제공자입니다. %s", registrationId));
	}

}
