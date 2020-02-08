package com.hst.reminder.code.application;

import com.hst.reminder.code.domain.CodeRepository;
import com.hst.reminder.code.ui.response.CodeGroupResponse;
import org.springframework.stereotype.Service;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class CodeService {

	private final CodeRepository codeRepository;

	public CodeService(CodeRepository codeRepository) {
		this.codeRepository = codeRepository;
	}

	@SuppressWarnings("unchecked")
	public CodeGroupResponse getCodeGroup(String codeGroup) {
		return CodeGroupResponse.of(codeGroup, codeRepository.findCodesByCodeGroup(codeGroup));
	}

}
