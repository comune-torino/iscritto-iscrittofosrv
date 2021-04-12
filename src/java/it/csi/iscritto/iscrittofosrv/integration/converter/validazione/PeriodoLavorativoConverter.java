package it.csi.iscritto.iscrittofosrv.integration.converter.validazione;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.text.ParseException;

import org.apache.log4j.Logger;

import it.csi.iscritto.iscrittofosrv.dto.validazione.InfoPeriodo;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.model.PeriodoLavorativo;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;

public class PeriodoLavorativoConverter extends AbstractConverter<InfoPeriodo, PeriodoLavorativo> {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".converter");

	@Override
	public PeriodoLavorativo convert(InfoPeriodo source) {
		final String methodName = "convert";

		PeriodoLavorativo target = null;
		if (source != null) {
			target = new PeriodoLavorativo();

			try {
				target.setDataInizio(DateUtils.toDate(source.getDataInizio(), DateUtils.DEFAULT_DATE_FORMAT));
				target.setDataFine(DateUtils.toDate(source.getDataFine(), DateUtils.DEFAULT_DATE_FORMAT));
			}
			catch (ParseException e) {
				log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
				throw new IllegalArgumentException(e);
			}
		}

		return target;
	}

}
