package it.csi.iscritto.iscrittofosrv.integration.service.notificatore.model;

import java.io.Serializable;

public class InfoPreferenze implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	private String serviceName;
	private String channels;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getChannels() {
		return channels;
	}

	public void setChannels(String channels) {
		this.channels = channels;
	}

}
