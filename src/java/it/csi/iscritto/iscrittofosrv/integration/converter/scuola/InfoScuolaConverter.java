package it.csi.iscritto.iscrittofosrv.integration.converter.scuola;

import it.csi.iscritto.iscrittofosrv.dto.scuola.InfoNidoContiguo;
import it.csi.iscritto.iscrittofosrv.dto.scuola.InfoScuola;
import it.csi.iscritto.iscrittofosrv.integration.dao.TipoScuola;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.scuole.Scuola;

public class InfoScuolaConverter extends AbstractConverter<Scuola, InfoScuola> {

	@Override
	public InfoScuola convert(Scuola source) {
		InfoScuola target = null;
		if (source != null) {
			target = new InfoScuola();

			target.setCodCategoriaScuola(source.getCodCategoriaScuola());
			target.setCodCircoscrizione(source.getCodCircoscrizione());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCodScuola(source.getCodScuola());
			target.setDescCategoriaScuola(source.getDescCategoriaScuola());
			target.setDescCircoscrizione(source.getDescCircoscrizione());
			target.setDescOrdineScuola(source.getDescOrdineScuola());
			target.setDescrizione(source.getDescrizione());
			target.setIndirizzo(source.getIndirizzo());
			target.setAnnoScolastico(source.getAnnoScolastico());
			target.setAlert(source.getAlert());
			target.setTempoBreve(source.getTempoBreve());
			target.setTempoLungo(source.getTempoLungo());
			target.setTempoIntermedio(source.getTempoIntermedio());
			target.setContiguo(getNidoContiguo(source));
		}

		return target;
	}

	private static InfoNidoContiguo getNidoContiguo(Scuola source) {
		if (TipoScuola.NID.getCod().equalsIgnoreCase(source.getCodOrdineScuola())) {
			return null;
		}

		InfoNidoContiguo result = new InfoNidoContiguo();
		result.setDescrizione(source.getDescNidoContiguo());
		result.setIndirizzo(source.getIndirizzoNidoContiguo());

		return result;
	}

}
