package it.csi.iscritto.iscrittofosrv.dto.nao;

import java.io.Serializable;
import java.util.List;

public class ComponenteFamiglia implements Serializable {
	private static final long serialVersionUID = 1L;

	private AnagraficaComponente anagrafica;
	private LuogoNascitaComponente luogoNascita;
	private Boolean iscrizioneNido;
	private List<String> iscrizioneMaterna;
	private String numeroIndividuale;
	private Integer anni;
	private Boolean richiedente;
	private Boolean coniugeRichiedente;
	private String numeroIndividualeConiuge;

	public AnagraficaComponente getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(AnagraficaComponente anagrafica) {
		this.anagrafica = anagrafica;
	}

	public LuogoNascitaComponente getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(LuogoNascitaComponente luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public Boolean getIscrizioneNido() {
		return iscrizioneNido;
	}

	public void setIscrizioneNido(Boolean iscrizioneNido) {
		this.iscrizioneNido = iscrizioneNido;
	}

	public List<String> getIscrizioneMaterna() {
		return iscrizioneMaterna;
	}

	public void setIscrizioneMaterna(List<String> iscrizioneMaterna) {
		this.iscrizioneMaterna = iscrizioneMaterna;
	}

	public String getNumeroIndividuale() {
		return numeroIndividuale;
	}

	public void setNumeroIndividuale(String numeroIndividuale) {
		this.numeroIndividuale = numeroIndividuale;
	}

	public Integer getAnni() {
		return anni;
	}

	public void setAnni(Integer anni) {
		this.anni = anni;
	}

	public Boolean getRichiedente() {
		return richiedente;
	}

	public void setRichiedente(Boolean richiedente) {
		this.richiedente = richiedente;
	}

	public Boolean getConiugeRichiedente() {
		return coniugeRichiedente;
	}

	public void setConiugeRichiedente(Boolean coniugeRichiedente) {
		this.coniugeRichiedente = coniugeRichiedente;
	}

	public String getNumeroIndividualeConiuge() {
		return numeroIndividualeConiuge;
	}

	public void setNumeroIndividualeConiuge(String numeroIndividualeConiuge) {
		this.numeroIndividualeConiuge = numeroIndividualeConiuge;
	}

}
