package com.hst.reminder.code.ui;

import com.hst.reminder.code.application.CodeService;
import com.hst.reminder.code.ui.response.CodeGroupResponse;
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

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("codes")
@Api(tags = SwaggerConfiguration.CODE_API_TAG)
public class CodeController {

	private final CodeService codeService;

	public CodeController(CodeService codeService) {
		this.codeService = codeService;
	}

	@ApiOperation(value = "모든 코드그룹 조회", notes = "시스템에서 사용하는 모든 코드그룹을 조회합니다.")
	@GetMapping
	public ResponseEntity<List<CodeGroupResponse>> getAllCodeGroups() {
		return ResponseEntity.ok(codeService.getAllCodeGroup());
	}

	@ApiOperation(value = "코드그룹 조회", notes = "코드그룹을 조회합니다.")
	@ApiImplicitParams({
			@ApiImplicitParam(
					name = "codeGroup",
					value = "코드그룹<br>" +
							"publisher-protocols: 발행자 프로토콜 타입",
					required = true,
					dataType = "string",
					paramType = "path"
			),
	})
	@GetMapping("{codeGroup}")
	public ResponseEntity<CodeGroupResponse> getCodeGroup(@PathVariable String codeGroup) {
		CodeGroupResponse response = codeService.getCodeGroup(codeGroup);
		return ResponseEntity.ok(response);
	}

}
