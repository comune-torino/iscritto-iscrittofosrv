package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido;
import it.csi.iscritto.iscrittofosrv.dto.nido.Nido;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;

public class DomandaNidoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DomandaNido, DomandaNido> {

	@Override
	public DomandaNido convert(it.csi.iscritto.serviscritto.dto.domanda.DomandaNido source) {
		DomandaNido target = null;
		if (source != null) {
			target = new DomandaNido();
			target.setAffido(new DomandaConverters.AffidoConverter().convert(source.getAffido()));
			target.setAltriComponenti(new DomandaConverters.AltriComponentiConverter().convert(source.getAltriComponenti()));
			target.setAnnoScolastico(source.getAnnoScolastico());
			target.setComponentiNucleo(new DomandaConverters.ComponentiNucleoConverter().convert(source.getComponentiNucleo()));
			target.setDataInserimento(DateUtils.toStringDate(source.getDataInserimento(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setDataUltimaModifica(DateUtils.toStringDate(source.getDataUltimaModifica(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setElencoNidi(new NidoConverter().convertAll(source.getElencoNidi()));
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setInfoAutocertificazione(source.getInfoAutocertificazione());
			target.setInfoGdpr(source.getInfoGdpr());
			target.setNao(source.getNao());
			target.setCodiceFiscaleOperatore(source.getCodiceFiscaleUtenteMod());
			target.setIsee(new DomandaConverters.IseeConverter().convert(source.getIsee()));
			target.setMinore(new DomandaConverters.MinoreConverter().convert(source.getMinore()));
			target.setOrdineScuola(source.getOrdineScuola());
			target.setProtocollo(source.getProtocollo());
			target.setResponsabilitaGenitoriale(source.getResponsabilitaGenitoriale());
			target.setRichiedente(new DomandaConverters.RichiedenteConverter().convert(source.getRichiedente()));
			target.setSoggetto1(new DomandaConverters.Soggetto1Converter().convert(source.getSoggetto1()));
			target.setSoggetto2(new DomandaConverters.Soggetto2Converter().convert(source.getSoggetto2()));
			target.setSoggetto3(new DomandaConverters.Soggetto3Converter().convert(source.getSoggetto3()));
			target.setStatoDomanda(source.getStatoDomanda());

			// campi aggiuntivi
			target.setConsensoConvenzionata(source.getConsensoConvenzionata());
		}

		return target;
	}

	public static final class NidoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Nido, Nido> {
		private String dateFormat;

		public NidoConverter() {
			this.dateFormat = DateUtils.DEFAULT_DATE_FORMAT;
		}

		public NidoConverter(String dateFormat) {
			this.dateFormat = dateFormat;
		}

		@Override
		public Nido convert(it.csi.iscritto.serviscritto.dto.domanda.Nido source) {
			Nido target = null;
			if (source != null) {
				target = new Nido();

				target.setCodCategoriaScuola(source.getCodCategoriaScuola());
				target.setCodCircoscrizione(source.getCodCircoscrizione());
				target.setCodScuola(source.getCodScuola());
				target.setCodStatoScuola(source.getCodStatoScuola());
				target.setCodTipoFrequenza(source.getCodTipoFrequenza());
				target.setDataUltimoCambioStato(DateUtils.toStringDate(source.getDataUltimoCambioStato(), this.dateFormat));
				target.setDescrizione(source.getDescrizione());
				target.setIndirizzo(source.getIndirizzo());
				target.setPunteggio(source.getPunteggio());
			}

			return target;
		}
	}

}
