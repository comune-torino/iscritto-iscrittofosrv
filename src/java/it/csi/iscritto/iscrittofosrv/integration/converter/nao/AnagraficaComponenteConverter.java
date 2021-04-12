package it.csi.iscritto.iscrittofosrv.integration.converter.nao;

import static it.csi.iscritto.iscrittofosrv.util.DateUtils.DEFAULT_DATE_FORMAT;
import static it.csi.iscritto.iscrittofosrv.util.DateUtils.NAO_DATE_FORMAT;
import static it.csi.iscritto.iscrittofosrv.util.DateUtils.changeFormat;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.text.ParseException;

import org.apache.log4j.Logger;

import it.csi.iscritto.iscrittofosrv.dto.nao.AnagraficaComponente;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.Generalita;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;

public class AnagraficaComponenteConverter extends AbstractConverter<Generalita, AnagraficaComponente> {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".converter");

	@Override
	public AnagraficaComponente convert(Generalita source) {
		final String methodName = "convert";

		AnagraficaComponente target = null;
		if (source != null) {
			target = new AnagraficaComponente();

			target.setNome(source.getNome());
			target.setCognome(source.getCognome());
			target.setCodiceFiscale(source.getCodiceFiscale());
			target.setOraMinutiNascita(source.getOraMinutiNascita());
			target.setSesso(source.getSesso());

			try {
				target.setDataNascita(changeFormat(source.getDataNascita(), NAO_DATE_FORMAT, DEFAULT_DATE_FORMAT));
			}
			catch (ParseException e) {
				log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			}
		}

		return target;
	}

}
