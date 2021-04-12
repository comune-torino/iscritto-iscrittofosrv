package it.csi.iscritto.iscrittofosrv.dto.nao;

import java.io.Serializable;
import java.util.Map;

public class InfoNao implements Serializable {
	private static final long serialVersionUID = 1L;

	private DettaglioFamiglia dettaglioFamiglia;
	private Integer annoLimiteNido;
	private Map<String, PropertyAnnoLimite> anniScolasticiMaterna;
	private Boolean erroreNao;

	public DettaglioFamiglia getDettaglioFamiglia() {
		return dettaglioFamiglia;
	}

	public void setDettaglioFamiglia(DettaglioFamiglia dettaglioFamiglia) {
		this.dettaglioFamiglia = dettaglioFamiglia;
	}

	public Integer getAnnoLimiteNido() {
		return annoLimiteNido;
	}

	public void setAnnoLimiteNido(Integer annoLimiteNido) {
		this.annoLimiteNido = annoLimiteNido;
	}

	public Map<String, PropertyAnnoLimite> getAnniScolasticiMaterna() {
		return anniScolasticiMaterna;
	}

	public void setAnniScolasticiMaterna(Map<String, PropertyAnnoLimite> anniScolasticiMaterna) {
		this.anniScolasticiMaterna = anniScolasticiMaterna;
	}

	public Boolean getErroreNao() {
		return erroreNao;
	}

	public void setErroreNao(Boolean erroreNao) {
		this.erroreNao = erroreNao;
	}

}
