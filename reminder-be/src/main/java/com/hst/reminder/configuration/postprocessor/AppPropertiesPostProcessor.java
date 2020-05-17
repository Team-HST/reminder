package com.hst.reminder.configuration.postprocessor;

import com.hst.reminder.configuration.app.AppProperties;
import com.hst.reminder.configuration.aware.AppPropertiesAware;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author dlgusrb0808@gmail.com
 */
@Component
public class AppPropertiesPostProcessor implements BeanPostProcessor {

	private final AppProperties appProperties;

	public AppPropertiesPostProcessor(AppProperties appProperties) {
		this.appProperties = appProperties;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof AppPropertiesAware) {
			((AppPropertiesAware)bean).setAppProperties(appProperties);
		}
		return bean;
	}
}
