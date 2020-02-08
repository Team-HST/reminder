package com.hst.reminder.code.ui;

import com.hst.reminder.code.application.CodeService;
import com.hst.reminder.code.ui.response.CodeGroupResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("codes")
public class CodeController {

	private final CodeService codeService;

	public CodeController(CodeService codeService) {
		this.codeService = codeService;
	}

	@GetMapping("{codeGroup}")
	public ResponseEntity<CodeGroupResponse> getCodeGroup(@PathVariable String codeGroup) {
		return ResponseEntity.ok(codeService.getCodeGroup(codeGroup));
	}

}
