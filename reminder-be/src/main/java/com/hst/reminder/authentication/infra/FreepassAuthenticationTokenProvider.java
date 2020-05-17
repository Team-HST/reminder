package com.hst.reminder.authentication.infra;

import com.hst.reminder.authentication.domain.AuthenticationToken;
import com.hst.reminder.authentication.domain.AuthenticationTokenProvider;
import com.hst.reminder.configuration.app.AppProperties;
import com.hst.reminder.configuration.app.AuthProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author dlgusrb0808@gmail.com
 */
@Component
@ConditionalOnProperty(prefix = "app", name = "auth.freepass.enable", havingValue = "true")
public class FreepassAuthenticationTokenProvider implements AuthenticationTokenProvider {

	private AppProperties appProperties;

	@Override
	public AuthenticationToken issue(Long tokenOwnerId) {
		return AuthenticationToken.builder()
				.token(String.format("%s_%d", getFreePassProps().getMasterToken(), tokenOwnerId))
				.tokenOwnerId(tokenOwnerId)
				.build();
	}

	@Override
	public Long getTokenOwnerId(String token) {
		String[] items = token.split("_");
		return Long.valueOf(items[1]);
	}

	@Override
	public boolean validateTokenValue(String token) {
		return true;
	}

	private AuthProperties.FreepassProperties getFreePassProps() {
		return appProperties.getAuth().getFreepass();
	}

	@Override
	public void setAppProperties(AppProperties appProperties) {
		this.appProperties = appProperties;
	}
}
