package com.hst.reminder.code.application;

import com.hst.reminder.code.type.CodeInformations;
import com.hst.reminder.code.ui.response.CodeGroupResponse;
import com.hst.reminder.common.exception.NotFoundException;
import com.hst.reminder.common.type.PersistableType;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class CodeService {
	public CodeGroupResponse getCodeGroup(String codeGroup) {
		Set<? extends PersistableType<?>> codes = CodeInformations.get(codeGroup);
		if (codes == null) {
			throw new NotFoundException("CodeGroup", codeGroup);
		}
		return CodeGroupResponse.of(codeGroup, codes);
	}

}
