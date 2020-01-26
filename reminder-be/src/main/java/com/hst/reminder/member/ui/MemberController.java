package com.hst.reminder.member.ui;

import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.member.application.command.MemberProfileResponse;
import com.hst.reminder.member.application.command.SignupRequest;
import com.hst.reminder.member.domain.MemberId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("members")
public class MemberController {

	private MemberService memberService;

	@PostMapping("signup")
	public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
		memberService.signup(request);
		return null;
	}

	@GetMapping("{memberId}")
	public ResponseEntity<MemberProfileResponse> getMemberProfile(@PathVariable Long memberId) {
		return ResponseEntity.ok(memberService.getMemberProfile(memberId));
	}

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
