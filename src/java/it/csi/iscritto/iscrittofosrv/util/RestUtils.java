package it.csi.iscritto.iscrittofosrv.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import it.csi.iscritto.iscrittofosrv.dto.rest.AppStatus;
import it.csi.iscritto.iscrittofosrv.dto.rest.ErrorDetail;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.exception.ApplicationException;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.ErrorCodeEnum;
import it.csi.iscritto.iscrittofosrv.util.builder.AppStatusBuilder;
import it.csi.iscritto.iscrittofosrv.util.validation.Error;
import it.csi.iscritto.iscrittofosrv.util.validation.ErrorType;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public final class RestUtils {
	private RestUtils() {
		/* NOP */
	}

	public static AppStatus buildSuccessStatus() {
		return AppStatusBuilder.newInstance()
				.whithStatus(String.valueOf(Status.OK.getStatusCode()))
				.build();
	}

	public static Response buildErrorResponse(Status status, Errors errors) {
		Validate.notNull(status);
		Validate.notNull(errors);

		return buildErrorResponse(status, errors.getAllErrors());
	}

	public static Response buildErrorResponse(Status status, Error... error) {
		Validate.notNull(status);
		Validate.notEmpty(error);

		return buildErrorResponse(status, Arrays.asList(error));
	}

	public static Response buildErrorResponse(Exception e) {
		Validate.notNull(e);

		if (e instanceof ApplicationException) {
			Errors errors = ((ApplicationException) e).getErrors();
			if (errors == null || !errors.hasErrors()) {
				return buildErrorResponse(Status.INTERNAL_SERVER_ERROR, ErrorCodeEnum.SYS_001.buildBlockingError(e.getMessage()));
			}

			return buildErrorResponse(getStatus(errors), errors.getAllErrors());
		}

		return buildErrorResponse(Status.INTERNAL_SERVER_ERROR, ErrorCodeEnum.SYS_001.buildBlockingError(e.getMessage()));
	}

	public static Response buildErrorResponse(Status status, List<Error> errorList) {
		Validate.notNull(status);
		Validate.notEmpty(errorList);

		AppStatusBuilder builder = AppStatusBuilder.newInstance()
				.whithStatus(String.valueOf(status.getStatusCode()));

		addErrors(builder, errorList);

		AppStatus result = builder.build();

		// restituisco sempre 200
		return Response.status(Status.OK)
				.entity(new ResponseBody<>(result, null))
				.build();
	}

	//////////////////////////////////////////////////////////////////////
	// Utility
	//////////////////////////////////////////////////////////////////////
	private static void addErrors(AppStatusBuilder builder, List<Error> errorList) {
		for (Error error : errorList) {
			ErrorDetail errorDetail = new ErrorDetail();
			errorDetail.setCode(error.getCode());
			errorDetail.setTitle(error.getDescription());

			if (StringUtils.isNotEmpty(error.getMessage())) {
				Map<String, String> detail = new HashMap<>();
				detail.put("path", error.getMessage());
				errorDetail.setDetail(detail);
			}

			builder.addError(errorDetail);
		}
	}

	private static Status getStatus(Errors errors) {
		if (errors == null || errors.hasErrors(ErrorType.SYSTEM)) {
			return Status.INTERNAL_SERVER_ERROR;
		}

		if (errors.hasErrors(ErrorType.VALIDATION)) {
			return Status.BAD_REQUEST;
		}

		return Status.INTERNAL_SERVER_ERROR;
	}

}
