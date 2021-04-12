package it.csi.iscritto.iscrittofosrv.integration.service.validation.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.ValidationService;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

@Repository
@Primary
public class ValidationServiceImpl implements ValidationService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");

	@Override
	public Errors validateCodiceFiscale(String codiceFiscale) throws ServiceException {
		final String methodName = "validateCodiceFiscale";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Errors errors = new Errors();
		try {
			new CodiceFiscaleValidator().validate(codiceFiscale, errors);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return errors;
	}

}
