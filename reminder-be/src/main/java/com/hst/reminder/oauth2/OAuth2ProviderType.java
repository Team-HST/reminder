package com.hst.reminder.oauth2;

import com.hst.reminder.common.converter.EnumAttributeConverter;
import com.hst.reminder.common.type.PersistableType;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	private static final Map<String, OAuth2ProviderType> FINDER = EnumSet.allOf(OAuth2ProviderType.class).stream()
			.collect(Collectors.toMap(e -> e.toString().toLowerCase(), Function.identity()));

	public static OAuth2ProviderType get(String registrationId) {
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
