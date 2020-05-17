package com.hst.reminder.configuration.app;

import lombok.Data;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Data
public class OAuth2Properties {
	private String authorizationFinalizeUrlTemplate;
	private String reminderServiceFE;
	private List<String> authorizedRedirectUris;
}
