package it.csi.iscritto.iscrittofosrv.dto.profilazione;

import java.io.Serializable;

public class Profilazione implements Serializable{
	private static final long serialVersionUID = 1L;

	private Boolean result;
	private Boolean nidi;
	private Boolean materne;

	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public Boolean getNidi() {
		return nidi;
	}
	public void setNidi(Boolean nidi) {
		this.nidi = nidi;
	}
	public Boolean getMaterne() {
		return materne;
	}
	public void setMaterne(Boolean materne) {
		this.materne = materne;
	}








}