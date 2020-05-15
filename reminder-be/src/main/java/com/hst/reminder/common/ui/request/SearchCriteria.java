package com.hst.reminder.common.ui.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author dlgusrb0808@gmail.com
 */
@Setter
@Getter
@NoArgsConstructor
public class SearchCriteria {
	@NotEmpty
	private String type;
	@NotEmpty(message = "검색어를 입력하세요")
	private String keyword;
}
