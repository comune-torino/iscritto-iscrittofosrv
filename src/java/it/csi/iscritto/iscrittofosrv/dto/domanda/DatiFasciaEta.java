package it.csi.iscritto.iscrittofosrv.dto.domanda;

import java.io.Serializable;
import java.util.Date;

public class DatiFasciaEta implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codAnnoScolastico;
	private String codOrdineScuola;
	private String codFasciaEta;
	private Date dataDa;
	private Date dataA;
	private String annoLimite;

	public String getCodAnnoScolastico() {
		return codAnnoScolastico;
	}

	public void setCodAnnoScolastico(String codAnnoScolastico) {
		this.codAnnoScolastico = codAnnoScolastico;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
	}

	public String getCodFasciaEta() {
		return codFasciaEta;
	}

	public void setCodFasciaEta(String codFasciaEta) {
		this.codFasciaEta = codFasciaEta;
	}

	public Date getDataDa() {
		return dataDa;
	}

	public void setDataDa(Date dataDa) {
		this.dataDa = dataDa;
	}

	public Date getDataA() {
		return dataA;
	}

	public void setDataA(Date dataA) {
		this.dataA = dataA;
	}

	public String getAnnoLimite() {
		return annoLimite;
	}

	public void setAnnoLimite(String annoLimite) {
		this.annoLimite = annoLimite;
	}

}
