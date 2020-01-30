package com.hst.reminder.oauth2.domain;

import com.hst.reminder.common.converter.EnumAttributeConverter;
import com.hst.reminder.common.type.PersistableType;
import com.hst.reminder.utils.EnumUtils;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public enum OAuth2ProviderType implements PersistableType<String> {
	LOCAL("local", "시스템 자체 인증"),
	GITHUB("github", "Github 인증");

	private String code;
	private String description;

	OAuth2ProviderType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	private static final Map<String, OAuth2ProviderType> FINDER = EnumUtils.asMap(OAuth2ProviderType.class);

	public static OAuth2ProviderType of(String registrationId) {
		return FINDER.get(registrationId.toLowerCase());
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	public static class Converter extends EnumAttributeConverter<OAuth2ProviderType, String> {
		public Converter() {
			super(OAuth2ProviderType.class, false);
		}
	}

}
