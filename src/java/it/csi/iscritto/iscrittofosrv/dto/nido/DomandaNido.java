package it.csi.iscritto.iscrittofosrv.dto.nido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DomandaNido implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomandaIscrizione;
	private String statoDomanda;
	private String ordineScuola;
	private String annoScolastico;
	private Boolean consensoConvenzionata;
	private Boolean responsabilitaGenitoriale;
	private Boolean infoAutocertificazione;
	private Boolean infoGdpr;
	private Boolean nao;
	private String codiceFiscaleOperatore;
	private String protocollo;
	private String dataInserimento;
	private String dataUltimaModifica;
	private Richiedente richiedente;
	private Minore minore;
	private Soggetto1 soggetto1;
	private Soggetto2 soggetto2;
	private Soggetto3 soggetto3;
	private ComponentiNucleo componentiNucleo;
	private AltriComponenti altriComponenti;
	private Affido affido;
	private Isee isee;
	private List<Nido> elencoNidi = new ArrayList<>();

	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public String getStatoDomanda() {
		return statoDomanda;
	}

	public void setStatoDomanda(String statoDomanda) {
		this.statoDomanda = statoDomanda;
	}

	public String getOrdineScuola() {
		return ordineScuola;
	}

	public void setOrdineScuola(String ordineScuola) {
		this.ordineScuola = ordineScuola;
	}

	public String getAnnoScolastico() {
		return annoScolastico;
	}

	public void setAnnoScolastico(String annoScolastico) {
		this.annoScolastico = annoScolastico;
	}

	public Boolean getConsensoConvenzionata() {
		return consensoConvenzionata;
	}

	public void setConsensoConvenzionata(Boolean consensoConvenzionata) {
		this.consensoConvenzionata = consensoConvenzionata;
	}

	public Boolean getResponsabilitaGenitoriale() {
		return responsabilitaGenitoriale;
	}

	public void setResponsabilitaGenitoriale(Boolean responsabilitaGenitoriale) {
		this.responsabilitaGenitoriale = responsabilitaGenitoriale;
	}

	public Boolean getInfoAutocertificazione() {
		return infoAutocertificazione;
	}

	public void setInfoAutocertificazione(Boolean infoAutocertificazione) {
		this.infoAutocertificazione = infoAutocertificazione;
	}

	public Boolean getInfoGdpr() {
		return infoGdpr;
	}

	public void setInfoGdpr(Boolean infoGdpr) {
		this.infoGdpr = infoGdpr;
	}

	public Boolean getNao() {
		return nao;
	}

	public void setNao(Boolean nao) {
		this.nao = nao;
	}

	public String getCodiceFiscaleOperatore() {
		return codiceFiscaleOperatore;
	}

	public void setCodiceFiscaleOperatore(String codiceFiscaleOperatore) {
		this.codiceFiscaleOperatore = codiceFiscaleOperatore;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(String dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public Richiedente getRichiedente() {
		return richiedente;
	}

	public void setRichiedente(Richiedente richiedente) {
		this.richiedente = richiedente;
	}

	public Minore getMinore() {
		return minore;
	}

	public void setMinore(Minore minore) {
		this.minore = minore;
	}

	public Soggetto1 getSoggetto1() {
		return soggetto1;
	}

	public void setSoggetto1(Soggetto1 soggetto1) {
		this.soggetto1 = soggetto1;
	}

	public Soggetto2 getSoggetto2() {
		return soggetto2;
	}

	public void setSoggetto2(Soggetto2 soggetto2) {
		this.soggetto2 = soggetto2;
	}

	public Soggetto3 getSoggetto3() {
		return soggetto3;
	}

	public void setSoggetto3(Soggetto3 soggetto3) {
		this.soggetto3 = soggetto3;
	}

	public ComponentiNucleo getComponentiNucleo() {
		return componentiNucleo;
	}

	public void setComponentiNucleo(ComponentiNucleo componentiNucleo) {
		this.componentiNucleo = componentiNucleo;
	}

	public AltriComponenti getAltriComponenti() {
		return altriComponenti;
	}

	public void setAltriComponenti(AltriComponenti altriComponenti) {
		this.altriComponenti = altriComponenti;
	}

	public Affido getAffido() {
		return affido;
	}

	public void setAffido(Affido affido) {
		this.affido = affido;
	}

	public Isee getIsee() {
		return isee;
	}

	public void setIsee(Isee isee) {
		this.isee = isee;
	}

	public List<Nido> getElencoNidi() {
		return elencoNidi;
	}

	public void setElencoNidi(List<Nido> elencoNidi) {
		this.elencoNidi = elencoNidi;
	}

}
