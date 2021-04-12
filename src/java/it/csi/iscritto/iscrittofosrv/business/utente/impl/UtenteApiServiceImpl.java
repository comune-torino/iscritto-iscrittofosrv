package it.csi.iscritto.iscrittofosrv.business.utente.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildErrorResponse;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildSuccessStatus;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iride2.policy.entity.Identita;
import it.csi.iscritto.iscrittofosrv.business.utente.UtenteApi;
import it.csi.iscritto.iscrittofosrv.dto.notificatore.InfoUtente;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.service.notificatore.NotificatoreService;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public class UtenteApiServiceImpl extends SpringSupportedResource implements UtenteApi {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private NotificatoreService notificatoreService;

	@Override
	public Response getInfoUtente(SecurityContext sc, HttpServletRequest request, String identita) {
		final String methodName = "getInfoUtente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			Identita identitaIride = new Identita(identita);

			InfoUtente infoUtente = this.notificatoreService.getInfoUtente(identitaIride);
			Errors errors = this.notificatoreService.validateInfoUtente(infoUtente);
			if (errors.hasErrors()) {
				ServiceException e = new ServiceException(errors);
				log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

				return buildErrorResponse(e);
			}

			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), infoUtente)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

}
