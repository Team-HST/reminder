package com.hst.reminder.oauth2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dlgusrb0808@gmail.com
 */
@Controller
@RequestMapping("oauth2")
public class OAuth2Controller {

	private static final Logger logger = LoggerFactory.getLogger(OAuth2Controller.class);

	@GetMapping("authorized")
	public String authorized(OAuth2AuthenticationToken token) {
		return null;
	}

}
