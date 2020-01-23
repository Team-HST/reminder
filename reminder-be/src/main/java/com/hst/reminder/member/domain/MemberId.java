package com.hst.reminder.member.domain;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author dlgusrb0808@gmail.com
 */
@Embeddable
@Access(AccessType.FIELD)
@Getter
public class MemberId implements Serializable {
	private static final long serialVersionUID = 6973061444132058532L;

	@Column(name = "id")
	private Long value;

	protected MemberId() {}

	public MemberId(String value) {
		this(Long.valueOf(value));
	}

	public MemberId(Long value) {
		this.value = value;
	}

	public String getValueAsString() {
		return this.value.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof MemberId))
			return false;
		MemberId memberId = (MemberId) o;
		return Objects.equals(value, memberId.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
