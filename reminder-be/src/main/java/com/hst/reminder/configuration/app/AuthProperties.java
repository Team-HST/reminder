package com.hst.reminder.configuration.app;

import lombok.Data;

/**
 * @author dlgusrb0808@gmail.com
 */
@Data
public class AuthProperties {
	private String tokenSecret;
	private long tokenExpirationMs;
	private FreepassProperties freepass;

	@Data
	public static class FreepassProperties {
		private boolean enable;
		private String masterToken;
	}
}
