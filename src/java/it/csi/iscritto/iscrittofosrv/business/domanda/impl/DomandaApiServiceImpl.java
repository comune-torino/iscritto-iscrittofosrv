package it.csi.iscritto.iscrittofosrv.business.domanda.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildErrorResponse;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildSuccessStatus;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iscritto.iscrittofosrv.business.domanda.DomandaApi;
import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.domanda.InfoDomanda;
import it.csi.iscritto.iscrittofosrv.dto.domanda.RicevutaAccettazione;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.integration.service.domanda.DomandaSrvBean;
import it.csi.iscritto.iscrittofosrv.integration.service.ricevuta.accettazione.RicevutaAccettazioneService;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.audit.LogAuditOperations;
import it.csi.iscritto.iscrittofosrv.util.builder.CallerInfoBuilder;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;

public class DomandaApiServiceImpl extends SpringSupportedResource implements DomandaApi {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private DomandaSrvBean domandaSrvBean;

	@Override
	public Response getElencoDomandeByCfRichiedente(SecurityContext sc, HttpServletRequest request, String codiceFiscale) {
		final String methodName = "getElencoDomandeByCfRichiedente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			List<InfoDomanda> result = this.domandaSrvBean.getDomandeByCfRichiedente(callerInfo, codiceFiscale);

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
	public Response downloadRicevutaAccettazione(SecurityContext sc, HttpServletRequest request, Long idDomanda, String cfRichiedente) {
		final String methodName = "downloadRicevutaAccettazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			Validate.notNull(idDomanda);
			Validate.notBlank(cfRichiedente);

			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			RicevutaAccettazione ricevutaAccettazione = this.domandaSrvBean.getRicevutaAccettazione(
					callerInfo, idDomanda, cfRichiedente);

			if (ricevutaAccettazione == null) {
				log.error(buildMessage(getClass(), methodName, "dati non presenti"));
				return Response.status(Status.NOT_FOUND).build();
			}

			byte[] result = RicevutaAccettazioneService.createDocument(ricevutaAccettazione);

			if (result == null) {
				log.error(buildMessage(getClass(), methodName, "file non trovato"));
				return Response.status(Status.NOT_FOUND).build();
			}

			final String fileName = "ricevuta_accettazione.pdf";

			response = Response.ok()
					.entity(result)
					.type("application/pdf")
					.header("Content-Length", result.length)
					.header("content-disposition", String.format("attachment; filename=\"%s\"", fileName))
					.build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	@Override
	public Response deleteDomanda(SecurityContext sc, HttpServletRequest request, Long idDomandaIscrizione, String cfRichiedente, String cfOperatore) {
		final String methodName = "deleteDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.DELETE)
					.oggOper(methodName)
					.build();

			this.domandaSrvBean.deleteDomanda(callerInfo, cfRichiedente, idDomandaIscrizione, cfOperatore);
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
