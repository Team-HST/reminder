package com.hst.reminder.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author dlgusrb0808@gmail.com
 */
@Embeddable
@Getter
public class MemberId implements Serializable {
	@Column
	private Long id;

	public static MemberId of(Long id) {
		MemberId memberId = new MemberId();
		memberId.id = id;
		return memberId;
	}
}
