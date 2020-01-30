package com.hst.reminder.member.ui;

import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.member.ui.response.MemberProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("members")
public class MemberController {

	private MemberService memberService;

	@GetMapping("{memberId}")
	public ResponseEntity<MemberProfileResponse> getMemberProfile(@PathVariable Long memberId) {
		return ResponseEntity.ok(memberService.getMemberProfile(memberId));
	}

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
