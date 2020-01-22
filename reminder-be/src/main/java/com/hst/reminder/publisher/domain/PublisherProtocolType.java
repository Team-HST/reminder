package com.hst.reminder.publisher.domain;

import com.hst.reminder.common.converter.EnumAttributeConverter;
import com.hst.reminder.common.type.PersistableType;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
public enum PublisherProtocolType implements PersistableType<String> {
	EMAIL("email", "이메일 발행자 프로토콜 타입")
	;

	private String code;
	private String description;

	PublisherProtocolType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	private static final Map<String, PublisherProtocolType> FINDER = EnumSet.allOf(PublisherProtocolType.class).stream()
			.collect(Collectors.toMap(e -> e.toString().toLowerCase(), Function.identity()));

	public static PublisherProtocolType get(String protocol) {
		return FINDER.get(protocol.toLowerCase());
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	public static class Converter extends EnumAttributeConverter<PublisherProtocolType, String> {
		public Converter() {
			super(PublisherProtocolType.class, false);
		}
	}
}
