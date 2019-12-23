package com.hst.reminder.member.ui;

import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.member.application.command.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("member")
public class MemberController {

	private MemberService memberService;

	public ResponseEntity<String> signin() {
		return null;
	}

	@PostMapping("signup")
	public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
		memberService.signup(request);
		return null;
	}

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
