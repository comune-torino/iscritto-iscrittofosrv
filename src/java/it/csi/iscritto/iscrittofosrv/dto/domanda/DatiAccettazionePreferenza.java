package it.csi.iscritto.iscrittofosrv.dto.domanda;

import java.io.Serializable;

public class DatiAccettazionePreferenza implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codiceFiscaleRichiedente;
	private String codiceFiscaleOperatore;
	private String numeroTelefonoRichiedente;
	private String codiceTipoPasto;

	public String getCodiceFiscaleRichiedente() {
		return codiceFiscaleRichiedente;
	}

	public void setCodiceFiscaleRichiedente(String codiceFiscaleRichiedente) {
		this.codiceFiscaleRichiedente = codiceFiscaleRichiedente;
	}

	public String getCodiceFiscaleOperatore() {
		return codiceFiscaleOperatore;
	}

	public void setCodiceFiscaleOperatore(String codiceFiscaleOperatore) {
		this.codiceFiscaleOperatore = codiceFiscaleOperatore;
	}

	public String getNumeroTelefonoRichiedente() {
		return numeroTelefonoRichiedente;
	}

	public void setNumeroTelefonoRichiedente(String numeroTelefonoRichiedente) {
		this.numeroTelefonoRichiedente = numeroTelefonoRichiedente;
	}

	public String getCodiceTipoPasto() {
		return codiceTipoPasto;
	}

	public void setCodiceTipoPasto(String codiceTipoPasto) {
		this.codiceTipoPasto = codiceTipoPasto;
	}

}
