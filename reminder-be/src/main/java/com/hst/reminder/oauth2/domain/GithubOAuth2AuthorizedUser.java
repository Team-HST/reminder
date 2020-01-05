package com.hst.reminder.oauth2.domain;

import com.hst.reminder.oauth2.domain.OAuth2AuthorizedUser;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public class GithubOAuth2AuthorizedUser extends OAuth2AuthorizedUser {
	public GithubOAuth2AuthorizedUser(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return ((Integer) attributes.get("id")).toString();
	}

	@Override
	public String getName() {
		return (String) attributes.get("name");
	}

	@Override
	public String getEmail() {
		return (String) attributes.get("email");
	}

	@Override
	public String getImageUrl() {
		return (String) attributes.get("avatar_url");
	}
}
