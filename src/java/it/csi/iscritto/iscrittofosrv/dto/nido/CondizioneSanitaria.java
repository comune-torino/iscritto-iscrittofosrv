package it.csi.iscritto.iscrittofosrv.dto.nido;

import java.io.Serializable;

public class CondizioneSanitaria implements Serializable {
	private static final long serialVersionUID = 1L;

	private Disabilita disabilita;
	private ProblemiSalute problemiSalute;
	private Gravidanza gravidanza;

	public Disabilita getDisabilita() {
		return disabilita;
	}

	public void setDisabilita(Disabilita disabilita) {
		this.disabilita = disabilita;
	}

	public ProblemiSalute getProblemiSalute() {
		return problemiSalute;
	}

	public void setProblemiSalute(ProblemiSalute problemiSalute) {
		this.problemiSalute = problemiSalute;
	}

	public Gravidanza getGravidanza() {
		return gravidanza;
	}

	public void setGravidanza(Gravidanza gravidanza) {
		this.gravidanza = gravidanza;
	}

}
