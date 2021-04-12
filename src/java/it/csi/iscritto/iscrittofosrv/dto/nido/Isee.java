package it.csi.iscritto.iscrittofosrv.dto.nido;

import java.io.Serializable;

public class Isee implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean stato;
	private DatiIsee dati;

	public Boolean getStato() {
		return stato;
	}

	public void setStato(Boolean stato) {
		this.stato = stato;
	}

	public DatiIsee getDati() {
		return dati;
	}

	public void setDati(DatiIsee dati) {
		this.dati = dati;
	}

}
