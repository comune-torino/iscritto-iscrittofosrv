package it.csi.iscritto.iscrittofosrv.integration.converter.luoghi;

import it.csi.iscritto.iscrittofosrv.dto.luoghi.Regione;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.luoghi.Luogo;

public class RegioneConverter extends AbstractConverter<Luogo, Regione> {

	@Override
	public Regione convert(Luogo source) {
		Regione target = null;
		if (source != null) {
			target = new Regione();

			target.setCodice(source.getIstatRegione());
			target.setDescrizione(source.getDescRegione());
		}

		return target;
	}

}
