package it.csi.iscritto.iscrittofosrv.dto.domanda;

import java.io.Serializable;
import java.util.Date;

public class RicevutaAccettazione implements Serializable {
	static final long serialVersionUID = 1;

	private String nomeMinore;
	private String cognomeMinore;
	private String codAnnoScolastico;
	private Long idDomandaIscrizione;
	private String protocolloDomanda;
	private Date dataConsegna;
	private Date dataOperazione;
	private String codScuola;
	private String descScuola;
	private String indirizzoScuola;
	private String codiceCategoriaScu;
	private String codOrdineScuola;
	private String codTipoFrequenza;
	private String descTipoFrequenza;
	private String codTipoPasto;
	private String descTipoPasto;

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

	public String getCodAnnoScolastico() {
		return codAnnoScolastico;
	}

	public void setCodAnnoScolastico(String codAnnoScolastico) {
		this.codAnnoScolastico = codAnnoScolastico;
	}

	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public String getProtocolloDomanda() {
		return protocolloDomanda;
	}

	public void setProtocolloDomanda(String protocolloDomanda) {
		this.protocolloDomanda = protocolloDomanda;
	}

	public Date getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(Date dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public Date getDataOperazione() {
		return dataOperazione;
	}

	public void setDataOperazione(Date dataOperazione) {
		this.dataOperazione = dataOperazione;
	}

	public String getCodScuola() {
		return codScuola;
	}

	public void setCodScuola(String codScuola) {
		this.codScuola = codScuola;
	}

	public String getDescScuola() {
		return descScuola;
	}

	public void setDescScuola(String descScuola) {
		this.descScuola = descScuola;
	}

	public String getIndirizzoScuola() {
		return indirizzoScuola;
	}

	public void setIndirizzoScuola(String indirizzoScuola) {
		this.indirizzoScuola = indirizzoScuola;
	}

	public String getCodiceCategoriaScu() {
		return codiceCategoriaScu;
	}

	public void setCodiceCategoriaScu(String codiceCategoriaScu) {
		this.codiceCategoriaScu = codiceCategoriaScu;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
	}

	public String getCodTipoFrequenza() {
		return codTipoFrequenza;
	}

	public void setCodTipoFrequenza(String codTipoFrequenza) {
		this.codTipoFrequenza = codTipoFrequenza;
	}

	public String getDescTipoFrequenza() {
		return descTipoFrequenza;
	}

	public void setDescTipoFrequenza(String descTipoFrequenza) {
		this.descTipoFrequenza = descTipoFrequenza;
	}

	public String getCodTipoPasto() {
		return codTipoPasto;
	}

	public void setCodTipoPasto(String codTipoPasto) {
		this.codTipoPasto = codTipoPasto;
	}

	public String getDescTipoPasto() {
		return descTipoPasto;
	}

	public void setDescTipoPasto(String descTipoPasto) {
		this.descTipoPasto = descTipoPasto;
	}

}
