package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import it.csi.iscritto.iscrittofosrv.dto.materna.DatiAnnoListaAttesa;
import it.csi.iscritto.iscrittofosrv.dto.materna.DatiListaAttesa;
import it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna;
import it.csi.iscritto.iscrittofosrv.dto.materna.FratelloNidoContiguo;
import it.csi.iscritto.iscrittofosrv.dto.materna.ListaAttesa;
import it.csi.iscritto.iscrittofosrv.dto.materna.Materna;
import it.csi.iscritto.iscrittofosrv.dto.materna.MinoreMaterna;
import it.csi.iscritto.iscrittofosrv.dto.materna.NidoContiguo;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaConverters.AnagraficaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaConverters.DisabilitaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaConverters.FratelloFrequentanteConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaConverters.LuogoNascitaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaConverters.ProblemiSaluteConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaConverters.ResidenzaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaConverters.ServiziSocialiConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaConverters.SpostamentoConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaConverters.TrasferimentoConverter;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;

public final class DomandaMaternaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna, DomandaMaterna> {

	@Override
	public DomandaMaterna convert(it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna source) {
		DomandaMaterna target = null;
		if (source != null) {
			target = new DomandaMaterna();
			target.setAffido(new DomandaConverters.AffidoConverter().convert(source.getAffido()));
			target.setAltriComponenti(new DomandaConverters.AltriComponentiConverter().convert(source.getAltriComponenti()));
			target.setComponentiNucleo(new DomandaConverters.ComponentiNucleoConverter().convert(source.getComponentiNucleo()));
			target.setDataInserimento(DateUtils.toStringDate(source.getDataInserimento(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setDataUltimaModifica(DateUtils.toStringDate(source.getDataUltimaModifica(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setElencoMaterne(new MaternaConverter().convertAll(source.getElencoMaterne()));
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setInfoAutocertificazione(source.getInfoAutocertificazione());
			target.setInfoGdpr(source.getInfoGdpr());
			target.setNao(source.getNao());
			target.setCodiceFiscaleOperatore(source.getCodiceFiscaleUtenteMod());
			target.setIsee(new DomandaConverters.IseeConverter().convert(source.getIsee()));
			target.setMinore(new MinoreMaternaConverter().convert(source.getMinore()));
			target.setOrdineScuola(source.getOrdineScuola());
			target.setProtocollo(source.getProtocollo());
			target.setResponsabilitaGenitoriale(source.getResponsabilitaGenitoriale());
			target.setRichiedente(new DomandaConverters.RichiedenteConverter().convert(source.getRichiedente()));
			target.setSoggetto1(new DomandaConverters.Soggetto1Converter().convert(source.getSoggetto1()));
			target.setSoggetto2(new DomandaConverters.Soggetto2Converter().convert(source.getSoggetto2()));
			target.setSoggetto3(new DomandaConverters.Soggetto3Converter().convert(source.getSoggetto3()));
			target.setStatoDomanda(source.getStatoDomanda());

			// campi aggiuntivi
			target.setAnnoScolastico(source.getAnnoScolastico());
			target.setConsensoConvenzionata(source.getConsensoConvenzionata());

			target.setFlIrc(source.getFlIrc());
		}

		return target;
	}

	public static class MaternaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Materna, Materna> {
		private String dateFormat;

		public MaternaConverter() {
			this.dateFormat = DateUtils.DEFAULT_DATE_FORMAT;
		}

		public MaternaConverter(String dateFormat) {
			this.dateFormat = dateFormat;
		}

		@Override
		public Materna convert(it.csi.iscritto.serviscritto.dto.domanda.Materna source) {
			Materna target = null;
			if (source != null) {
				target = new Materna();

				target.setCodCategoriaScuola(source.getCodCategoriaScuola());
				target.setCodCircoscrizione(source.getCodCircoscrizione());
				target.setCodScuola(source.getCodScuola());
				target.setCodStatoScuola(source.getCodStatoScuola());
				target.setCodTipoFrequenza(source.getCodTipoFrequenza());
				target.setDataUltimoCambioStato(DateUtils.toStringDate(source.getDataUltimoCambioStato(), this.dateFormat));
				target.setDescrizione(source.getDescrizione());
				target.setIndirizzo(source.getIndirizzo());
				target.setPunteggio(source.getPunteggio());
				target.setContiguo(new NidoContiguoConverter().convert(source.getNidoContiguo()));
			}

			return target;
		}
	}

	public static class MinoreMaternaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Minore, MinoreMaterna> {
		@Override
		public MinoreMaterna convert(it.csi.iscritto.serviscritto.dto.domanda.Minore source) {
			MinoreMaterna target = null;
			if (source != null) {
				target = new MinoreMaterna();

				target.setId(source.getId());
				target.setAnagrafica(new AnagraficaConverter().convert(source.getAnagrafica()));
				target.setDisabilita(new DisabilitaConverter().convert(source.getDisabilita()));
				target.setFratelloFrequentante(new FratelloFrequentanteConverter().convert(source.getFratelloFrequentante()));
				target.setLuogoNascita(new LuogoNascitaConverter().convert(source.getLuogoNascita()));
				target.setPresenzaNucleo(source.getPresenzaNucleo());
				target.setProblemiSalute(new ProblemiSaluteConverter().convert(source.getProblemiSalute()));
				target.setResidenza(new ResidenzaConverter().convert(source.getResidenza()));
				target.setResidenzaConRichiedente(source.getResidenzaConRichiedente());
				target.setServiziSociali(new ServiziSocialiConverter().convert(source.getServiziSociali()));
				target.setSpostamento(new SpostamentoConverter().convert(source.getSpostamento()));
				target.setTrasferimento(new TrasferimentoConverter().convert(source.getTrasferimento()));

				// campi aggiuntivi
				target.setCinqueAnniNonFrequentante(source.getCinqueAnniNonFrequentante());
				target.setListaAttesa(new ListaAttesaConverter().convert(source.getListaAttesa()));
				target.setFratelloNidoContiguo(new FratelloNidoContiguoConverter().convert(source.getFratelloNidoContiguo()));
			}

			return target;
		}
	}

	public static class ListaAttesaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa, ListaAttesa> {
		@Override
		public ListaAttesa convert(it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa source) {
			ListaAttesa target = null;
			if (source != null) {
				target = new ListaAttesa();

				target.setStato(source.getStato());
				target.setDati(new DatiListaAttesaConverter().convert(source.getDati()));
			}

			return target;
		}
	}

	public static class DatiListaAttesaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DatiListaAttesa, DatiListaAttesa> {
		@Override
		public DatiListaAttesa convert(it.csi.iscritto.serviscritto.dto.domanda.DatiListaAttesa source) {
			DatiListaAttesa target = null;
			if (source != null) {
				target = new DatiListaAttesa();

				target.setPrimoAnno(new DatiAnnoListaAttesaConverter().convert(source.getPrimoAnno()));
				target.setSecondoAnno(new DatiAnnoListaAttesaConverter().convert(source.getSecondoAnno()));
			}

			return target;
		}
	}

	public static class DatiAnnoListaAttesaConverter
			extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa, DatiAnnoListaAttesa> {

		@Override
		public DatiAnnoListaAttesa convert(it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa source) {
			DatiAnnoListaAttesa target = null;
			if (source != null) {
				target = new DatiAnnoListaAttesa();

				target.setAnnoScolastico(source.getAnnoScolastico());
				target.setScuola(source.getScuola());
			}

			return target;
		}
	}

	public static class FratelloNidoContiguoConverter
			extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo, FratelloNidoContiguo> {

		@Override
		public FratelloNidoContiguo convert(it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo source) {
			FratelloNidoContiguo target = null;
			if (source != null) {
				target = new FratelloNidoContiguo();

				target.setStato(source.getStato());
				target.setAnagrafica(new DomandaConverters.AnagraficaConverter().convert(source.getAnagrafica()));
			}

			return target;
		}
	}

	public static class NidoContiguoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.NidoContiguo, NidoContiguo> {
		@Override
		public NidoContiguo convert(it.csi.iscritto.serviscritto.dto.domanda.NidoContiguo source) {
			NidoContiguo target = null;
			if (source != null) {
				target = new NidoContiguo();

				target.setDescrizione(source.getDescrizione());
				target.setIndirizzo(source.getIndirizzo());
			}

			return target;
		}
	}

}
