package it.csi.iscritto.iscrittofosrv.integration.service.notificatore.model;

import java.io.Serializable;

public class InfoContatti implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	private String sms;
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
