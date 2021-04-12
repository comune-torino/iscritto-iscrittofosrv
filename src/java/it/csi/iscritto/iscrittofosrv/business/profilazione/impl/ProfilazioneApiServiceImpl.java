package it.csi.iscritto.iscrittofosrv.business.profilazione.impl;

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

import it.csi.iscritto.iscrittofosrv.business.profilazione.ProfilazioneApi;
import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.profilazione.Profilazione;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.integration.service.profilazione.ProfilazioneSrvBean;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.ErrorCodeEnum;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.audit.LogAuditOperations;
import it.csi.iscritto.iscrittofosrv.util.builder.CallerInfoBuilder;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;
import it.csi.iscritto.iscrittofosrv.util.validation.Error;

public class ProfilazioneApiServiceImpl extends SpringSupportedResource implements ProfilazioneApi {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private ProfilazioneSrvBean profilazioneSrvBean;

	@Override
	public Response checkPrivilegioInserimento(SecurityContext sc, HttpServletRequest request, String cfOperatore) {
		final String methodName = "checkPrivilegioInserimento";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();
			
			log.info("@@ sono in checkPrivilegioInserimento");
			
			boolean isAbilitato = this.profilazioneSrvBean.isAbilitatoInserimento(callerInfo, cfOperatore);
			boolean isAbilitatoNidi = this.profilazioneSrvBean.isAbilitatoInserimentoNidi(callerInfo, cfOperatore);
			boolean isAbilitatoMaterne = this.profilazioneSrvBean.isAbilitatoInserimentoMaterne(callerInfo, cfOperatore);

			Profilazione prof = new Profilazione();
			prof.setResult(isAbilitato);
			prof.setNidi(isAbilitatoNidi);
			prof.setMaterne(isAbilitatoMaterne);



			if (isAbilitato) {
				response = Response.ok(new ResponseBody<>(buildSuccessStatus(), prof)).build();
			}
			else {
				Error error = ErrorCodeEnum.VAL_PRF_001.buildBlockingError();

				log.error(buildMessage(getClass(), methodName, error.getDescription()));
				response = buildErrorResponse(Status.NOT_FOUND, error);
			}
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	@Override
	public Response checkOperatore(SecurityContext sc, HttpServletRequest request, String cfOperatore) {
		final String methodName = "checkOperatore";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("@@ FO3 Check operatore, cod f:"+ cfOperatore);
		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			boolean isValid = this.profilazioneSrvBean.operatorePresente(callerInfo, cfOperatore);
			if (isValid) {
				response = Response.ok(new ResponseBody<>(buildSuccessStatus(), true)).build();
			}
			else {
				Error error = ErrorCodeEnum.VAL_PRF_002.buildBlockingError();

				log.error(buildMessage(getClass(), methodName, error.getDescription()));
				response = buildErrorResponse(Status.NOT_FOUND, error);
			}
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

}
