package it.csi.iscritto.iscrittofosrv.integration.service.notificatore.config;

import java.io.Serializable;

public class NotificatoreServiceConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	private String preferencesUrl;
	private String preferencesToken;
	private String messagebrokerUrl;
	private String messagebrokerToken;

	public String getPreferencesUrl() {
		return preferencesUrl;
	}

	public void setPreferencesUrl(String preferencesUrl) {
		this.preferencesUrl = preferencesUrl;
	}

	public String getPreferencesToken() {
		return preferencesToken;
	}

	public void setPreferencesToken(String preferencesToken) {
		this.preferencesToken = preferencesToken;
	}

	public String getMessagebrokerUrl() {
		return messagebrokerUrl;
	}

	public void setMessagebrokerUrl(String messagebrokerUrl) {
		this.messagebrokerUrl = messagebrokerUrl;
	}

	public String getMessagebrokerToken() {
		return messagebrokerToken;
	}

	public void setMessagebrokerToken(String messagebrokerToken) {
		this.messagebrokerToken = messagebrokerToken;
	}

}
