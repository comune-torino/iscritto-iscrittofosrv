package it.csi.iscritto.iscrittofosrv.business.validazione.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.iscritto.iscrittofosrv.dto.validazione.InfoPeriodo;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.converter.validazione.PeriodoLavorativoConverter;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.CalcoloGiorniService;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.ValidationService;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

@Component
public class ValidazioneService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private CalcoloGiorniService calcoloGiorniService;

	@Autowired
	private ValidationService validationService;

	public Integer findGiorniLavorati(String dataPresentazione, List<InfoPeriodo> periodi) throws ServiceException {
		final String methodName = "findGiorniLavorati";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(dataPresentazione, "parametro dataPresentazione nullo");

		Integer result;
		try {
			result = this.calcoloGiorniService.calcoloGiorniLavorati(
					DateUtils.toDate(dataPresentazione, DateUtils.DEFAULT_DATE_FORMAT),
					new PeriodoLavorativoConverter().convertAll(periodi));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Errors validaCodiceFiscale(String cf) throws ServiceException {
		final String methodName = "validaCodiceFiscale";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Errors result;
		try {
			result = this.validationService.validateCodiceFiscale(cf);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
