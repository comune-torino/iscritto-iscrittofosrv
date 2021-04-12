package it.csi.iscritto.iscrittofosrv.dto.validazione;

import java.io.Serializable;
import java.util.Objects;

public class InfoPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String dataInizio = null;
	private String dataFine = null;

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InfoPeriodo infoPeriodo = (InfoPeriodo) o;
		return Objects.equals(dataInizio, infoPeriodo.dataInizio) &&
				Objects.equals(dataFine, infoPeriodo.dataFine);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataInizio, dataFine);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InfoPeriodo {\n");

		sb.append("    dataInizio: ").append(toIndentedString(dataInizio)).append("\n");
		sb.append("    dataFine: ").append(toIndentedString(dataFine)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
