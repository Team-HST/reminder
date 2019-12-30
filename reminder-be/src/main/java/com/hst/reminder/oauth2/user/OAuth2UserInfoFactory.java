package com.hst.reminder.oauth2.user;

import com.hst.reminder.oauth2.OAuth2Provider;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public class OAuth2UserInfoFactory {

	public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
		if (registrationId.equalsIgnoreCase(OAuth2Provider.GITHUB.toString())) {
			return new GithubOAuth2UserInfo(attributes);
		} else {
			throw new UnsupportedOperationException(String.format("Sorry! Login with %s is not supported yet.", registrationId));
		}
	}

}
