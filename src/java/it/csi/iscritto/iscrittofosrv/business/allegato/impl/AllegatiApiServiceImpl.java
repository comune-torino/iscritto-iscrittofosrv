package it.csi.iscritto.iscrittofosrv.business.allegato.impl;

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

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iscritto.iscrittofosrv.business.allegato.AllegatiApi;
import it.csi.iscritto.iscrittofosrv.dto.allegato.Allegato;
import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.integration.service.domanda.DomandaSrvBean;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.audit.LogAuditOperations;
import it.csi.iscritto.iscrittofosrv.util.builder.CallerInfoBuilder;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;

public class AllegatiApiServiceImpl extends SpringSupportedResource implements AllegatiApi {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private DomandaSrvBean domandaSrvBean;

	@Override
	public Response uploadAllegato(SecurityContext sc, HttpServletRequest request,
			Long idDomanda, Long idSoggetto, String codTipologia, String cfRichiedente, MultipartFormDataInput input) {

		final String methodName = "uploadAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			Validate.notNull(idDomanda);
			Validate.notNull(idSoggetto);
			Validate.notBlank(codTipologia);
			Validate.notBlank(cfRichiedente);
			Validate.notNull(input);
			Validate.isTrue(CollectionUtils.isNotEmpty(input.getParts()));

			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.INSERT)
					.oggOper(methodName)
					.build();

			List<Long> result = this.domandaSrvBean.insertAllegati(
					callerInfo, cfRichiedente, idDomanda, idSoggetto, codTipologia, input);

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
	public Response uploadMultipart(SecurityContext sc, HttpServletRequest request, Long idDomanda, String cfRichiedente, MultipartFormDataInput input) {
		final String methodName = "uploadMultipart";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			Validate.notNull(idDomanda);
			Validate.notBlank(cfRichiedente);
			Validate.notNull(input);
			Validate.isTrue(CollectionUtils.isNotEmpty(input.getParts()));

			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.INSERT)
					.oggOper(methodName)
					.build();

			List<Long> result = this.domandaSrvBean.insertAllegatiMultipart(
					callerInfo, cfRichiedente, idDomanda, input);

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
	public Response downloadAllegato(SecurityContext sc, HttpServletRequest request, Long idDomanda, Long idAllegato, String cfRichiedente) {
		final String methodName = "downloadAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			Validate.notNull(idDomanda);
			Validate.notNull(idAllegato);
			Validate.notBlank(cfRichiedente);

			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			Allegato result = this.domandaSrvBean.findAllegato(
					callerInfo, cfRichiedente, idDomanda, idAllegato);

			if (result == null || result.getDocumento() == null) {
				log.error(buildMessage(getClass(), methodName, "file non trovato"));
				return Response.status(Status.NOT_FOUND).build();
			}

			response = Response.ok()
					.entity(result.getDocumento())
					.type(result.getMimeType())
					.header("Content-Length", result.getDocumento().length)
					.header("content-disposition", String.format("attachment; filename=\"%s\"", result.getNomeFile()))
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
	public Response deleteAllegato(SecurityContext sc, HttpServletRequest request, Long idDomanda, Long idAllegato, String cfRichiedente) {
		final String methodName = "deleteAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			Validate.notNull(idDomanda);
			Validate.notNull(idAllegato);
			Validate.notBlank(cfRichiedente);

			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.DELETE)
					.oggOper(methodName)
					.build();

			Integer result = this.domandaSrvBean.deleteAllegato(callerInfo, cfRichiedente, idDomanda, idAllegato);

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
