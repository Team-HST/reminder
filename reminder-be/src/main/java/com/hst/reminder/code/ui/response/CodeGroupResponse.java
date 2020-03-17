package com.hst.reminder.code.ui.response;

import com.hst.reminder.code.mapper.CodeMapper;
import com.hst.reminder.common.type.PersistableType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
public class CodeGroupResponse {
	@ApiModelProperty(position = 1, value = "코드그룹", example = "publisher-protocols")
	private String codeGroup;
	@ApiModelProperty(position = 2, value = "코드 목록")
	private Set<CodeResponse> codes;

	public static CodeGroupResponse of(String codeGroup, Set<? extends PersistableType<?>> codes) {
		CodeGroupResponse response = new CodeGroupResponse();
		response.codeGroup = codeGroup;
		response.codes = codes.stream().map(CodeMapper::toCodeResponse).collect(Collectors.toSet());
		return response;
	}
}
