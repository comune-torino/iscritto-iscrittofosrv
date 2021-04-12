package it.csi.iscritto.iscrittofosrv.integration.converter.luoghi;

import it.csi.iscritto.iscrittofosrv.dto.luoghi.Provincia;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.luoghi.Luogo;

public class ProvinciaConverter extends AbstractConverter<Luogo, Provincia> {

	@Override
	public Provincia convert(Luogo source) {
		Provincia target = null;
		if (source != null) {
			target = new Provincia();

			target.setCodice(source.getIstatProvincia());
			target.setDescrizione(source.getDescProvincia());
		}

		return target;
	}

}
