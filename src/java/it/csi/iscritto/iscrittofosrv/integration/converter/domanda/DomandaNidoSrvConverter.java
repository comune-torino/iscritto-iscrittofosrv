package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import static it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils.toArray;

import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaNido;
import it.csi.iscritto.serviscritto.dto.domanda.Nido;

public class DomandaNidoSrvConverter extends AbstractConverter<it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido, DomandaNido> {

	@Override
	public DomandaNido convert(it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido source) {
		DomandaNido target = null;
		if (source != null) {
			target = new DomandaNido();
			target.setAffido(new DomandaSrvConverters.AffidoConverter().convert(source.getAffido()));
			target.setAltriComponenti(new DomandaSrvConverters.AltriComponentiConverter().convert(source.getAltriComponenti()));
			target.setComponentiNucleo(new DomandaSrvConverters.ComponentiNucleoConverter().convert(source.getComponentiNucleo()));
			target.setElencoNidi(toArray(new NidoConverter().convertAll(source.getElencoNidi()), Nido.class));
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setInfoAutocertificazione(source.getInfoAutocertificazione());
			target.setInfoGdpr(source.getInfoGdpr());
			target.setNao(source.getNao());
			target.setCodiceFiscaleUtenteIns(source.getCodiceFiscaleOperatore());
			target.setCodiceFiscaleUtenteMod(source.getCodiceFiscaleOperatore());
			target.setIsee(new DomandaSrvConverters.IseeConverter().convert(source.getIsee()));
			target.setMinore(new DomandaSrvConverters.MinoreConverter().convert(source.getMinore()));
			target.setOrdineScuola(source.getOrdineScuola());
			target.setResponsabilitaGenitoriale(source.getResponsabilitaGenitoriale());
			target.setRichiedente(new DomandaSrvConverters.RichiedenteConverter().convert(source.getRichiedente()));
			target.setSoggetto1(new DomandaSrvConverters.Soggetto1Converter().convert(source.getSoggetto1()));
			target.setSoggetto2(new DomandaSrvConverters.Soggetto2Converter().convert(source.getSoggetto2()));
			target.setSoggetto3(new DomandaSrvConverters.Soggetto3Converter(
					source.getRichiedente(),
					source.getSoggetto1())
							.convert(source.getSoggetto3()));
			target.setStatoDomanda(source.getStatoDomanda());

			// campi aggiuntivi
			target.setConsensoConvenzionata(source.getConsensoConvenzionata());
		}

		return target;
	}

	public static class NidoConverter extends AbstractConverter<it.csi.iscritto.iscrittofosrv.dto.nido.Nido, Nido> {
		@Override
		public Nido convert(it.csi.iscritto.iscrittofosrv.dto.nido.Nido source) {
			Nido target = null;
			if (source != null) {
				target = new Nido();

				target.setCodCategoriaScuola(source.getCodCategoriaScuola());
				target.setCodCircoscrizione(source.getCodCircoscrizione());
				target.setCodScuola(source.getCodScuola());
				target.setCodTipoFrequenza(source.getCodTipoFrequenza());
				target.setDescrizione(source.getDescrizione());
				target.setId(null);
				target.setIndirizzo(source.getIndirizzo());
			}

			return target;
		}
	}

}
