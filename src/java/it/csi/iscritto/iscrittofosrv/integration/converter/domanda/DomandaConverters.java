package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import it.csi.iscritto.iscrittofosrv.dto.nido.Affido;
import it.csi.iscritto.iscrittofosrv.dto.nido.AltriComponenti;
import it.csi.iscritto.iscrittofosrv.dto.nido.Anagrafica;
import it.csi.iscritto.iscrittofosrv.dto.nido.Autonomo;
import it.csi.iscritto.iscrittofosrv.dto.nido.ComponentiNucleo;
import it.csi.iscritto.iscrittofosrv.dto.nido.CondizioneOccupazionale;
import it.csi.iscritto.iscrittofosrv.dto.nido.DatiCiDisoccupato;
import it.csi.iscritto.iscrittofosrv.dto.nido.DatiCondizioneOccupazionale;
import it.csi.iscritto.iscrittofosrv.dto.nido.DatiIsee;
import it.csi.iscritto.iscrittofosrv.dto.nido.DatiServiziSociali;
import it.csi.iscritto.iscrittofosrv.dto.nido.DatiSpostamento;
import it.csi.iscritto.iscrittofosrv.dto.nido.DatiTrasferimento;
import it.csi.iscritto.iscrittofosrv.dto.nido.Dipendente;
import it.csi.iscritto.iscrittofosrv.dto.nido.Disabilita;
import it.csi.iscritto.iscrittofosrv.dto.nido.Disoccupato;
import it.csi.iscritto.iscrittofosrv.dto.nido.Documento;
import it.csi.iscritto.iscrittofosrv.dto.nido.File;
import it.csi.iscritto.iscrittofosrv.dto.nido.FratelloFrequentante;
import it.csi.iscritto.iscrittofosrv.dto.nido.GenitoreSolo;
import it.csi.iscritto.iscrittofosrv.dto.nido.Gravidanza;
import it.csi.iscritto.iscrittofosrv.dto.nido.Isee;
import it.csi.iscritto.iscrittofosrv.dto.nido.LuogoNascita;
import it.csi.iscritto.iscrittofosrv.dto.nido.Minore;
import it.csi.iscritto.iscrittofosrv.dto.nido.NonOccupato;
import it.csi.iscritto.iscrittofosrv.dto.nido.ProblemiSalute;
import it.csi.iscritto.iscrittofosrv.dto.nido.Residenza;
import it.csi.iscritto.iscrittofosrv.dto.nido.Richiedente;
import it.csi.iscritto.iscrittofosrv.dto.nido.Sentenza;
import it.csi.iscritto.iscrittofosrv.dto.nido.ServiziSociali;
import it.csi.iscritto.iscrittofosrv.dto.nido.Soggetto1;
import it.csi.iscritto.iscrittofosrv.dto.nido.Soggetto2;
import it.csi.iscritto.iscrittofosrv.dto.nido.Soggetto3;
import it.csi.iscritto.iscrittofosrv.dto.nido.SoggettoAffido;
import it.csi.iscritto.iscrittofosrv.dto.nido.SoggettoAltroComponente;
import it.csi.iscritto.iscrittofosrv.dto.nido.SoggettoNucleo;
import it.csi.iscritto.iscrittofosrv.dto.nido.Spostamento;
import it.csi.iscritto.iscrittofosrv.dto.nido.Studente;
import it.csi.iscritto.iscrittofosrv.dto.nido.Trasferimento;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;

public final class DomandaConverters {
	private DomandaConverters() {
		/* NOP */
	}

