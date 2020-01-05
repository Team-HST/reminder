package com.hst.reminder.configuration.aware;

import com.hst.reminder.configuration.AppProperties;
import org.springframework.beans.factory.Aware;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface AppPropertiesAware extends Aware {
	void setAppProperties(AppProperties appProperties);
}
