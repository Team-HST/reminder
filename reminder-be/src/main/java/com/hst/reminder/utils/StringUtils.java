package com.hst.reminder.utils;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static String template(String source, Object...args) {
		int argumentLength = args.length;
		if (argumentLength % 2 != 0) {
			throw new IllegalArgumentException("템플릿 인자가 잘못되었습니다.");
		}

		Map<String, Object> values = new HashMap<>();
		for (int i = 0; i < argumentLength; i+=2) {
			values.put(args[i].toString(), args[i + 1]);
		}

		return template(source, values);
	}

	public static String template(String source, Map<String, Object> values) {
		return StringSubstitutor.replace(source, values);
	}

	public static String template(String source, ImmutableMap<String, Object> values) {
		return StringSubstitutor.replace(source, values);
	}

}
