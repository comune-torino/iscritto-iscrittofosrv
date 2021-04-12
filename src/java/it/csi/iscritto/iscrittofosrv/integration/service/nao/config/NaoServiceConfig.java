package it.csi.iscritto.iscrittofosrv.integration.service.nao.config;

import java.io.Serializable;

public class NaoServiceConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	// dati utente
	private String codiceUtente;

	// dati identita'
	private String codFiscale;
	private String cognome;
	private String idProvider;
	private Integer livelloAutenticazione;
	private String nome;

	// dati profilati
	private Boolean flgPaternitaMaternita;
	private Boolean flgProtocolliRiservatiE;
	private Boolean flgProtocolliRiservatiQ;
	private Boolean flgRettificheGeneralita;
	private Boolean flgSoggettiCancellati;

	public NaoServiceConfig() {
		this.livelloAutenticazione = 0;

		this.flgPaternitaMaternita = false;
		this.flgProtocolliRiservatiE = false;
		this.flgProtocolliRiservatiQ = false;
		this.flgRettificheGeneralita = false;
		this.flgSoggettiCancellati = false;
	}

	public String getCodiceUtente() {
		return codiceUtente;
	}

	public void setCodiceUtente(String codiceUtente) {
		this.codiceUtente = codiceUtente;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(String idProvider) {
		this.idProvider = idProvider;
	}

	public Integer getLivelloAutenticazione() {
		return livelloAutenticazione;
	}

	public void setLivelloAutenticazione(Integer livelloAutenticazione) {
		this.livelloAutenticazione = livelloAutenticazione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getFlgPaternitaMaternita() {
		return flgPaternitaMaternita;
	}

	public void setFlgPaternitaMaternita(Boolean flgPaternitaMaternita) {
		this.flgPaternitaMaternita = flgPaternitaMaternita;
	}

	public Boolean getFlgProtocolliRiservatiE() {
		return flgProtocolliRiservatiE;
	}

	public void setFlgProtocolliRiservatiE(Boolean flgProtocolliRiservatiE) {
		this.flgProtocolliRiservatiE = flgProtocolliRiservatiE;
	}

	public Boolean getFlgProtocolliRiservatiQ() {
		return flgProtocolliRiservatiQ;
	}

	public void setFlgProtocolliRiservatiQ(Boolean flgProtocolliRiservatiQ) {
		this.flgProtocolliRiservatiQ = flgProtocolliRiservatiQ;
	}

	public Boolean getFlgRettificheGeneralita() {
		return flgRettificheGeneralita;
	}

	public void setFlgRettificheGeneralita(Boolean flgRettificheGeneralita) {
		this.flgRettificheGeneralita = flgRettificheGeneralita;
	}

	public Boolean getFlgSoggettiCancellati() {
		return flgSoggettiCancellati;
	}

	public void setFlgSoggettiCancellati(Boolean flgSoggettiCancellati) {
		this.flgSoggettiCancellati = flgSoggettiCancellati;
	}

}
