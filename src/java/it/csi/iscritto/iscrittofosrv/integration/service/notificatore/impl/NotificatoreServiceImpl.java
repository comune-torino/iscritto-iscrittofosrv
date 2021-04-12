package it.csi.iscritto.iscrittofosrv.integration.service.notificatore.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import it.csi.iride2.policy.entity.Identita;
import it.csi.iscritto.iscrittofosrv.dto.notificatore.InfoUtente;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.service.notificatore.AbstractNotificatoreService;
import it.csi.iscritto.iscrittofosrv.integration.service.notificatore.NotificatoreService;
import it.csi.iscritto.iscrittofosrv.integration.service.notificatore.model.InfoContatti;
import it.csi.iscritto.iscrittofosrv.integration.service.notificatore.model.InfoPreferenze;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.ErrorCodeEnum;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

@Repository
@Primary
public class NotificatoreServiceImpl extends AbstractNotificatoreService implements NotificatoreService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");

	@Override
	public InfoUtente getInfoUtente(Identita identita) throws ServiceException {
		final String methodName = "getInfoUtente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(identita);
		Validate.notBlank(identita.getCodFiscale());

		InfoUtente result;
		try {
			String codiceFiscale = identita.getCodFiscale();

			Map<String, String> headers = new LinkedHashMap<>();
			headers.put("x-authentication", this.config.getPreferencesToken());
			headers.put("Shib-Iride-IdentitaDigitale", codiceFiscale);

			String uriContatti = UriBuilder.fromPath(this.config.getPreferencesUrl())
					.path("users/{codiceFiscale}/contacts")
					.build(codiceFiscale)
					.toString();

			InfoContatti infoContatti = buildInfoContatti(this.callService(uriContatti, headers));

			String uriPreferenze = UriBuilder.fromPath(this.config.getPreferencesUrl())
					.path("users/{codiceFiscale}/preferences/iscritto")
					.build(codiceFiscale)
					.toString();

			InfoPreferenze infoPreferenze = buildInfoPreferenze(this.callService(uriPreferenze, headers));

			result = buildInfoUtente(infoContatti, infoPreferenze);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Errors validateInfoUtente(InfoUtente infoUtente) throws ServiceException {
		Errors errors = new Errors();

		if (infoUtente == null) {
			errors.addError(ErrorCodeEnum.FRM_001.buildBlockingError());
		}

		if (StringUtils.isBlank(infoUtente.getSms())) {
			errors.addError(ErrorCodeEnum.VAL_NT_001.buildBlockingError());
		}

		if (CollectionUtils.isEmpty(infoUtente.getChannels()) || !infoUtente.getChannels().contains("sms")) {
			errors.addError(ErrorCodeEnum.VAL_NT_002.buildBlockingError());
		}

		return errors;
	}

	private static InfoContatti buildInfoContatti(String json) throws JsonProcessingException, IOException {
		InfoContatti result = new InfoContatti();
		if (StringUtils.isNotBlank(json)) {
			JsonNode node = new ObjectMapper().readTree(json);

			result.setUserId(getText(node, "user_id"));
			result.setSms(getText(node, "sms"));
			result.setEmail(getText(node, "email"));
		}

		return result;
	}

	private static InfoPreferenze buildInfoPreferenze(String json) throws JsonProcessingException, IOException {
		InfoPreferenze result = new InfoPreferenze();
		if (StringUtils.isNotBlank(json)) {
			JsonNode node = new ObjectMapper().readTree(json);

			result.setUserId(getText(node, "user_id"));
			result.setServiceName(getText(node, "service_name"));
			result.setChannels(getText(node, "channels"));
		}

		return result;
	}

	private static InfoUtente buildInfoUtente(InfoContatti infoContatti, InfoPreferenze infoPreferenze) {
		InfoUtente result = new InfoUtente();

		if (infoContatti != null) {
			result.setUserId(infoContatti.getUserId());
			result.setSms(infoContatti.getSms());
			result.setEmail(infoContatti.getEmail());
		}

		if (infoPreferenze != null) {
			result.setServiceName(infoPreferenze.getServiceName());
			result.setChannels(ConvertUtils.split(infoPreferenze.getChannels(), ",", true));
		}

		return result;
	}

	private static String getText(JsonNode node, String fieldName) {
		if (node == null || StringUtils.isBlank(fieldName)) {
			return null;
		}

		JsonNode value = node.findValue(fieldName);
		if (value == null) {
			return null;
		}

		return value.getTextValue();
	}

}
