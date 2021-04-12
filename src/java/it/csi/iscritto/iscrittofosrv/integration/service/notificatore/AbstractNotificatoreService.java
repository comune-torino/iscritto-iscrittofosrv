package it.csi.iscritto.iscrittofosrv.integration.service.notificatore;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.service.notificatore.config.NotificatoreServiceConfig;
import it.csi.iscritto.iscrittofosrv.util.Constants;

public abstract class AbstractNotificatoreService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");

	@Autowired
	protected NotificatoreServiceConfig config;

	protected final String callService(String uri, Map<String, String> headers) throws ServiceException {
		final String methodName = "callService";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		String result = null;
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();) {
			RequestBuilder builder = RequestBuilder.get();
			builder.setUri(uri);

			if (headers != null) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					builder.setHeader(entry.getKey(), entry.getValue());
				}
			}

			HttpUriRequest request = builder.build();
			try (CloseableHttpResponse response = httpClient.execute(request)) {
				StatusLine statusLine = response.getStatusLine();

				if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
					HttpEntity entity = response.getEntity();
					result = IOUtils.toString(entity.getContent(), StandardCharsets.UTF_8);
				}
			}
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
