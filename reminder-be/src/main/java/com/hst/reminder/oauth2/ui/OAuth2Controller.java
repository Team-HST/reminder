package com.hst.reminder.oauth2.ui;

import com.google.common.collect.ImmutableMap;
import com.hst.reminder.configuration.AppProperties;
import com.hst.reminder.configuration.aware.AppPropertiesAware;
import com.hst.reminder.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dlgusrb0808@gmail.com
 */
@Controller
@RequestMapping("oauth2")
public class OAuth2Controller implements AppPropertiesAware {

	private AppProperties appProperties;

	@GetMapping("finalize-authorization")
	public String authorized(@RequestParam String token, @RequestParam Long memberId) {
		return "redirect:" + buildAuthorizationFinalizeUrl(token, memberId);
	}

	// Template: ${host}/login-success?token=${token}&memberId=${memberId}
	private String buildAuthorizationFinalizeUrl(String token, Long memberId) {
		AppProperties.OAuth2 oAuth2 = appProperties.getOauth2();

		return StringUtils.template(oAuth2.getAuthorizationFinalizeUrlTemplate(),
				ImmutableMap.of("host", oAuth2.getReminderServiceFE(), "token", token, "memberId", memberId));
	}

	@Override
	public void setAppProperties(AppProperties appProperties) {
		this.appProperties = appProperties;
	}
}
