package com.hst.reminder.oauth2;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
public enum OAuth2Provider {
	LOCAL,
	GITHUB;

	private static Map<String, OAuth2Provider> FIND = EnumSet.allOf(OAuth2Provider.class).stream()
			.collect(Collectors.toMap(e -> e.toString().toLowerCase(), Function.identity()));

	public static OAuth2Provider get(String registrationId) {
		return FIND.get(registrationId.toLowerCase());
	}
}
