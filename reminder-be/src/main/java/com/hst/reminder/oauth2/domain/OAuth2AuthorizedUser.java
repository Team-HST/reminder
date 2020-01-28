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

	/***
	 * OAuth Provider별로 이름 정보가 없을수 있음.
	 * 때문에 OAuth 인증 attribute에 이름 존재하는지 확인
	 * @return 이름 정보 존재 여부
	 */
	protected abstract boolean isNamePresent();

	/***
	 * 이름 정보
	 * @return 이름
	 */
	protected abstract String getName();

	/***
	 * 이름 정보가 존재하지 않을 경우 대체할 정보
	 * @return 이름 정보 대체 값
	 */
	protected abstract String getNameSubstitute();

	/***
	 * Id 획득
	 * @return Id
	 */
	public abstract String getId();

	/***
	 * Email주소 획득
	 * @return Email주소
	 */
	public abstract String getEmail();

	/***
	 * 프로필 이미지 URL 획득
	 * @return 프로필 이미지 URL
	 */
	public abstract String getImageUrl();

	/***
	 * 이름 정보 획득
	 * @return 이름
	 */
	public String getResolvedName() {
		return isNamePresent() ? getName() : getNameSubstitute();
	}
}