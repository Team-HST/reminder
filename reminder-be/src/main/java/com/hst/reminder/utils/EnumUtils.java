package com.hst.reminder.utils;

import com.hst.reminder.common.type.PersistableType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * @author dlgusrb0808@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumUtils {

	public static <E extends Enum<E>, K> Map<K, E> asMap(Class<E> enumClass, Function<E, K> keyFunction) {
		return EnumSet.allOf(enumClass).stream()
				.collect(toMap(keyFunction, Function.identity()));
	}

	public static <E extends Enum<E> & PersistableType<K>, K> Map<K, E> asMap(Class<E> enumClass) {
		return EnumSet.allOf(enumClass).stream()
				.collect(toMap(e -> e.getCode(), Function.identity()));
	}
}
