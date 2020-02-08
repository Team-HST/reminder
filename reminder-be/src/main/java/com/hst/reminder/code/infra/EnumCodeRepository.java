package com.hst.reminder.code.infra;

import com.hst.reminder.code.domain.CodeRepository;
import com.hst.reminder.code.type.CodeInformations;
import com.hst.reminder.common.type.PersistableType;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public class EnumCodeRepository implements CodeRepository {

	@Override
	public Set<? extends PersistableType<?>> findCodesByCodeGroup(String codeGroup) {
		return CodeInformations.get(codeGroup);
	}
}
