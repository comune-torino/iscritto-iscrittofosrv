package it.csi.iscritto.iscrittofosrv.dto.domanda;

import java.io.Serializable;

public class DatiRicevuta implements Serializable {
	private static final long serialVersionUID = 1L;

	private String protocollo;
	private String annoScolastico;

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getAnnoScolastico() {
		return annoScolastico;
	}

	public void setAnnoScolastico(String annoScolastico) {
		this.annoScolastico = annoScolastico;
	}

}
