package com.hst.reminder.oauth2.domain;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public abstract class OAuth2AuthorizedUser {
	protected Map<String, Object> attributes;

	public OAuth2AuthorizedUser(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public abstract String getId();

	public abstract String getName();

	public abstract String getEmail();

	public abstract String getImageUrl();
}