package com.hst.reminder.devtools.ui;

import com.hst.reminder.authentication.domain.AuthenticationToken;
import com.hst.reminder.authentication.domain.AuthenticationTokenProvider;
import com.hst.reminder.configuration.SwaggerConfiguration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("/devtools")
@Api(tags = SwaggerConfiguration.DEV_TOOLS_API_TAG)
public class DevToolsController {

	private final AuthenticationTokenProvider authenticationTokenProvider;

	public DevToolsController(AuthenticationTokenProvider authenticationTokenProvider) {
		this.authenticationTokenProvider = authenticationTokenProvider;
	}

	@ApiOperation(value = "테스트 인증토큰 생성", notes = "특정 유저의 인증토큰(JWT)을 생성합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "memberId",
					value = "토큰 Owner ID",
					required = true,
					dataType = "long",
					paramType = "path"
			),
	})
	@GetMapping("generate-token/{memberId}")
	public ResponseEntity<AuthenticationToken> generateToken(@PathVariable("memberId") Long memberId) {
		return ResponseEntity.ok(authenticationTokenProvider.issue(memberId));
	}

}
