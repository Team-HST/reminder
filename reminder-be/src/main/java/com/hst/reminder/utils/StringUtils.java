package com.hst.reminder.utils;

import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.text.StringSubstitutor;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static String template(String source, Map<String, Object> values) {
		return StringSubstitutor.replace(source, values);
	}

	public static String template(String source, ImmutableMap<String, Object> values) {
		return StringSubstitutor.replace(source, values);
	}

}
