package com.hst.reminder.code.mapper;

import com.hst.reminder.code.ui.response.CodeResponse;
import com.hst.reminder.common.type.PersistableType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author dlgusrb0808@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CodeMapper {
	public static CodeResponse toCodeResponse(PersistableType<?> type) {
		return CodeResponse.builder()
				.code(type.getCode().toString())
				.codeName(type.getCodeName())
				.description(type.getDescription())
				.build();
	}
}
