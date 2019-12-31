package com.hst.reminder.oauth2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dlgusrb0808@gmail.com
 */
@Controller
@RequestMapping("oauth2")
public class OAuth2Controller {

	private static final Logger logger = LoggerFactory.getLogger(OAuth2Controller.class);

	@GetMapping("finalize-authorization")
	public String authorized(@RequestParam String token, @RequestParam Long memberId) {
		String parameters = String.format("?token=%s&memberId=%d", token, memberId);
		return "redirect:http://localhost:8080/login-success" + parameters;
	}

}
