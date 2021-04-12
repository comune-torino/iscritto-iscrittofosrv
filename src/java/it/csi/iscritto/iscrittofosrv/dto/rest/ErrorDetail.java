package it.csi.iscritto.iscrittofosrv.dto.rest;

import java.io.Serializable;
import java.util.Map;

public class ErrorDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;
	private String title;
	private Map<String, String> detail;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, String> getDetail() {
		return detail;
	}

	public void setDetail(Map<String, String> detail) {
		this.detail = detail;
	}

}
