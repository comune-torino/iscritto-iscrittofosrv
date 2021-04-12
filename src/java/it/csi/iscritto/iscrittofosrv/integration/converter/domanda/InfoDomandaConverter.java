package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import it.csi.iscritto.iscrittofosrv.dto.domanda.InfoDomanda;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.TestataDomanda;

public class InfoDomandaConverter extends AbstractConverter<TestataDomanda, InfoDomanda> {

	@Override
	public InfoDomanda convert(TestataDomanda source) {
		InfoDomanda target = null;
		if (source != null) {
			target = new InfoDomanda();

			target.setAnnoScolastico(source.getCodiceAnnoScolastico());
			target.setCognome(source.getCognomeMinore());
			target.setDataInvio(DateUtils.toStringDate(source.getDataInvio(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setDataUltimaModifica(DateUtils.toStringDate(source.getDataUltimaModifica(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setNome(source.getNomeMinore());
			target.setOrdineScuola(source.getCodiceOrdineScuola());
			target.setProtocollo(source.getProtocollo());
			target.setStatoDomanda(source.getStatoDomandaCodice());
		}

		return target;
	}

}
