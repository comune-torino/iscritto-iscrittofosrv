package it.csi.iscritto.iscrittofosrv.dto.materna;

import java.io.Serializable;

public class Materna implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codCircoscrizione;
	private String codScuola;
	private String descrizione;
	private String indirizzo;
	private String codTipoFrequenza;
	private String codCategoriaScuola;
	private String dataUltimoCambioStato;
	private String codStatoScuola;
	private Integer punteggio;
	private NidoContiguo contiguo;

	public String getCodCircoscrizione() {
		return codCircoscrizione;
	}

	public void setCodCircoscrizione(String codCircoscrizione) {
		this.codCircoscrizione = codCircoscrizione;
	}

	public String getCodScuola() {
		return codScuola;
	}

	public void setCodScuola(String codScuola) {
		this.codScuola = codScuola;
	}

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

	public String getCodTipoFrequenza() {
		return codTipoFrequenza;
	}

	public void setCodTipoFrequenza(String codTipoFrequenza) {
		this.codTipoFrequenza = codTipoFrequenza;
	}

	public String getCodCategoriaScuola() {
		return codCategoriaScuola;
	}

	public void setCodCategoriaScuola(String codCategoriaScuola) {
		this.codCategoriaScuola = codCategoriaScuola;
	}

	public String getDataUltimoCambioStato() {
		return dataUltimoCambioStato;
	}

	public void setDataUltimoCambioStato(String dataUltimoCambioStato) {
		this.dataUltimoCambioStato = dataUltimoCambioStato;
	}

	public String getCodStatoScuola() {
		return codStatoScuola;
	}

	public void setCodStatoScuola(String codStatoScuola) {
		this.codStatoScuola = codStatoScuola;
	}

	public Integer getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Integer punteggio) {
		this.punteggio = punteggio;
	}

	public NidoContiguo getContiguo() {
		return contiguo;
	}

	public void setContiguo(NidoContiguo contiguo) {
		this.contiguo = contiguo;
	}

}
