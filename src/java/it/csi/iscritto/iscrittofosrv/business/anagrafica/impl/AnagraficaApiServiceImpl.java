package it.csi.iscritto.iscrittofosrv.business.anagrafica.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildErrorResponse;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildSuccessStatus;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iscritto.iscrittofosrv.business.anagrafica.AnagraficaApi;
import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.nao.InfoNao;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.VisuraFamigliaServiceNao;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.ValidationService;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.audit.LogAuditOperations;
import it.csi.iscritto.iscrittofosrv.util.builder.CallerInfoBuilder;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public class AnagraficaApiServiceImpl extends SpringSupportedResource implements AnagraficaApi {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private ValidationService validationService;

	@Autowired
	private VisuraFamigliaServiceNao visuraFamigliaServiceNao;

	@Override
	public Response getDettaglioFamiglia(String cf, SecurityContext sc, HttpServletRequest request) {
		final String methodName = "getDettaglioFamiglia";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			Errors errors = this.validationService.validateCodiceFiscale(cf);
			if (errors.hasErrors()) {
				final String message = "codice fiscale non corretto";

				log.error(buildMessage(getClass(), methodName, message));
				return buildErrorResponse(Status.INTERNAL_SERVER_ERROR, errors);
			}

			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			InfoNao result = this.visuraFamigliaServiceNao.dettaglioFamigliaPerCodiceFiscale(callerInfo, cf);
			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), result)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

}
