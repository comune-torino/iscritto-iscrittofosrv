package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiFasciaEta;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.FasciaEta;

public class DatiFasciaEtaConverter extends AbstractConverter<FasciaEta, DatiFasciaEta> {

	@Override
	public DatiFasciaEta convert(FasciaEta source) {
		DatiFasciaEta target = null;
		if (source != null) {
			target = new DatiFasciaEta();

			target.setAnnoLimite(source.getAnnoLimite());
			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodFasciaEta(source.getCodFasciaEta());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setDataA(source.getDataA());
			target.setDataDa(source.getDataDa());
		}

		return target;
	}

}
