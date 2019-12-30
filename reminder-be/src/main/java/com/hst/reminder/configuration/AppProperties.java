package com.hst.reminder.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {
	private String test;
	private Auth auth;
	private OAuth2 oauth2;


	@Data
	public static class Auth {
		private String tokenSecret;
		private long tokenExpirationMs;
	}

	@Data
	public static class OAuth2 {
		private List<String> authorizedRedirectUris;
	}
}
