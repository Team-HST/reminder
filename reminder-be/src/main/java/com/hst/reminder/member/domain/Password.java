package com.hst.reminder.member.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * @author dlgusrb0808@gmail.com
 */
@Embeddable
@Getter
public class Password {
	private String value;
}
