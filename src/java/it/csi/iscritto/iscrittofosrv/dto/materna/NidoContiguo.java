package it.csi.iscritto.iscrittofosrv.dto.materna;

import java.io.Serializable;

public class NidoContiguo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descrizione;
	private String indirizzo;

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

}
