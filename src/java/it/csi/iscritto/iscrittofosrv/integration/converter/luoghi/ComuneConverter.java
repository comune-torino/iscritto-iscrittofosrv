package it.csi.iscritto.iscrittofosrv.integration.converter.luoghi;

import it.csi.iscritto.iscrittofosrv.dto.luoghi.Comune;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.luoghi.Luogo;

public class ComuneConverter extends AbstractConverter<Luogo, Comune> {

	@Override
	public Comune convert(Luogo source) {
		Comune target = null;
		if (source != null) {
			target = new Comune();

			target.setCodice(source.getIstatComune());
			target.setDescrizione(source.getDescComune());
		}

		return target;
	}

}
