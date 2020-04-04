package com.hst.reminder.code.application;

import com.hst.reminder.code.type.CodeInformations;
import com.hst.reminder.code.ui.response.CodeGroupResponse;
import com.hst.reminder.common.exception.NotFoundException;
import com.hst.reminder.common.type.PersistableType;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class CodeService {

	/***
	 * 전체 코드그룹 목록 조회
	 * @return 코드그룹 목
	 */
	public List<CodeGroupResponse> getAllCodeGroup() {
		return EnumSet.allOf(CodeInformations.class)
				.stream()
				.map(CodeGroupResponse::from)
				.collect(Collectors.toList());
	}

	/***
	 * 코드그룹 조회
	 * @param codeGroup 코드그룹
	 * @return 코드그룹
	 */
	public CodeGroupResponse getCodeGroup(String codeGroup) {
		Set<? extends PersistableType<?>> codes = CodeInformations.get(codeGroup);
		if (codes == null) {
			throw new NotFoundException("CodeGroup", codeGroup);
		}
		return CodeGroupResponse.of(codeGroup, codes);
	}

}
