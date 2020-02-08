package com.hst.reminder.code.domain;

import com.hst.reminder.common.type.PersistableType;

import java.util.Set;

/**
 * @author hyungyu.lee@nhn.com
 */
public interface CodeRepository<E extends PersistableType<?>> {
	Set<E> findCodesByCodeGroup(String codeGroup);
}
