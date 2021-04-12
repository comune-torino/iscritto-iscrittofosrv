package it.csi.iscritto.iscrittofosrv.integration.service.domanda;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import it.csi.iscritto.iscrittofosrv.dto.allegato.Allegato;
import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiAccettazionePreferenza;
import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiFasciaEta;
import it.csi.iscritto.iscrittofosrv.dto.domanda.InfoDomanda;
import it.csi.iscritto.iscrittofosrv.dto.domanda.RicevutaAccettazione;
import it.csi.iscritto.iscrittofosrv.dto.domanda.TestataDomandaAccettazione;
import it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna;
import it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.converter.allegato.AllegatoConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.allegato.AllegatoSrvConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.CallerInfoDomandaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DatiFasciaEtaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaMaternaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaMaternaSrvConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaNidoConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.DomandaNidoSrvConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.InfoDomandaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.RicevutaAccettazioneConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.domanda.TestataDomandaAccettazioneConverter;
import it.csi.iscritto.iscrittofosrv.integration.dao.TipoScuola;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;
import it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda;
import it.csi.iscritto.serviscritto.dto.domanda.CriterioRicerca;
import it.csi.iscritto.serviscritto.dto.domanda.TestataDomanda;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;
import it.csi.iscritto.serviscritto.interfacecsi.domanda.DomandaSrv;

public class DomandaSrvBean {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");

	public static final String TIPO_TESTATA = "RIC_MIN";

	private DomandaSrv serviceInterface;

