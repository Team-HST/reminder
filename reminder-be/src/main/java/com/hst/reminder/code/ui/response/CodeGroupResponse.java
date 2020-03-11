package com.hst.reminder.code.ui.response;

import com.hst.reminder.code.mapper.CodeMapper;
import com.hst.reminder.common.type.PersistableType;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
public class CodeGroupResponse {
	private String codeGroup;
	private Set<CodeResponse> codes;

	public static CodeGroupResponse of(String codeGroup, Set<? extends PersistableType<?>> codes) {
		CodeGroupResponse response = new CodeGroupResponse();
		response.codeGroup = codeGroup;
		response.codes = codes.stream().map(CodeMapper::toCodeResponse).collect(Collectors.toSet());
		return response;
	}
}
