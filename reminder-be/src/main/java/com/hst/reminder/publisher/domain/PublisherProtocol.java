package com.hst.reminder.publisher.domain;

import com.hst.reminder.common.converter.EnumAttributeConverter;
import com.hst.reminder.common.type.PersistableType;
import com.hst.reminder.utils.EnumUtils;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public enum PublisherProtocol implements PersistableType<String> {
	EMAIL("email", "발행자 이메일 프로토콜"),
	SLACK("slack", "발행자 슬랙 프로토콜")
	;

	private String code;
	private String description;

	PublisherProtocol(String code, String description) {
		this.code = code;
		this.description = description;
	}

	private static final Map<String, PublisherProtocol> FINDER = EnumUtils.asMap(PublisherProtocol.class);

	public static PublisherProtocol get(String protocol) {
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

	public static class Converter extends EnumAttributeConverter<PublisherProtocol, String> {
		public Converter() {
			super(PublisherProtocol.class, false);
		}
	}
}
