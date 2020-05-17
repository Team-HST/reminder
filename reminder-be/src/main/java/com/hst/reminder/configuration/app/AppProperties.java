package com.hst.reminder.configuration.app;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dlgusrb0808@gmail.com
 */
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {
	private AuthProperties auth;
	private OAuth2Properties oauth2;
}
