package it.csi.iscritto.iscrittofosrv.dto.notificatore;

import java.io.Serializable;
import java.util.List;

public class InfoUtente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	private String sms;
	private String email;
	private String serviceName;
	private List<String> channels;

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

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

}
