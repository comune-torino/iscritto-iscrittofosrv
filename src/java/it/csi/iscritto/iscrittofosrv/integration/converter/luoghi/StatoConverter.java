package it.csi.iscritto.iscrittofosrv.integration.converter.luoghi;

import it.csi.iscritto.iscrittofosrv.dto.luoghi.Stato;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.luoghi.Luogo;

public class StatoConverter extends AbstractConverter<Luogo, Stato> {

	@Override
	public Stato convert(Luogo source) {
		Stato target = null;
		if (source != null) {
			target = new Stato();

			target.setCodice(source.getCodice());
			target.setCittadinanza(source.getDescCittadinanza());
			target.setDescrizione(source.getStato());
		}

		return target;
	}

}
