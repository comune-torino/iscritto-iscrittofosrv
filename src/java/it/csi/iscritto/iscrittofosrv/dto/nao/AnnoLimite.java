package it.csi.iscritto.iscrittofosrv.dto.nao;

import java.io.Serializable;

public class AnnoLimite implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codiceAnnoScolastico;
	private Integer annoLimite;

	public AnnoLimite(String codiceAnnoScolastico, Integer annoLimite) {
		this.codiceAnnoScolastico = codiceAnnoScolastico;
		this.annoLimite = annoLimite;
	}

	public String getCodiceAnnoScolastico() {
		return codiceAnnoScolastico;
	}

	public void setCodiceAnnoScolastico(String codiceAnnoScolastico) {
		this.codiceAnnoScolastico = codiceAnnoScolastico;
	}

	public Integer getAnnoLimite() {
		return annoLimite;
	}

	public void setAnnoLimite(Integer annoLimite) {
		this.annoLimite = annoLimite;
	}

}
