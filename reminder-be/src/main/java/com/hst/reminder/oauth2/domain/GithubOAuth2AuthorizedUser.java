package com.hst.reminder.oauth2.domain;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public class GithubOAuth2AuthorizedUser extends OAuth2AuthorizedUser {
	public GithubOAuth2AuthorizedUser(Map<String, Object> attributes) {
		super(OAuth2ProviderType.GITHUB, attributes);
	}

	@Override
	protected boolean isNamePresent() {
		return getAttributeValue("name") != null;
	}

	@Override
	protected String getNameSubstitute() {
		return (String) getAttributeValue("login");
	}

	@Override
	protected String getName() {
		return (String) getAttributeValue("name");
	}

	@Override
	public String getId() {
		return ((Integer) getAttributeValue("id")).toString();
	}

	@Override
	public String getEmail() {
		return (String) getAttributeValue("email");
	}

	@Override
	public String getImageUrl() {
		return (String) getAttributeValue("avatar_url");
	}
}
