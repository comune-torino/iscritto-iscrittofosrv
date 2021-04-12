package it.csi.iscritto.iscrittofosrv.dto.nido;

import java.io.Serializable;

public class DatiTrasferimento implements Serializable {
	private static final long serialVersionUID = 1L;

	private String data;
	private String indirizzoVecchio;
	private String indirizzoNuovo;
	private String indirizzo;
	private String dataDal;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getIndirizzoVecchio() {
		return indirizzoVecchio;
	}

	public void setIndirizzoVecchio(String indirizzoVecchio) {
		this.indirizzoVecchio = indirizzoVecchio;
	}

	public String getIndirizzoNuovo() {
		return indirizzoNuovo;
	}

	public void setIndirizzoNuovo(String indirizzoNuovo) {
		this.indirizzoNuovo = indirizzoNuovo;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getDataDal() {
		return dataDal;
	}

	public void setDataDal(String dataDal) {
		this.dataDal = dataDal;
	}

}