	public static class AffidoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Affido, Affido> {
		@Override
		public Affido convert(it.csi.iscritto.serviscritto.dto.domanda.Affido source) {
			Affido target = null;
			if (source != null) {
				target = new Affido();

				target.setSoggetti(new SoggettoAffidoConverter().convertAll(source.getSoggetti()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class SoggettoAffidoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.SoggettoAffido, SoggettoAffido> {
		@Override
		public SoggettoAffido convert(it.csi.iscritto.serviscritto.dto.domanda.SoggettoAffido source) {
			SoggettoAffido target = null;
			if (source != null) {
				target = new SoggettoAffido();

				target.setAnagrafica(new AnagraficaConverter().convert(source.getAnagrafica()));
				target.setId(source.getId());
				target.setLuogoNascita(new LuogoNascitaConverter().convert(source.getLuogoNascita()));
				target.setProblemiSalute(new ProblemiSaluteConverter().convert(source.getProblemiSalute()));
				target.setRelazioneConMinore(source.getRelazioneConMinore());
				target.setResidenza(new ResidenzaConverter().convert(source.getResidenza()));
				target.setSentenza(new SentenzaConverter().convert(source.getSentenza()));
			}

			return target;
		}
	}

	public static class AnagraficaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Anagrafica, Anagrafica> {
		@Override
		public Anagrafica convert(it.csi.iscritto.serviscritto.dto.domanda.Anagrafica source) {
			Anagrafica target = null;
			if (source != null) {
				target = new Anagrafica();

				target.setCodiceFiscale(source.getCodiceFiscale());
				target.setCognome(source.getCognome());
				target.setDataNascita(source.getDataNascita());
				target.setNome(source.getNome());
				target.setOraMinutiNascita(source.getOraMinutiNascita());
				target.setSesso(source.getSesso());
				target.setCodiceCittadinanza(source.getCodCittadinanza());
				target.setDescrizioneCittadinanza(source.getDescCittadinanza());
			}

			return target;
		}
	}

	public static class LuogoNascitaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita, LuogoNascita> {
		@Override
		public LuogoNascita convert(it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita source) {
			LuogoNascita target = null;
			if (source != null) {
				target = new LuogoNascita();

				target.setCodComune(source.getCodComune());
				target.setCodNazione(source.getCodNazione());
				target.setCodProvincia(source.getCodProvincia());
				target.setCodRegione(source.getCodRegione());
				target.setDescComune(source.getDescComune());
				target.setDescNazione(source.getDescNazione());
				target.setDescProvincia(source.getDescProvincia());
				target.setDescRegione(source.getDescRegione());
			}

			return target;
		}
	}

	public static class ProblemiSaluteConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute, ProblemiSalute> {
		@Override
		public ProblemiSalute convert(it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute source) {
			ProblemiSalute target = null;
			if (source != null) {
				target = new ProblemiSalute();

				target.setDocumenti(new DocumentoConverter().convertAll(source.getDocumenti()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class DocumentoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Documento, Documento> {
		@Override
		public Documento convert(it.csi.iscritto.serviscritto.dto.domanda.Documento source) {
			Documento target = null;
			if (source != null) {
				target = new Documento();

				target.setFile(new FileConverter().convert(source.getFile()));
				target.setEliminato(source.getEliminato());
				target.setId(source.getId());
			}

			return target;
		}
	}

	public static class FileConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.File, File> {
		@Override
		public File convert(it.csi.iscritto.serviscritto.dto.domanda.File source) {
			File target = null;
			if (source != null) {
				target = new File();

				target.setName(source.getName());
				target.setType(source.getType());
			}

			return target;
		}
	}

	public static class ResidenzaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Residenza, Residenza> {
		@Override
		public Residenza convert(it.csi.iscritto.serviscritto.dto.domanda.Residenza source) {
			Residenza target = null;
			if (source != null) {
				target = new Residenza();

				target.setCap(source.getCap());
				target.setCodComune(source.getCodComune());
				target.setCodNazione(source.getCodNazione());
				target.setCodProvincia(source.getCodProvincia());
				target.setCodRegione(source.getCodRegione());
				target.setDescComune(source.getDescComune());
				target.setDescNazione(source.getDescNazione());
				target.setDescProvincia(source.getDescProvincia());
				target.setDescRegione(source.getDescRegione());
				target.setIndirizzo(source.getIndirizzo());
			}

			return target;
		}
	}

	public static class SentenzaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Sentenza, Sentenza> {
		@Override
		public Sentenza convert(it.csi.iscritto.serviscritto.dto.domanda.Sentenza source) {
			Sentenza target = null;
			if (source != null) {
				target = new Sentenza();

				target.setData(source.getData());
				target.setNumero(source.getNumero());
				target.setTribunale(source.getTribunale());
			}

			return target;
		}
	}

	public static class AltriComponentiConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti, AltriComponenti> {
		@Override
		public AltriComponenti convert(it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti source) {
			AltriComponenti target = null;
			if (source != null) {
				target = new AltriComponenti();

				target.setSoggetti(new SoggettoAltroComponenteConverter().convertAll(source.getSoggetti()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class SoggettoAltroComponenteConverter
			extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.SoggettoAltroComponente, SoggettoAltroComponente> {
		@Override
		public SoggettoAltroComponente convert(it.csi.iscritto.serviscritto.dto.domanda.SoggettoAltroComponente source) {
			SoggettoAltroComponente target = null;
			if (source != null) {
				target = new SoggettoAltroComponente();

				target.setAnagrafica(new AnagraficaConverter().convert(source.getAnagrafica()));
				target.setId(source.getId());
				target.setLuogoNascita(new LuogoNascitaConverter().convert(source.getLuogoNascita()));
				target.setProblemiSalute(new ProblemiSaluteConverter().convert(source.getProblemiSalute()));
				target.setRelazioneConMinore(source.getRelazioneConMinore());
				target.setResidenza(new ResidenzaConverter().convert(source.getResidenza()));
			}

			return target;
		}
	}

	public static class ComponentiNucleoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo, ComponentiNucleo> {
		@Override
		public ComponentiNucleo convert(it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo source) {
			ComponentiNucleo target = null;
			if (source != null) {
				target = new ComponentiNucleo();

				target.setSoggetti(new SoggettoNucleoConverter().convertAll(source.getSoggetti()));
			}

			return target;
		}
	}

	public static class SoggettoNucleoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo, SoggettoNucleo> {
		@Override
		public SoggettoNucleo convert(it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo source) {
			SoggettoNucleo target = null;
			if (source != null) {
				target = new SoggettoNucleo();

				target.setAnagrafica(new AnagraficaConverter().convert(source.getAnagrafica()));
				target.setId(source.getId());
				target.setLuogoNascita(new LuogoNascitaConverter().convert(source.getLuogoNascita()));
				target.setProblemiSalute(new ProblemiSaluteConverter().convert(source.getProblemiSalute()));
				target.setRelazioneConMinore(source.getRelazioneConMinore());
			}

			return target;
		}
	}

	public static class IseeConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Isee, Isee> {
		@Override
		public Isee convert(it.csi.iscritto.serviscritto.dto.domanda.Isee source) {
			Isee target = null;
			if (source != null) {
				target = new Isee();

				target.setDati(new DatiIseeConverter().convert(source.getDati()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class DatiIseeConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DatiIsee, DatiIsee> {
		@Override
		public DatiIsee convert(it.csi.iscritto.serviscritto.dto.domanda.DatiIsee source) {
			DatiIsee target = null;
			if (source != null) {
				target = new DatiIsee();

				target.setDataAttestazione(source.getDataAttestazione());
				target.setValore(source.getValore());
			}

			return target;
		}
	}

	public static class MinoreConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Minore, Minore> {
		@Override
		public Minore convert(it.csi.iscritto.serviscritto.dto.domanda.Minore source) {
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
			}

			return target;
		}
	}

	public static class DisabilitaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Disabilita, Disabilita> {
		@Override
		public Disabilita convert(it.csi.iscritto.serviscritto.dto.domanda.Disabilita source) {
			Disabilita target = null;
			if (source != null) {
				target = new Disabilita();

				target.setDocumenti(new DocumentoConverter().convertAll(source.getDocumenti()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class FratelloFrequentanteConverter
			extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante, FratelloFrequentante> {
		@Override
		public FratelloFrequentante convert(it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante source) {
			FratelloFrequentante target = null;
			if (source != null) {
				target = new FratelloFrequentante();

				target.setAnagrafica(new AnagraficaConverter().convert(source.getAnagrafica()));
				target.setStato(source.getStato());
				target.setTipo(source.getTipo());
			}

			return target;
		}
	}

	public static class ServiziSocialiConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.ServiziSociali, ServiziSociali> {
		@Override
		public ServiziSociali convert(it.csi.iscritto.serviscritto.dto.domanda.ServiziSociali source) {
			ServiziSociali target = null;
			if (source != null) {
				target = new ServiziSociali();

				target.setDati(new DatiServiziSocialiConverter().convert(source.getDati()));
				target.setStato(source.getStato());
				target.setDocumenti(new DocumentoConverter().convertAll(source.getDocumenti()));
			}

			return target;
		}
	}

	public static class DatiServiziSocialiConverter
			extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DatiServiziSociali, DatiServiziSociali> {
		@Override
		public DatiServiziSociali convert(it.csi.iscritto.serviscritto.dto.domanda.DatiServiziSociali source) {
			DatiServiziSociali target = null;
			if (source != null) {
				target = new DatiServiziSociali();

				target.setAssistente(source.getAssistente());
				target.setIndirizzo(source.getIndirizzo());
				target.setNome(source.getNome());
				target.setTelefono(source.getTelefono());
			}

			return target;
		}
	}

	public static class SpostamentoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Spostamento, Spostamento> {
		@Override
		public Spostamento convert(it.csi.iscritto.serviscritto.dto.domanda.Spostamento source) {
			Spostamento target = null;
			if (source != null) {
				target = new Spostamento();

				target.setDati(new DatiSpostamentoConverter().convert(source.getDati()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class DatiSpostamentoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DatiSpostamento, DatiSpostamento> {
		@Override
		public DatiSpostamento convert(it.csi.iscritto.serviscritto.dto.domanda.DatiSpostamento source) {
			DatiSpostamento target = null;
			if (source != null) {
				target = new DatiSpostamento();

				target.setDataAppuntamento(source.getDataAppuntamento());
				target.setDataVariazione(source.getDataVariazione());
				target.setResidenzaFutura(source.getResidenzaFutura());
				target.setStato(source.getStato());
				target.setIndirizzo(source.getIndirizzo());
			}

			return target;
		}
	}

	public static class TrasferimentoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Trasferimento, Trasferimento> {
		@Override
		public Trasferimento convert(it.csi.iscritto.serviscritto.dto.domanda.Trasferimento source) {
			Trasferimento target = null;
			if (source != null) {
				target = new Trasferimento();

				target.setDati(new DatiTrasferimentoConverter().convert(source.getDati()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class DatiTrasferimentoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DatiTrasferimento, DatiTrasferimento> {
		@Override
		public DatiTrasferimento convert(it.csi.iscritto.serviscritto.dto.domanda.DatiTrasferimento source) {
			DatiTrasferimento target = null;
			if (source != null) {
				target = new DatiTrasferimento();

				target.setData(source.getData());
				target.setDataDal(source.getDataDal());
				target.setIndirizzo(source.getIndirizzoNido());
				target.setIndirizzoNuovo(source.getIndirizzoNuovo());
				target.setIndirizzoVecchio(source.getIndirizzoVecchio());
			}

			return target;
		}
	}

	public static class RichiedenteConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Richiedente, Richiedente> {
		@Override
		public Richiedente convert(it.csi.iscritto.serviscritto.dto.domanda.Richiedente source) {
			Richiedente target = null;
			if (source != null) {
				target = new Richiedente();

				target.setId(source.getId());
				target.setAnagrafica(new AnagraficaConverter().convert(source.getAnagrafica()));
				target.setCondizioneCoabitazione(source.getCondizioneCoabitazione());
				target.setEmail(source.getEmail());
				target.setLuogoNascita(new LuogoNascitaConverter().convert(source.getLuogoNascita()));
				target.setRecapitoNoResidenza(source.getRecapitoNoResidenza());
				target.setRelazioneConMinore(source.getRelazioneConMinore());
				target.setResidenza(new ResidenzaConverter().convert(source.getResidenza()));
				target.setResidenzaFutura(source.getResidenzaFutura());
				target.setTelefono(source.getTelefono());
			}

			return target;
		}
	}

	public static class Soggetto1Converter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Soggetto1, Soggetto1> {
		@Override
		public Soggetto1 convert(it.csi.iscritto.serviscritto.dto.domanda.Soggetto1 source) {
			Soggetto1 target = null;
			if (source != null) {
				target = new Soggetto1();

				target.setId(source.getId());
				target.setAnagrafica(new AnagraficaConverter().convert(source.getAnagrafica()));
				target.setCondizioneOccupazionale(new CondizioneOccupazionaleConverter().convert(source.getCondizioneOccupazionale()));
				target.setGenitoreSolo(new GenitoreSoloConverter().convert(source.getGenitoreSolo()));
				target.setGravidanza(new GravidanzaConverter().convert(source.getGravidanza()));
				target.setLuogoNascita(new LuogoNascitaConverter().convert(source.getLuogoNascita()));
				target.setProblemiSalute(new ProblemiSaluteConverter().convert(source.getProblemiSalute()));
				target.setResidenza(new ResidenzaConverter().convert(source.getResidenza()));
			}

			return target;
		}
	}

	public static class CondizioneOccupazionaleConverter
			extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale, CondizioneOccupazionale> {
		@Override
		public CondizioneOccupazionale convert(it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale source) {
			CondizioneOccupazionale target = null;
			if (source != null) {
				target = new CondizioneOccupazionale();

				target.setDati(new DatiCondizioneOccupazionaleConverter().convert(source.getDati()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class DatiCondizioneOccupazionaleConverter
			extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DatiCondizioneOccupazionale, DatiCondizioneOccupazionale> {
		@Override
		public DatiCondizioneOccupazionale convert(it.csi.iscritto.serviscritto.dto.domanda.DatiCondizioneOccupazionale source) {
			DatiCondizioneOccupazionale target = null;
			if (source != null) {
				target = new DatiCondizioneOccupazionale();

				target.setAutonomo(new AutonomoConverter().convert(source.getAutonomo()));
				target.setDipendente(new DipendenteConverter().convert(source.getDipendente()));
				target.setDisoccupato(new DisoccupatoConverter().convert(source.getDisoccupato()));
				target.setNonOccupato(new NonOccupatoConverter().convertAll(source.getNonOccupato()));
				target.setStudente(new StudenteConverter().convert(source.getStudente()));
			}

			return target;
		}
	}

	public static class AutonomoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Autonomo, Autonomo> {
		@Override
		public Autonomo convert(it.csi.iscritto.serviscritto.dto.domanda.Autonomo source) {
			Autonomo target = null;
			if (source != null) {
				target = new Autonomo();

				target.setComune(source.getComune());
				target.setIndirizzo(source.getIndirizzo());
				target.setPiva(source.getPiva());
				target.setProvincia(source.getProvincia());
			}

			return target;
		}
	}

	public static class DipendenteConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Dipendente, Dipendente> {
		@Override
		public Dipendente convert(it.csi.iscritto.serviscritto.dto.domanda.Dipendente source) {
			Dipendente target = null;
			if (source != null) {
				target = new Dipendente();

				target.setAzienda(source.getAzienda());
				target.setComune(source.getComune());
				target.setIndirizzo(source.getIndirizzo());
				target.setProvincia(source.getProvincia());
			}

			return target;
		}
	}

	public static class DisoccupatoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Disoccupato, Disoccupato> {
		@Override
		public Disoccupato convert(it.csi.iscritto.serviscritto.dto.domanda.Disoccupato source) {
			Disoccupato target = null;
			if (source != null) {
				target = new Disoccupato();

				target.setDataDichiarazione(source.getDataDichiarazione());
				target.setDatiCi(new DatiCiDisoccupatoConverter().convert(source.getDatiCi()));
				target.setSoggettoDichiarazione(source.getSoggettoDichiarazione());
			}

			return target;
		}
	}

	public static class DatiCiDisoccupatoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.DatiCiDisoccupato, DatiCiDisoccupato> {
		@Override
		public DatiCiDisoccupato convert(it.csi.iscritto.serviscritto.dto.domanda.DatiCiDisoccupato source) {
			DatiCiDisoccupato target = null;
			if (source != null) {
				target = new DatiCiDisoccupato();

				target.setComune(source.getComune());
				target.setProvincia(source.getProvincia());
			}

			return target;
		}
	}

	public static class NonOccupatoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.NonOccupato, NonOccupato> {
		@Override
		public NonOccupato convert(it.csi.iscritto.serviscritto.dto.domanda.NonOccupato source) {
			NonOccupato target = null;
			if (source != null) {
				target = new NonOccupato();

				target.setAzienda(source.getAzienda());
				target.setComune(source.getComune());
				target.setDataFine(source.getDataFine());
				target.setDataInizio(source.getDataInizio());
				target.setId(source.getId());
				target.setIndirizzo(source.getIndirizzo());
			}

			return target;
		}
	}

	public static class StudenteConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Studente, Studente> {
		@Override
		public Studente convert(it.csi.iscritto.serviscritto.dto.domanda.Studente source) {
			Studente target = null;
			if (source != null) {
				target = new Studente();

				target.setCorso(source.getCorso());
				target.setIstituto(source.getIstituto());
			}

			return target;
		}
	}

	public static class GenitoreSoloConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.GenitoreSolo, GenitoreSolo> {
		@Override
		public GenitoreSolo convert(it.csi.iscritto.serviscritto.dto.domanda.GenitoreSolo source) {
			GenitoreSolo target = null;
			if (source != null) {
				target = new GenitoreSolo();

				target.setSentenza(new SentenzaConverter().convert(source.getSentenza()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class GravidanzaConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Gravidanza, Gravidanza> {
		@Override
		public Gravidanza convert(it.csi.iscritto.serviscritto.dto.domanda.Gravidanza source) {
			Gravidanza target = null;
			if (source != null) {
				target = new Gravidanza();

				target.setDocumenti(new DocumentoConverter().convertAll(source.getDocumenti()));
				target.setStato(source.getStato());
			}

			return target;
		}
	}

	public static class Soggetto2Converter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Soggetto2, Soggetto2> {
		@Override
		public Soggetto2 convert(it.csi.iscritto.serviscritto.dto.domanda.Soggetto2 source) {
			Soggetto2 target = null;
			if (source != null) {
				target = new Soggetto2();

				target.setId(source.getId());
				target.setAnagrafica(new AnagraficaConverter().convert(source.getAnagrafica()));
				target.setCondizioneOccupazionale(new CondizioneOccupazionaleConverter().convert(source.getCondizioneOccupazionale()));
				target.setGravidanza(new GravidanzaConverter().convert(source.getGravidanza()));
				target.setLuogoNascita(new LuogoNascitaConverter().convert(source.getLuogoNascita()));
				target.setPresenzaNucleo(source.getPresenzaNucleo());
				target.setProblemiSalute(new ProblemiSaluteConverter().convert(source.getProblemiSalute()));
				target.setResidenza(new ResidenzaConverter().convert(source.getResidenza()));
			}

			return target;
		}
	}

	public static class Soggetto3Converter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Soggetto3, Soggetto3> {
		@Override
		public Soggetto3 convert(it.csi.iscritto.serviscritto.dto.domanda.Soggetto3 source) {
			Soggetto3 target = null;
			if (source != null) {
				target = new Soggetto3();

				it.csi.iscritto.serviscritto.dto.domanda.DatiSoggetto3 datiSoggetto3 = source.getDati();
				if (datiSoggetto3 != null) {
					target.setAnagrafica(new AnagraficaConverter().convert(datiSoggetto3.getAnagrafica()));
					target.setLuogoNascita(new LuogoNascitaConverter().convert(datiSoggetto3.getLuogoNascita()));
					target.setResidenza(new ResidenzaConverter().convert(datiSoggetto3.getResidenza()));
				}
			}

			return target;
		}
	}

}
