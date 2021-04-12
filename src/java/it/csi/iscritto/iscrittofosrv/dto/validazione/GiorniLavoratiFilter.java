package it.csi.iscritto.iscrittofosrv.dto.validazione;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GiorniLavoratiFilter implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<InfoPeriodo> periodi = new ArrayList<InfoPeriodo>();

	public List<InfoPeriodo> getPeriodi() {
		return periodi;
	}

	public void setPeriodi(List<InfoPeriodo> periodi) {
		this.periodi = periodi;
	}

}
