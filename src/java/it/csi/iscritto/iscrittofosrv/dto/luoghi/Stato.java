package it.csi.iscritto.iscrittofosrv.dto.luoghi;

import java.io.Serializable;

public class Stato implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codice;
	private String descrizione;
	private String cittadinanza;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCittadinanza() {
		return cittadinanza;
	}

	public void setCittadinanza(String cittadinanza) {
		this.cittadinanza = cittadinanza;
	}

}
