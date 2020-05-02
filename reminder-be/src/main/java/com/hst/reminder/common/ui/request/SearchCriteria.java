package com.hst.reminder.common.ui.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author dlgusrb0808@gmail.com
 */
@Data
@NoArgsConstructor
public class SearchCriteria {
	private String type;
	private String keyword;
}
