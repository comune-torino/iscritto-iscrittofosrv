package it.csi.iscritto.iscrittofosrv.business.scuola.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildErrorResponse;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildSuccessStatus;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iscritto.iscrittofosrv.business.scuola.ScuoleApi;
import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.dto.scuola.InfoScuola;
import it.csi.iscritto.iscrittofosrv.integration.dao.TipoScuola;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.audit.LogAuditOperations;
import it.csi.iscritto.iscrittofosrv.util.builder.CallerInfoBuilder;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;

public class ScuoleApiServiceImpl extends SpringSupportedResource implements ScuoleApi {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private ScuoleService scuoleService;

	@Override
	public Response getElencoNidi(SecurityContext sc, HttpServletRequest request, String dataNascita) {
		final String methodName = "getElencoNidi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			String anno = this.scuoleService.getCodAnnoNidi(callerInfo, new Date());
			Date dataNascitaMinore = getDataNascitaMinore(dataNascita);
			//tappo cfOperatore
			String cfOperatore = null;

			List<InfoScuola> result = this.scuoleService.getElencoScuole(
					callerInfo, TipoScuola.NID, anno, dataNascitaMinore, cfOperatore);

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
	public Response getElencoMaterne(SecurityContext sc, HttpServletRequest request, String anno, String dataNascita, String cfOperatore) {
		final String methodName = "getElencoMaterne";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("codice operatore "+ cfOperatore);
		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			Date dataNascitaMinore = getDataNascitaMinore(dataNascita);

			List<InfoScuola> result = this.scuoleService.getElencoScuole(
					callerInfo, TipoScuola.MAT, anno, dataNascitaMinore, cfOperatore);

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
	public Response getElencoNidiByDescrizione(SecurityContext sc, HttpServletRequest request, String descrizione, String dataNascita) {
		final String methodName = "getElencoNidiByDescrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			String anno = this.scuoleService.getCodAnnoNidi(callerInfo, new Date());
			Date dataNascitaMinore = getDataNascitaMinore(dataNascita);

			List<InfoScuola> result = this.scuoleService.getElencoScuoleByDescrizione(
					callerInfo, TipoScuola.NID, anno, descrizione, dataNascitaMinore);

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
	public Response getElencoMaterneByDescrizione(SecurityContext sc, HttpServletRequest request, String anno, String descrizione, String dataNascita) {
		final String methodName = "getElencoMaterneByDescrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			Date dataNascitaMinore = getDataNascitaMinore(dataNascita);

			List<InfoScuola> result = this.scuoleService.getElencoScuoleByDescrizione(
					callerInfo, TipoScuola.MAT, anno, descrizione, dataNascitaMinore);

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
	public Response getElencoNidiByIndirizzo(SecurityContext sc, HttpServletRequest request, String indirizzo, String dataNascita) {
		final String methodName = "getElencoNidiByIndirizzo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			String anno = this.scuoleService.getCodAnnoNidi(callerInfo, new Date());
			Date dataNascitaMinore = getDataNascitaMinore(dataNascita);

			List<InfoScuola> result = this.scuoleService.getElencoScuoleByIndirizzo(
					callerInfo, TipoScuola.NID, anno, indirizzo, dataNascitaMinore);

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
	public Response getElencoMaterneByIndirizzo(SecurityContext sc, HttpServletRequest request, String anno, String indirizzo, String dataNascita) {
		final String methodName = "getElencoMaterneByIndirizzo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			Date dataNascitaMinore = getDataNascitaMinore(dataNascita);

			List<InfoScuola> result = this.scuoleService.getElencoScuoleByIndirizzo(
					callerInfo, TipoScuola.MAT, anno, indirizzo, dataNascitaMinore);

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
	public Response getElencoNidiByCircoscrizione(SecurityContext sc, HttpServletRequest request, Integer circoscrizione, String dataNascita) {
		final String methodName = "getElencoNidiByCircoscrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			String anno = this.scuoleService.getCodAnnoNidi(callerInfo, new Date());
			Date dataNascitaMinore = getDataNascitaMinore(dataNascita);

			List<InfoScuola> result = this.scuoleService.getElencoScuoleByCircoscrizione(
					callerInfo, TipoScuola.NID, anno, circoscrizione, dataNascitaMinore);

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
	public Response getElencoMaterneByCircoscrizione(SecurityContext sc, HttpServletRequest request, String anno, Integer circoscrizione, String dataNascita) {
		final String methodName = "getElencoMaterneByCircoscrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			Date dataNascitaMinore = getDataNascitaMinore(dataNascita);

			List<InfoScuola> result = this.scuoleService.getElencoScuoleByCircoscrizione(
					callerInfo, TipoScuola.MAT, anno, circoscrizione, dataNascitaMinore);

			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), result)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	private static Date getDataNascitaMinore(String dataNascita) throws ParseException {
		return StringUtils.isNotBlank(dataNascita)
				? DateUtils.toDate(dataNascita, DateUtils.ISO_8601_FORMAT)
				: null;
	}

}
