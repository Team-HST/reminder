package com.hst.reminder.code.type;

import com.hst.reminder.common.type.PersistableType;
import com.hst.reminder.publisher.domain.PublisherProtocol;
import com.hst.reminder.utils.EnumUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dlgusrb0808@gmail.com
 */
@AllArgsConstructor
@Getter
public enum CodeInformations {
	PUBLISHER_TYPE("publisher-protocols", EnumSet.allOf(PublisherProtocol.class))
	;

	private static final Map<String, CodeInformations> FINDER = EnumUtils.asMap(CodeInformations.class, e -> e.codeGroup);

	private String codeGroup;
	private Set<? extends PersistableType<?>> codeType;

	public static Set<? extends PersistableType<?>> get(String codeGroup) {
		return FINDER.get(codeGroup).codeType;
	}
}