	public void setServiceInterface(DomandaSrv serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	public DomandaNido getDomandaNido(CallerInfo callerInfo, String cfRichiedente, Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "getDomandaNido";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		DomandaNido result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			this.serviceInterface.checkIdDomanda(callerInfoDomanda, cfRichiedente, idDomandaIscrizione);

			result = new DomandaNidoConverter().convert(
					this.serviceInterface.getDomandaNido(callerInfoDomanda, idDomandaIscrizione));
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public DomandaMaterna getDomandaMaterna(CallerInfo callerInfo, String cfRichiedente, Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "getDomandaMaterna";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		DomandaMaterna result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			this.serviceInterface.checkIdDomanda(callerInfoDomanda, cfRichiedente, idDomandaIscrizione);

			result = new DomandaMaternaConverter().convert(
					this.serviceInterface.getDomandaMaterna(callerInfoDomanda, idDomandaIscrizione));
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public DomandaNido insertDomandaNido(CallerInfo callerInfo, String cfRichiedente, DomandaNido domandaNido) throws ServiceException {
		final String methodName = "insertDomandaNido";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		DomandaNido result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);
			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido domandaNidoSrv = new DomandaNidoSrvConverter().convert(domandaNido);

			this.serviceInterface.checkRichiedenteDomandaNido(
					callerInfoDomanda, cfRichiedente, domandaNidoSrv);

			result = new DomandaNidoConverter().convert(
					this.serviceInterface.insertDomandaNido(callerInfoDomanda, domandaNidoSrv));
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			this.logErroreDomandaNido(callerInfo, e.getMessage(), domandaNido);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			this.logErroreDomandaNido(callerInfo, e.getMessage(), domandaNido);

			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public DomandaMaterna insertDomandaMaterna(CallerInfo callerInfo, String cfRichiedente, DomandaMaterna domandaMaterna) throws ServiceException {
		final String methodName = "insertDomandaMaterna";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		DomandaMaterna result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);
			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna domandaMaternaSrv = new DomandaMaternaSrvConverter().convert(domandaMaterna);

			this.serviceInterface.checkRichiedenteDomandaMaterna(
					callerInfoDomanda, cfRichiedente, domandaMaternaSrv);

			result = new DomandaMaternaConverter().convert(
					this.serviceInterface.insertDomandaMaterna(callerInfoDomanda, domandaMaternaSrv));
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			this.logErroreDomandaMaterna(callerInfo, e.getMessage(), domandaMaterna);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			this.logErroreDomandaMaterna(callerInfo, e.getMessage(), domandaMaterna);

			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public String invioDomandaNido(CallerInfo callerInfo, String cfRichiedente, Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "invioDomandaNido";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		String result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			this.serviceInterface.checkIdDomanda(callerInfoDomanda, cfRichiedente, idDomandaIscrizione);

			result = this.serviceInterface.invioDomandaNido(callerInfoDomanda, idDomandaIscrizione);
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			this.logErroreDomandaNido(callerInfo, cfRichiedente, e.getMessage(), idDomandaIscrizione);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			this.logErroreDomandaNido(callerInfo, cfRichiedente, e.getMessage(), idDomandaIscrizione);

			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public String invioDomandaMaterna(CallerInfo callerInfo, String cfRichiedente, Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "invioDomandaMaterna";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		String result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			this.serviceInterface.checkIdDomanda(callerInfoDomanda, cfRichiedente, idDomandaIscrizione);

			result = this.serviceInterface.invioDomandaMaterna(callerInfoDomanda, idDomandaIscrizione);
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			this.logErroreDomandaMaterna(callerInfo, cfRichiedente, e.getMessage(), idDomandaIscrizione);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			this.logErroreDomandaMaterna(callerInfo, cfRichiedente, e.getMessage(), idDomandaIscrizione);

			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public void deleteDomanda(CallerInfo callerInfo, String cfRichiedente, Long idDomandaIscrizione, String cfOperatore) throws ServiceException {
		final String methodName = "deleteDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			this.serviceInterface.checkIdDomanda(callerInfoDomanda, cfRichiedente, idDomandaIscrizione);

			this.serviceInterface.deleteDomanda(callerInfoDomanda, idDomandaIscrizione, cfOperatore);
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	public List<InfoDomanda> getElencoDomandeByCfRichiedente(CallerInfo callerInfo, TipoScuola tipoScuola, String codiceFiscale) throws ServiceException {
		final String methodName = "getElencoDomandeByCfRichiedente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola:" + tipoScuola));
		Validate.notNull(tipoScuola);

		List<InfoDomanda> result;
		try {
			result = new ArrayList<>();
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			String cfOperatore = null;
			String codProfilo = null;

			CriterioRicerca cr = new CriterioRicerca();
			cr.setCodiceFiscaleRichiedente(codiceFiscale);

			Long[] ids;
			switch (tipoScuola) {
				case NID:
					ids = this.serviceInterface.getElencoDomandeNidi(callerInfoDomanda, cfOperatore, codProfilo, cr);
					break;
				case MAT:
					ids = this.serviceInterface.getElencoDomandeMaterne(callerInfoDomanda, cfOperatore, codProfilo, cr);
					break;
				default:
					throw new UnsupportedOperationException();
			}

			if (ArrayUtils.isNotEmpty(ids)) {
				for (Long id : ids) {
					result.add(new InfoDomandaConverter().convert(
							this.serviceInterface.getTestataDomanda(callerInfoDomanda, id, TIPO_TESTATA)));
				}
			}
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<InfoDomanda> getDomandeByCfRichiedente(CallerInfo callerInfo, String codiceFiscale) throws ServiceException {
		final String methodName = "getDomandeByCfRichiedente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<InfoDomanda> result;
		try {
			result = new ArrayList<>();
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			String cfOperatore = null;
			String codProfilo = null;

			CriterioRicerca cr = new CriterioRicerca();
			cr.setCodiceFiscaleRichiedente(codiceFiscale);

			List<Long> ids = new ArrayList<>();
			ids.addAll(ConvertUtils.toList(this.serviceInterface.getElencoDomandeNidi(callerInfoDomanda, cfOperatore, codProfilo, cr)));
			ids.addAll(ConvertUtils.toList(this.serviceInterface.getElencoDomandeMaterne(callerInfoDomanda, cfOperatore, codProfilo, cr)));

			List<TestataDomanda> values = new ArrayList<>();
			for (Long id : ids) {
				values.add(this.serviceInterface.getTestataDomanda(callerInfoDomanda, id, TIPO_TESTATA));
			}

			if (CollectionUtils.isNotEmpty(values)) {
				values.sort(new Comparator<TestataDomanda>() {
					@Override
					public int compare(TestataDomanda a, TestataDomanda b) {
						Date dtA = a.getDataUltimaModifica();
						Date dtB = b.getDataUltimaModifica();

						if (dtA == null || dtB == null) {
							return 0;
						}

						return dtB.compareTo(dtA);
					}
				});

				result.addAll(new InfoDomandaConverter().convertAll(values));
			}
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Allegato findAllegato(CallerInfo callerInfo, String cfRichiedente, Long idDomanda, Long idAllegato) throws ServiceException {
		final String methodName = "findAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Allegato result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			result = new AllegatoConverter().convert(
					this.serviceInterface.getAllegato(callerInfoDomanda, cfRichiedente, idDomanda, idAllegato, true));
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Long> insertAllegati(
			CallerInfo callerInfo, String cfRichiedente, Long idDomanda, Long idSoggetto, String codTipoAllegato, MultipartFormDataInput input)
			throws ServiceException {

		final String methodName = "insertAllegati";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Long> result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);
			List<Allegato> allegati = AllegatoConverter.buildAllegato(idSoggetto, codTipoAllegato, input);

			it.csi.iscritto.serviscritto.dto.domanda.Allegato[] allegatiArray = ConvertUtils.toArray(
					new AllegatoSrvConverter().convertAll(allegati),
					it.csi.iscritto.serviscritto.dto.domanda.Allegato.class);

			String cfOperatore = null;

			result = ConvertUtils.toList(
					this.serviceInterface.insertAllegatoList(callerInfoDomanda, cfRichiedente, cfOperatore, idDomanda, allegatiArray));
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Long> insertAllegatiMultipart(CallerInfo callerInfo, String cfRichiedente, Long idDomanda, MultipartFormDataInput input)
			throws ServiceException {

		final String methodName = "insertAllegatiMultipart";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Long> result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);
			List<Allegato> allegati = AllegatoConverter.buildAllegato(input);

			it.csi.iscritto.serviscritto.dto.domanda.Allegato[] allegatiArray = ConvertUtils.toArray(
					new AllegatoSrvConverter().convertAll(allegati),
					it.csi.iscritto.serviscritto.dto.domanda.Allegato.class);

			String cfOperatore = null;

			result = ConvertUtils.toList(
					this.serviceInterface.insertAllegatoList(callerInfoDomanda, cfRichiedente, cfOperatore, idDomanda, allegatiArray));
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer deleteAllegato(CallerInfo callerInfo, String cfRichiedente, Long idDomanda, Long idAllegato) throws ServiceException {
		final String methodName = "deleteAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Integer result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			String cfOperatore = null;
			result = this.serviceInterface.deleteAllegato(callerInfoDomanda, cfRichiedente, cfOperatore, idDomanda, idAllegato);
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public void checkDomandaNido(CallerInfo callerInfo, String cfRichiedente, String cfMinore) throws ServiceException {
		final String methodName = "checkDomandaNido";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			this.serviceInterface.checkDomandaNido(callerInfoDomanda, cfRichiedente, cfMinore);
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	public void checkDomandaMaterna(CallerInfo callerInfo, String cfRichiedente, String cfMinore) throws ServiceException {
		final String methodName = "checkDomandaMaterna";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			this.serviceInterface.checkDomandaMaterna(callerInfoDomanda, cfRichiedente, cfMinore);
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	public TestataDomandaAccettazione getTestataDomandaAccettazione(CallerInfo callerInfo, Long idDomandaIscrizione, String cfRichiedente, TipoScuola tipoScuola)
			throws ServiceException {

		final String methodName = "getTestataDomandaAccettazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		TestataDomandaAccettazione result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			switch (tipoScuola) {
			case NID:
				result = new TestataDomandaAccettazioneConverter().convert(
						this.serviceInterface.getTestataDomandaAccettazione(callerInfoDomanda, idDomandaIscrizione, cfRichiedente));
				break;
			case MAT:
				log.info("@@ 2 dentro switch entro in convert materna");
				result = new TestataDomandaAccettazioneConverter().convertMaterna(
						this.serviceInterface.getTestataDomandaAccettazioneMaterne(callerInfoDomanda, idDomandaIscrizione, cfRichiedente));
				break;
			default:
				throw new UnsupportedOperationException();
			}

		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}





	public TestataDomandaAccettazione accettaPreferenza(CallerInfo callerInfo, TipoScuola tipoScuola, Long idDomandaIscrizione, String codiceScuola,
			String codiceTipoFrequenza, DatiAccettazionePreferenza datiAccettazionePreferenza) throws ServiceException {

		final String methodName = "accettaPreferenza";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola:" + tipoScuola));
		Validate.notNull(tipoScuola);

		TestataDomandaAccettazione result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			String cfRichiedente = datiAccettazionePreferenza.getCodiceFiscaleRichiedente();
			String cfOperatore = datiAccettazionePreferenza.getCodiceFiscaleOperatore();
			String telRichiedente = datiAccettazionePreferenza.getNumeroTelefonoRichiedente();
			String codTipoPasto = datiAccettazionePreferenza.getCodiceTipoPasto();

			log.debug("@@Ordine scuola: " + tipoScuola);
			switch (tipoScuola) {
				case NID:
					result = new TestataDomandaAccettazioneConverter().convert(
							this.serviceInterface.accettaPreferenzaNidi(
									callerInfoDomanda,
									idDomandaIscrizione,
									cfRichiedente,
									codiceScuola,
									codiceTipoFrequenza,
									cfOperatore,
									telRichiedente,
									codTipoPasto));
					break;
				case MAT:
					log.debug("@@ FOSRV sono in materna");
					result = new TestataDomandaAccettazioneConverter().convertMaterna(
							this.serviceInterface.accettaPreferenzaMaterne(
									callerInfoDomanda,
									idDomandaIscrizione,
									cfRichiedente,
									codiceScuola,
									codiceTipoFrequenza,
									cfOperatore,
									telRichiedente,
									codTipoPasto));
					break;
				default:
					log.debug("@@ eccezione FOSRV");
					throw new UnsupportedOperationException();
			}
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public TestataDomandaAccettazione rifiutaPreferenza(CallerInfo callerInfo, TipoScuola tipoScuola, Long idDomandaIscrizione, String codiceScuola,
			String codiceTipoFrequenza, DatiAccettazionePreferenza datiAccettazionePreferenza) throws ServiceException {

		final String methodName = "rifiutaPreferenza";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola:" + tipoScuola));
		Validate.notNull(tipoScuola);

		log.info("@@@ entro nello switch");

		TestataDomandaAccettazione result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			String cfRichiedente = datiAccettazionePreferenza.getCodiceFiscaleRichiedente();
			String cfOperatore = datiAccettazionePreferenza.getCodiceFiscaleOperatore();

			switch (tipoScuola) {
				case NID:
					result = new TestataDomandaAccettazioneConverter().convert(
							this.serviceInterface.rifiutaPreferenzaNidi(
									callerInfoDomanda,
									idDomandaIscrizione,
									cfRichiedente,
									codiceScuola,
									codiceTipoFrequenza,
									cfOperatore));
					break;
				case MAT:
					log.info("@@@ caso materna");

					result = new TestataDomandaAccettazioneConverter().convertMaterna(
							this.serviceInterface.rifiutaPreferenzaMaterne(
									callerInfoDomanda,
									idDomandaIscrizione,
									cfRichiedente,
									codiceScuola,
									codiceTipoFrequenza,
									cfOperatore));
					break;
				default:
					throw new UnsupportedOperationException();
			}
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public RicevutaAccettazione getRicevutaAccettazione(CallerInfo callerInfo, Long idDomanda, String cfRichiedente) throws ServiceException {
		final String methodName = "getRicevutaAccettazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		RicevutaAccettazione result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			result = new RicevutaAccettazioneConverter().convert(
					this.serviceInterface.generaRicevutaAccettazione(callerInfoDomanda, idDomanda, cfRichiedente));
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<DatiFasciaEta> getFasceEta(CallerInfo callerInfo) throws ServiceException {
		final String methodName = "getFasceEta";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<DatiFasciaEta> result;
		try {
			CallerInfoDomanda callerInfoDomanda = new CallerInfoDomandaConverter().convert(callerInfo);

			result = new DatiFasciaEtaConverter().convertAll(
					this.serviceInterface.getFasceEta(callerInfoDomanda));
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

			Errors errors = new Errors().addValidationError(e.getMessage());
			throw new ServiceException(errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private void logErroreDomandaNido(CallerInfo callerInfo, String cfRichiedente, String dettaglioErrore, Long idDomandaIscrizione) {
		final String methodName = "logErroreDomandaNido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			DomandaNido domandaNido = this.getDomandaNido(callerInfo, cfRichiedente, idDomandaIscrizione);
			log.info(buildMessage(getClass(), methodName, "completata lettura domanda: " + idDomandaIscrizione));

			this.logErroreDomandaNido(callerInfo, dettaglioErrore, domandaNido);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void logErroreDomandaMaterna(CallerInfo callerInfo, String cfRichiedente, String dettaglioErrore, Long idDomandaIscrizione) {
		final String methodName = "logErroreDomandaMaterna";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			DomandaMaterna domandaMaterna = this.getDomandaMaterna(callerInfo, cfRichiedente, idDomandaIscrizione);
			log.info(buildMessage(getClass(), methodName, "completata lettura domanda: " + idDomandaIscrizione));

			this.logErroreDomandaMaterna(callerInfo, dettaglioErrore, domandaMaterna);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void logErroreDomandaNido(CallerInfo callerInfo, String dettaglioErrore, DomandaNido domandaNido) {
		final String methodName = "logErroreDomandaNido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.serviceInterface.insertLogErroreDomandaNido(
					new CallerInfoDomandaConverter().convert(callerInfo),
					domandaNido.getCodiceFiscaleOperatore(),
					dettaglioErrore,
					new DomandaNidoSrvConverter().convert(domandaNido));

			log.info(buildMessage(getClass(), methodName, "completato salvataggio log errore"));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void logErroreDomandaMaterna(CallerInfo callerInfo, String dettaglioErrore, DomandaMaterna domandaMaterna) {
		final String methodName = "logErroreDomandaMaterna";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.serviceInterface.insertLogErroreDomandaMaterna(
					new CallerInfoDomandaConverter().convert(callerInfo),
					domandaMaterna.getCodiceFiscaleOperatore(),
					dettaglioErrore,
					new DomandaMaternaSrvConverter().convert(domandaMaterna));

			log.info(buildMessage(getClass(), methodName, "completato salvataggio log errore"));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

}
