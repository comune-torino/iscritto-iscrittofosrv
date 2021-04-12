package it.csi.iscritto.iscrittofosrv.integration.dao;

public enum TipoScuola {
	NID("NID", "Nido"),
	MAT("MAT", "Scuola dell'infanzia");

	private String cod;
	private String desc;

	private TipoScuola(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public String getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

}
