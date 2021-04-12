package it.csi.iscritto.iscrittofosrv.business.luoghi.impl;

import static it.csi.iscritto.iscrittofosrv.util.DateUtils.ISO_8601_FORMAT;
import static it.csi.iscritto.iscrittofosrv.util.DateUtils.ISO_8601_REGEX;
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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iscritto.iscrittofosrv.business.luoghi.ProvinceApi;
import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.luoghi.Provincia;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.ErrorCodeEnum;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.audit.LogAuditOperations;
import it.csi.iscritto.iscrittofosrv.util.builder.CallerInfoBuilder;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;;

public class ProvinceApiServiceImpl extends SpringSupportedResource implements ProvinceApi {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private LuoghiService luoghiService;

	@Override
	public Response getElencoProvinceAttive(SecurityContext sc, HttpServletRequest request) {
		final String methodName = "getElencoProvinceAttive";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response = this.getElencoProvinceAttiveByIstatRegione(sc, request, null);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	@Override
	public Response getElencoProvinceAttiveByIstatRegione(SecurityContext sc, HttpServletRequest request, String istatRegione) {
		final String methodName = "getElencoProvinceAttiveByIstatRegione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			List<Provincia> result = this.luoghiService.getElencoProvinceAttive(callerInfo, istatRegione);
			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), result)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public Response getElencoProvinceAttiveAllaData(SecurityContext sc, HttpServletRequest request, String data) {
		final String methodName = "getElencoProvinceAttiveAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response = this.getElencoProvinceAttiveAllaDataByIstatRegione(sc, request, data, null);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	@Override
	public Response getElencoProvinceAttiveAllaDataByIstatRegione(SecurityContext sc, HttpServletRequest request, String data, String istatRegione) {
		final String methodName = "getElencoProvinceAttiveAllaDataByIstatRegione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (!DateUtils.checkFormat(data, ISO_8601_REGEX)) {
			final String message = "formato data non valido";

			log.error(buildMessage(getClass(), methodName, message));
			return buildErrorResponse(Status.INTERNAL_SERVER_ERROR, ErrorCodeEnum.FRM_002.buildBlockingError());
		}

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			List<Provincia> result = this.luoghiService.getElencoProvinceAttiveAllaData(
					callerInfo, DateUtils.toDate(data, ISO_8601_FORMAT), istatRegione);

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
