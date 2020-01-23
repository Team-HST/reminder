package com.hst.reminder.authentication.domain;

import com.hst.reminder.configuration.aware.AppPropertiesAware;
import com.hst.reminder.member.domain.MemberId;

/**
 * @author dlgusrb0808@gmail.com
 */
public interface AuthenticationTokenProvider extends AppPropertiesAware {

	AuthenticationToken issue(MemberId tokenOwnerId);

	Long getTokenOwnerId(String token);

	boolean validateTokenValue(String token);

}
