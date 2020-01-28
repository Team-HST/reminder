package com.hst.reminder.authentication.domain;

import com.hst.reminder.configuration.aware.AppPropertiesAware;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface AuthenticationTokenProvider extends AppPropertiesAware {

	AuthenticationToken issue(Long tokenOwnerId);

	Long getTokenOwnerId(String token);

	boolean validateTokenValue(String token);

}
