package it.csi.iscritto.iscrittofosrv.business.validazione.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildErrorResponse;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildSuccessStatus;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iscritto.iscrittofosrv.business.validazione.ValidazioneApi;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.dto.validazione.GiorniLavoratiFilter;
import it.csi.iscritto.iscrittofosrv.dto.validazione.InfoPeriodo;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public class ValidazioneApiServiceImpl extends SpringSupportedResource implements ValidazioneApi {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private ValidazioneService validazioneService;

	@Override
	public Response getGiorniLavorati(SecurityContext sc, HttpServletRequest request, GiorniLavoratiFilter filter) {
		final String methodName = "getGiorniLavorati";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			String dataPresentazione = DateUtils.toStringDate(new Date(), DateUtils.DEFAULT_DATE_FORMAT);
			List<InfoPeriodo> periodi = filter.getPeriodi();

			Integer result = this.validazioneService.findGiorniLavorati(dataPresentazione, periodi);

			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), result)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	@Override
	public Response validaCodiceFiscale(SecurityContext sc, HttpServletRequest request, String cf) {
		final String methodName = "validaCodiceFiscale";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			Errors errors = this.validazioneService.validaCodiceFiscale(cf);
			if (errors.hasErrors()) {
				ServiceException e = new ServiceException(errors);
				log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

				return buildErrorResponse(e);
			}

			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), null)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

}
