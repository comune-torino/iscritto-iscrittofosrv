package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import it.csi.iscritto.iscrittofosrv.dto.domanda.RicevutaAccettazione;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;

public class RicevutaAccettazioneConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.RicevutaAccettazione, RicevutaAccettazione> {

	@Override
	public RicevutaAccettazione convert(it.csi.iscritto.serviscritto.dto.domanda.RicevutaAccettazione source) {
		RicevutaAccettazione target = null;
		if (source != null) {
			target = new RicevutaAccettazione();

			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodiceCategoriaScu(source.getCodiceCategoriaScu());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCodScuola(source.getCodScuola());
			target.setCodTipoFrequenza(source.getCodTipoFrequenza());
			target.setCodTipoPasto(source.getCodTipoPasto());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setDataConsegna(source.getDataConsegna());
			target.setDataOperazione(source.getDataOperazione());
			target.setDescScuola(source.getDescScuola());
			target.setDescTipoFrequenza(source.getDescTipoFrequenza());
			target.setDescTipoPasto(source.getDescTipoPasto());
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setIndirizzoScuola(source.getIndirizzoScuola());
			target.setNomeMinore(source.getNomeMinore());
			target.setProtocolloDomanda(source.getProtocolloDomanda());
		}

		return target;
	}

}
