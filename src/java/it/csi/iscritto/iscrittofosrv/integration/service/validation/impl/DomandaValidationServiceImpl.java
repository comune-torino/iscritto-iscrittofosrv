package it.csi.iscritto.iscrittofosrv.integration.service.validation.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna;
import it.csi.iscritto.iscrittofosrv.dto.nido.Anagrafica;
import it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido;
import it.csi.iscritto.iscrittofosrv.dto.nido.LuogoNascita;
import it.csi.iscritto.iscrittofosrv.dto.nido.Soggetto3;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.DomandaValidationService;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.ErrorCodeEnum;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DomandaUtils;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

@Repository
@Primary
public class DomandaValidationServiceImpl implements DomandaValidationService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");
	private static final String COD_NAZIONE_ITALIA = "000";

	@Override
	public Errors validateSoggetto3(DomandaNido domandaNido) throws ServiceException {
		final String methodName = "validateSoggetto3";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Errors errors = new Errors();
		boolean hasSoggetto3 = DomandaUtils.hasSoggetto3(
				DomandaUtils.getRichiedente(domandaNido),
				DomandaUtils.getSoggetto1(domandaNido));

		if (hasSoggetto3) {
			Soggetto3 soggetto3 = DomandaUtils.getSoggetto3(domandaNido);
			checkSoggetto3(soggetto3, errors);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return errors;
	}

	@Override
	public Errors validateSoggetto3(DomandaMaterna domandaMaterna) throws ServiceException {
		final String methodName = "validateSoggetto3";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Errors errors = new Errors();
		boolean hasSoggetto3 = DomandaUtils.hasSoggetto3(
				DomandaUtils.getRichiedente(domandaMaterna),
				DomandaUtils.getSoggetto1(domandaMaterna));

		if (hasSoggetto3) {
			Soggetto3 soggetto3 = DomandaUtils.getSoggetto3(domandaMaterna);
			checkSoggetto3(soggetto3, errors);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return errors;
	}

	//////////////////////////////////////////////////////////////////////

	private static void checkSoggetto3(Soggetto3 soggetto3, Errors errors) {
		if (soggetto3 == null) {
			errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3"));
			return;
		}

		Anagrafica anagrafica = soggetto3.getAnagrafica();
		if (anagrafica == null) {
			errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3.anagrafica"));
			return;
		}

		if (StringUtils.isBlank(anagrafica.getNome())) {
			errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3.anagrafica.nome"));
			return;
		}

		if (StringUtils.isBlank(anagrafica.getCognome())) {
			errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3.anagrafica.cognome"));
			return;
		}

		if (StringUtils.isBlank(anagrafica.getDataNascita())) {
			errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3.anagrafica.dataNascita"));
			return;
		}

		if (StringUtils.isBlank(anagrafica.getCodiceCittadinanza())) {
			errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3.anagrafica.codiceCittadinanza"));
			return;
		}

		LuogoNascita luogoNascita = soggetto3.getLuogoNascita();
		if (luogoNascita == null) {
			errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3.luogoNascita"));
			return;
		}

		if (StringUtils.isBlank(luogoNascita.getCodNazione())) {
			errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3.luogoNascita.codNazione"));
			return;
		}

		if (COD_NAZIONE_ITALIA.equals(luogoNascita.getCodNazione())) {
			if (StringUtils.isBlank(luogoNascita.getCodRegione())) {
				errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3.luogoNascita.codRegione"));
				return;
			}

			if (StringUtils.isBlank(luogoNascita.getCodComune())) {
				errors.addError(ErrorCodeEnum.VAL_SOG3_001.buildBlockingError("soggetto3.luogoNascita.codComune"));
				return;
			}
		}
	}

}
