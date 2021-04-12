package it.csi.iscritto.iscrittofosrv.dto.nido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AltriComponenti implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean stato;
	private List<SoggettoAltroComponente> soggetti = new ArrayList<>();

	public Boolean getStato() {
		return stato;
	}

	public void setStato(Boolean stato) {
		this.stato = stato;
	}

	public List<SoggettoAltroComponente> getSoggetti() {
		return soggetti;
	}

	public void setSoggetti(List<SoggettoAltroComponente> soggetti) {
		this.soggetti = soggetti;
	}

}
