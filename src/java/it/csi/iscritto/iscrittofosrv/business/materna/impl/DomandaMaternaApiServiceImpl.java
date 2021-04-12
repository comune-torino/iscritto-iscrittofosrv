package it.csi.iscritto.iscrittofosrv.business.materna.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildErrorResponse;
import static it.csi.iscritto.iscrittofosrv.util.RestUtils.buildSuccessStatus;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iscritto.iscrittofosrv.business.materna.DomandaMaternaApi;
import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiAccettazionePreferenza;
import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiRicevuta;
import it.csi.iscritto.iscrittofosrv.dto.domanda.InfoDomanda;
import it.csi.iscritto.iscrittofosrv.dto.domanda.TestataDomandaAccettazione;
import it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna;
import it.csi.iscritto.iscrittofosrv.dto.nao.InfoNao;
import it.csi.iscritto.iscrittofosrv.dto.rest.ResponseBody;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.dao.TipoScuola;
import it.csi.iscritto.iscrittofosrv.integration.service.domanda.DomandaSrvBean;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.VisuraFamigliaServiceNao;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.DomandaValidationService;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.NaoValidationService;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.audit.LogAuditOperations;
import it.csi.iscritto.iscrittofosrv.util.builder.CallerInfoBuilder;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public class DomandaMaternaApiServiceImpl extends SpringSupportedResource implements DomandaMaternaApi {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private DomandaSrvBean domandaSrvBean;

	@Autowired
	private VisuraFamigliaServiceNao visuraFamigliaServiceNao;

	@Autowired
	private DomandaValidationService domandaValidationService;

	@Autowired
	private NaoValidationService naoValidationService;

	@Override
	public Response saveBozza(SecurityContext sc, HttpServletRequest request, String cfRichiedente, DomandaMaterna domandaMaterna) {
		final String methodName = "saveBozza";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			Errors errors = this.domandaValidationService.validateSoggetto3(domandaMaterna);
			if (errors.hasErrors()) {
				ServiceException e = new ServiceException(errors);
				log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

				return buildErrorResponse(e);
			}

			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.INSERT)
					.oggOper(methodName)
					.keyOper(buildKeyOper(cfRichiedente, domandaMaterna))
					.build();

			DomandaMaterna domandaMaternaNew = this.domandaSrvBean.insertDomandaMaterna(callerInfo, cfRichiedente, domandaMaterna);
			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), domandaMaternaNew)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	@Override
	public Response invioDomanda(SecurityContext sc, HttpServletRequest request, Long idDomandaIscrizione, String cfRichiedente) {
		final String methodName = "invioDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo1 = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			DomandaMaterna domandaMaterna = this.domandaSrvBean.getDomandaMaterna(callerInfo1, cfRichiedente, idDomandaIscrizione);
			if (Boolean.TRUE.equals(domandaMaterna.getNao())) {
				InfoNao infoNao = this.visuraFamigliaServiceNao.dettaglioFamigliaPerCodiceFiscale(
						callerInfo1, domandaMaterna.getRichiedente().getAnagrafica().getCodiceFiscale());

				// TODO: da completare
				Errors errors = this.naoValidationService.validateSoggettiNao(infoNao, domandaMaterna);
				if (errors.hasErrors()) {
					ServiceException e = new ServiceException(errors);
					log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);

					return buildErrorResponse(e);
				}
			}

			CallerInfo callerInfo2 = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.INSERT)
					.oggOper(methodName)
					.keyOper(buildKeyOper(cfRichiedente, domandaMaterna))
					.build();

			String protocollo = this.domandaSrvBean.invioDomandaMaterna(callerInfo2, cfRichiedente, idDomandaIscrizione);

			DatiRicevuta datiRicevuta = new DatiRicevuta();
			datiRicevuta.setProtocollo(protocollo);
			datiRicevuta.setAnnoScolastico(domandaMaterna.getAnnoScolastico());

			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), datiRicevuta)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	@Override
	public Response read(SecurityContext sc, HttpServletRequest request, Long idDomandaIscrizione, String cfRichiedente) {
		final String methodName = "read";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			DomandaMaterna result = this.domandaSrvBean.getDomandaMaterna(callerInfo, cfRichiedente, idDomandaIscrizione);
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
	public Response getElencoDomandeMaterneByCfRichiedente(SecurityContext sc, HttpServletRequest request, String codiceFiscale) {
		final String methodName = "getElencoDomandeMaterneByCfRichiedente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			List<InfoDomanda> result = this.domandaSrvBean.getElencoDomandeByCfRichiedente(callerInfo, TipoScuola.MAT, codiceFiscale);
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
	public Response verificaDomanda(SecurityContext sc, HttpServletRequest request, String cfRichiedente, String cfMinore) {
		final String methodName = "verificaDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();

			this.domandaSrvBean.checkDomandaMaterna(callerInfo, cfRichiedente, cfMinore);
			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), null)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	@Override
	public Response getTestataDomandaAccettazione(SecurityContext sc, HttpServletRequest request, Long idDomandaIscrizione, String cfRichiedente) {
		final String methodName = "getTestataDomandaAccettazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.READ)
					.oggOper(methodName)
					.build();
			log.info("@1 getTestataDomadaAccettazione   con materne");
			TestataDomandaAccettazione result = this.domandaSrvBean.getTestataDomandaAccettazione(
					callerInfo, idDomandaIscrizione, cfRichiedente, TipoScuola.MAT);

			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), result)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	public Response accettaPreferenza(SecurityContext sc, HttpServletRequest request, Long idDomandaIscrizione, String codiceScuola, String codiceTipoFrequenza,
			DatiAccettazionePreferenza datiAccettazionePreferenza) {

		final String methodName = "accettaPreferenza";
		
		log.info("@@ siamo in FOSRV inizio");
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.UPDATE)
					.oggOper(methodName)
					.build();

			TestataDomandaAccettazione result = this.domandaSrvBean.accettaPreferenza(
					callerInfo, TipoScuola.MAT, idDomandaIscrizione, codiceScuola, codiceTipoFrequenza, datiAccettazionePreferenza);

			response = Response.ok(new ResponseBody<>(buildSuccessStatus(), result)).build();
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			return buildErrorResponse(e);
		}
		log.info("@@ siamo in FOSRV fine");
		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return response;
	}

	@Override
	public Response rifiutaPreferenza(SecurityContext sc, HttpServletRequest request, Long idDomandaIscrizione, String codiceScuola, String codiceTipoFrequenza,
			DatiAccettazionePreferenza datiAccettazionePreferenza) {

		final String methodName = "rifiutaPreferenza";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Response response;
		try {
			CallerInfo callerInfo = CallerInfoBuilder.from(sc, request)
					.operazione(LogAuditOperations.UPDATE)
					.oggOper(methodName)
					.build();

			TestataDomandaAccettazione result = this.domandaSrvBean.rifiutaPreferenza(
					callerInfo, TipoScuola.MAT, idDomandaIscrizione, codiceScuola, codiceTipoFrequenza, datiAccettazionePreferenza);

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

	private static String buildKeyOper(String cfRichiedente, DomandaMaterna domandaMaterna) {
		StringBuilder sb = new StringBuilder();

		sb.append("richiedente: ");
		if (StringUtils.isNotBlank(cfRichiedente)) {
			sb.append(cfRichiedente);
		}

		sb.append("; ");
		sb.append("operatore: ");

		if (domandaMaterna != null) {
			String cfOperatore = domandaMaterna.getCodiceFiscaleOperatore();
			if (StringUtils.isNotBlank(cfOperatore)) {
				sb.append(cfOperatore);
			}
		}

		return sb.toString();
	}

}
