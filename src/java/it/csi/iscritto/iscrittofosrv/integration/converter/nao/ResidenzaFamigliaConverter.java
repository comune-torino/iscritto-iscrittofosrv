package it.csi.iscritto.iscrittofosrv.integration.converter.nao;

import org.apache.commons.lang3.StringUtils;

import it.csi.iscritto.iscrittofosrv.dto.nao.ResidenzaFamiglia;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.IndirizzoInterno;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;

public class ResidenzaFamigliaConverter extends AbstractConverter<IndirizzoInterno, ResidenzaFamiglia> {

	private static final String COD_NAZIONE = "000";
	private static final String DESC_NAZIONE = "ITALIA";
	private static final String COD_REGIONE = "01";
	private static final String DESC_REGIONE = "PIEMONTE";
	private static final String COD_PROVINCIA = "001";
	private static final String DESC_PROVINCIA = "TORINO";
	private static final String COD_COMUNE = "001272";
	private static final String DESC_COMUNE = "TORINO";

	@Override
	public ResidenzaFamiglia convert(IndirizzoInterno source) {
		ResidenzaFamiglia target = null;
		if (source != null) {
			target = new ResidenzaFamiglia();

			target.setCodNazione(COD_NAZIONE);
			target.setDescNazione(DESC_NAZIONE);
			target.setCodRegione(COD_REGIONE);
			target.setDescRegione(DESC_REGIONE);
			target.setCodProvincia(COD_PROVINCIA);
			target.setDescProvincia(DESC_PROVINCIA);
			target.setCodComune(COD_COMUNE);
			target.setDescComune(DESC_COMUNE);

			target.setCap(source.getCap());
			target.setIdCircoscrizione(source.getIdCircoscrizione());
			target.setDescCircoscrizione(source.getDescCircoscrizione());

			target.setIndirizzo(buildIndirizzo(source));
		}

		return target;
	}

	private static String buildIndirizzo(IndirizzoInterno source) {
		StringBuilder sb = new StringBuilder();

		append(sb, "%s ", source.getSedime());
		append(sb, "%s, ", source.getDenominazioneVia());
		append(sb, "%d ", source.getNumeroPrimario());
		append(sb, "%s ", source.getBisTer());
		append(sb, "interno %s ", source.getInterno1());
		append(sb, "interno %s ", source.getInterno2());
		append(sb, "scala %s ", source.getScala());

		return sb.toString().trim();
	}

	private static void append(StringBuilder sb, String format, String value) {
		if (StringUtils.isNotBlank(value)) {
			sb.append(String.format(format, value));
		}
	}

	private static void append(StringBuilder sb, String format, Integer value) {
		if (value != null) {
			sb.append(String.format(format, value));
		}
	}

}
