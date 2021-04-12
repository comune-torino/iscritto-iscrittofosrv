package it.csi.iscritto.iscrittofosrv.dto.nao;

import java.io.Serializable;

public class PropertyAnnoLimite implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer annoLimite;

	public PropertyAnnoLimite(Integer annoLimite) {
		this.annoLimite = annoLimite;
	}

	public Integer getAnnoLimite() {
		return annoLimite;
	}

	public void setAnnoLimite(Integer annoLimite) {
		this.annoLimite = annoLimite;
	}

}
