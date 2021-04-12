package it.csi.iscritto.iscrittofosrv.dto.domanda;

import java.io.Serializable;

public class DatiCondizionePunteggio implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descrizione;
	private Integer occorrenze;
	private Integer maxOccorrenze;
	private String inAttesa;
	private String note;

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getOccorrenze() {
		return occorrenze;
	}

	public void setOccorrenze(Integer occorrenze) {
		this.occorrenze = occorrenze;
	}

	public Integer getMaxOccorrenze() {
		return maxOccorrenze;
	}

	public void setMaxOccorrenze(Integer maxOccorrenze) {
		this.maxOccorrenze = maxOccorrenze;
	}

	public String getInAttesa() {
		return inAttesa;
	}

	public void setInAttesa(String inAttesa) {
		this.inAttesa = inAttesa;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
