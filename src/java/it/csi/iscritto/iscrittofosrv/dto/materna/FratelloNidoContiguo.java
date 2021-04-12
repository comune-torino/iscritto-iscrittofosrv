package it.csi.iscritto.iscrittofosrv.dto.materna;

import java.io.Serializable;

import it.csi.iscritto.iscrittofosrv.dto.nido.Anagrafica;

public class FratelloNidoContiguo implements Serializable {
	static final long serialVersionUID = 1;

	private Boolean stato;
	private Anagrafica anagrafica;

	public Boolean getStato() {
		return stato;
	}

	public void setStato(Boolean stato) {
		this.stato = stato;
	}

	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

}
