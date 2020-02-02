package com.hst.reminder.member.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author dlgusrb0808@gmail.com
 */
@Embeddable
@Getter
public class Password implements Serializable {
	private static final long serialVersionUID = -6018571905393785270L;

	private String value;

	public static Password empty() {
		Password password = new Password();
		password.value = "{none}emptypassword";
		return password;
	}
}
