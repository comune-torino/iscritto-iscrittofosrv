package it.csi.iscritto.iscrittofosrv.integration.service.validation.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.CalcoloGiorniService;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.CalcoloGiorniStrategy;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.model.PeriodoLavorativo;
import it.csi.iscritto.iscrittofosrv.util.Constants;

@Repository
@Primary
public class CalcoloGiorniServiceImpl implements CalcoloGiorniService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");

	@Override
	public Integer calcoloGiorniLavorati(Date dataPresentazione, List<PeriodoLavorativo> periodi) throws ServiceException {
		final String methodName = "calcoloGiorniLavorati";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(dataPresentazione, "parametro dataPresentazione nullo");

		CalcoloGiorniStrategy strategy = new CalcoloGiorniDefaultStrategy();

		if (!strategy.checkPeriodi(periodi)) {
			final String message = "elenco periodi non valido";
			log.error(buildMessage(getClass(), methodName, message));

			throw new ServiceException(message);
		}

		Integer result;
		try {
			result = strategy.getGiorniLavorati(dataPresentazione, periodi);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
