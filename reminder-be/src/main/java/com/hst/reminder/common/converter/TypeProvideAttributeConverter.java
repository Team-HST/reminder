package com.hst.reminder.common.converter;

import javax.persistence.AttributeConverter;

/**
 * @author dlgusrb0808@gmail.com
 */
public abstract class TypeProvideAttributeConverter<X, Y> implements AttributeConverter<X, Y> {
	Class<X> targetClass;
	boolean nullable;

	TypeProvideAttributeConverter(Class<X> targetClass, boolean nullable) {
		this.targetClass = targetClass;
		this.nullable = nullable;
	}

	public Class<X> getTargetClass() {
		return targetClass;
	}

	public boolean isNullable() {
		return nullable;
	}

	void assertArgumentNotNull(Object value) {
		if (!isNullable() && value == null) {
			throw new IllegalArgumentException(String.format("[%s] NULL 값을 변환할 수 없습니다.", targetClass.getSimpleName()));
		}
	}
}
