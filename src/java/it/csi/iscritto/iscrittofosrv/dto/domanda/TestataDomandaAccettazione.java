package it.csi.iscritto.iscrittofosrv.dto.domanda;

import java.io.Serializable;
import java.util.List;

import it.csi.iscritto.iscrittofosrv.dto.nido.Nido;
import it.csi.iscritto.iscrittofosrv.dto.materna.Materna;

/**
 * DTO di testata domanda con incapsulato l'elendo delle preferenze nidi
 *
 * @author 630
 *
 */
public class TestataDomandaAccettazione implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomandaIscrizione;
	private String protocollo;
	private String codOrdineScuola; // ( NID / MAT)
	private String nomeMinore;
	private String cognomeMinore;
	private String codStatoDomanda;
	private String annoScolastico;
	private String dataInvio;
	private String dataUltimaModifica;
	private String telefonoRichiedente;
	private String codiceTipoPasto;
	private List<Nido> elencoPreferenze;
	private List<Materna> elencoPreferenzeMaterna;
	private String irc;

	public String getIrc() {
		return irc;
	}

	public void setIrc(String irc) {
		this.irc = irc;
	}

	public List<Materna> getElencoPreferenzeMaterna() {
		return elencoPreferenzeMaterna;
	}

	public void setElencoPreferenzeMaterna(List<Materna> elencoPreferenzeMaterna) {
		this.elencoPreferenzeMaterna = elencoPreferenzeMaterna;
	}

	private List<DatiCondizionePunteggio> elencoCondizioniPunteggio;

	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
	}

	public String getNomeMinore() {
		return nomeMinore;
	}

	public void setNomeMinore(String nomeMinore) {
		this.nomeMinore = nomeMinore;
	}

	public String getCognomeMinore() {
		return cognomeMinore;
	}

	public void setCognomeMinore(String cognomeMinore) {
		this.cognomeMinore = cognomeMinore;
	}

	public String getCodStatoDomanda() {
		return codStatoDomanda;
	}

	public void setCodStatoDomanda(String codStatoDomanda) {
		this.codStatoDomanda = codStatoDomanda;
	}

	public String getAnnoScolastico() {
		return annoScolastico;
	}

	public void setAnnoScolastico(String annoScolastico) {
		this.annoScolastico = annoScolastico;
	}

	public String getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(String dataInvio) {
		this.dataInvio = dataInvio;
	}

	public String getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(String dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public String getTelefonoRichiedente() {
		return telefonoRichiedente;
	}

	public void setTelefonoRichiedente(String telefonoRichiedente) {
		this.telefonoRichiedente = telefonoRichiedente;
	}

	public String getCodiceTipoPasto() {
		return codiceTipoPasto;
	}

	public void setCodiceTipoPasto(String codiceTipoPasto) {
		this.codiceTipoPasto = codiceTipoPasto;
	}

	public List<Nido> getElencoPreferenze() {
		return elencoPreferenze;
	}

	public void setElencoPreferenze(List<Nido> elencoPreferenze) {
		this.elencoPreferenze = elencoPreferenze;
	}

	public List<DatiCondizionePunteggio> getElencoCondizioniPunteggio() {
		return elencoCondizioniPunteggio;
	}

	public void setElencoCondizioniPunteggio(List<DatiCondizionePunteggio> elencoCondizioniPunteggio) {
		this.elencoCondizioniPunteggio = elencoCondizioniPunteggio;
	}

}
