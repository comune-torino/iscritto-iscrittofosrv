package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import static it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils.toArray;

import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaSrvConverters.AnagraficaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaSrvConverters.DisabilitaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaSrvConverters.FratelloFrequentanteConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaSrvConverters.LuogoNascitaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaSrvConverters.ProblemiSaluteConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaSrvConverters.ResidenzaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaSrvConverters.ServiziSocialiConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaSrvConverters.SpostamentoConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaSrvConverters.TrasferimentoConverter;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.DatiListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo;
import it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.Materna;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;

public final class DomandaMaternaSrvConverter extends AbstractConverter<it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna, DomandaMaterna> {

	@Override
	public DomandaMaterna convert(it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna source) {
		DomandaMaterna target = null;
		if (source != null) {
			target = new DomandaMaterna();
			target.setAffido(new DomandaSrvConverters.AffidoConverter().convert(source.getAffido()));
			target.setAltriComponenti(new DomandaSrvConverters.AltriComponentiConverter().convert(source.getAltriComponenti()));
			target.setComponentiNucleo(new DomandaSrvConverters.ComponentiNucleoConverter().convert(source.getComponentiNucleo()));
			target.setElencoMaterne(toArray(new MaternaConverter().convertAll(source.getElencoMaterne()), Materna.class));
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setInfoAutocertificazione(source.getInfoAutocertificazione());
			target.setInfoGdpr(source.getInfoGdpr());
			target.setNao(source.getNao());
			target.setCodiceFiscaleUtenteIns(source.getCodiceFiscaleOperatore());
			target.setCodiceFiscaleUtenteMod(source.getCodiceFiscaleOperatore());
			target.setIsee(new DomandaSrvConverters.IseeConverter().convert(source.getIsee()));
			target.setMinore(new MinoreMaternaConverter().convert(source.getMinore()));
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
			target.setAnnoScolastico(source.getAnnoScolastico());
			target.setConsensoConvenzionata(source.getConsensoConvenzionata());
			
			target.setFlIrc(source.getFlIrc());
		}

		return target;
	}

	public static class MaternaConverter extends AbstractConverter<it.csi.iscritto.iscrittofosrv.dto.materna.Materna, Materna> {
		@Override
		public Materna convert(it.csi.iscritto.iscrittofosrv.dto.materna.Materna source) {
			Materna target = null;
			if (source != null) {
				target = new Materna();

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

	public static class MinoreMaternaConverter extends AbstractConverter<it.csi.iscritto.iscrittofosrv.dto.materna.MinoreMaterna, Minore> {
		@Override
		public Minore convert(it.csi.iscritto.iscrittofosrv.dto.materna.MinoreMaterna source) {
			Minore target = null;
			if (source != null) {
				target = new Minore();

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

	public static class ListaAttesaConverter extends AbstractConverter<it.csi.iscritto.iscrittofosrv.dto.materna.ListaAttesa, ListaAttesa> {
		@Override
		public ListaAttesa convert(it.csi.iscritto.iscrittofosrv.dto.materna.ListaAttesa source) {
			ListaAttesa target = null;
			if (source != null) {
				target = new ListaAttesa();

				target.setStato(source.getStato());
				target.setDati(new DatiListaAttesaConverter().convert(source.getDati()));
			}

			return target;
		}
	}

	public static class DatiListaAttesaConverter extends AbstractConverter<it.csi.iscritto.iscrittofosrv.dto.materna.DatiListaAttesa, DatiListaAttesa> {
		@Override
		public DatiListaAttesa convert(it.csi.iscritto.iscrittofosrv.dto.materna.DatiListaAttesa source) {
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
			extends AbstractConverter<it.csi.iscritto.iscrittofosrv.dto.materna.DatiAnnoListaAttesa, DatiAnnoListaAttesa> {

		@Override
		public DatiAnnoListaAttesa convert(it.csi.iscritto.iscrittofosrv.dto.materna.DatiAnnoListaAttesa source) {
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
			extends AbstractConverter<it.csi.iscritto.iscrittofosrv.dto.materna.FratelloNidoContiguo, FratelloNidoContiguo> {

		@Override
		public FratelloNidoContiguo convert(it.csi.iscritto.iscrittofosrv.dto.materna.FratelloNidoContiguo source) {
			FratelloNidoContiguo target = null;
			if (source != null) {
				target = new FratelloNidoContiguo();

				target.setStato(source.getStato());
				target.setAnagrafica(new DomandaSrvConverters.AnagraficaConverter().convert(source.getAnagrafica()));
			}

			return target;
		}
	}

}
