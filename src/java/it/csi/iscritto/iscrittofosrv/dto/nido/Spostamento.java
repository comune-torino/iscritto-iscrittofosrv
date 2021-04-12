package it.csi.iscritto.iscrittofosrv.dto.nido;

import java.io.Serializable;

public class Spostamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean stato;
	private DatiSpostamento dati;

	public Boolean getStato() {
		return stato;
	}

	public void setStato(Boolean stato) {
		this.stato = stato;
	}

	public DatiSpostamento getDati() {
		return dati;
	}

	public void setDati(DatiSpostamento dati) {
		this.dati = dati;
	}

}
