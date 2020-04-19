package com.hst.reminder.member.ui;

import com.hst.reminder.configuration.SwaggerConfiguration;
import com.hst.reminder.member.application.MemberService;
import com.hst.reminder.member.ui.response.MemberProfileResponse;
import com.hst.reminder.publisher.application.PublisherService;
import com.hst.reminder.publisher.ui.response.PublisherListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Api(tags = SwaggerConfiguration.MEMBER_API_TAG)
public class MemberController {

	private final MemberService memberService;
	private final PublisherService publisherService;

	@ApiOperation(value = "회원 프로필 조회", notes = "회원 프로필을 조회합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "memberId",
					value = "조회할 회원의 ID",
					required = true,
					dataType = "long",
					paramType = "path"
			),
	})
	@GetMapping("{memberId}")
	public ResponseEntity<MemberProfileResponse> getMemberProfile(@PathVariable Long memberId) {
		return ResponseEntity.ok(memberService.getMemberProfile(memberId));
	}

	@ApiOperation(value = "회원 발행자 목록 조회", notes = "회원의 발행자 목록을 조회합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "memberId",
					value = "조회할 회원의 ID",
					required = true,
					dataType = "long",
					paramType = "path"
			),
	})
	@GetMapping("{memberId}/publishers")
	public ResponseEntity<PublisherListResponse> getPublisherByMemberId(@PathVariable Long memberId) {
		PublisherListResponse response = publisherService.getPublishersByMemberId(memberId);
		return ResponseEntity.ok(response);
	}
}
