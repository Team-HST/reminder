package com.hst.reminder.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
@Controller
@RequestMapping("oauth")
public class OAuthController {

	private static final Logger logger = LoggerFactory.getLogger(OAuthController.class);

	@GetMapping("github")
	public String githubLogin() {
		logger.info("Login with github");
		return null;
	}

	@GetMapping("authorized")
	public String authorizationSuccessCallback(Map<String, String> map) {
		logger.info("map: {}", map);
		return "redirect:/";
	}

}
