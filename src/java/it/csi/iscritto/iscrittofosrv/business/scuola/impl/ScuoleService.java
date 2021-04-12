package it.csi.iscritto.iscrittofosrv.business.scuola.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.scuola.InfoScuola;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.converter.scuola.InfoScuolaConverter;
import it.csi.iscritto.iscrittofosrv.integration.dao.TipoScuola;
import it.csi.iscritto.iscrittofosrv.integration.service.scuole.ScuoleSrvBean;
import it.csi.iscritto.iscrittofosrv.util.Constants;

@Component
public class ScuoleService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private ScuoleSrvBean scuoleSrvBean;

	public List<InfoScuola> getElencoScuole(CallerInfo callerInfo, TipoScuola tipoScuola, String codAnno, Date dataNascita, String cfOperatore)
			throws ServiceException {

		final String methodName = "getElencoScuole";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<InfoScuola> result = new InfoScuolaConverter().convertAll(
				this.scuoleSrvBean.findScuole(tipoScuola, codAnno, dataNascita, cfOperatore));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<InfoScuola> getElencoScuoleByDescrizione(CallerInfo callerInfo, TipoScuola tipoScuola, String codAnno, String descrizione, Date dataNascita)
			throws ServiceException {

		final String methodName = "getElencoScuoleByDescrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<InfoScuola> result = new InfoScuolaConverter().convertAll(
				this.scuoleSrvBean.findScuoleByDescrizione(tipoScuola, codAnno, descrizione, dataNascita));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<InfoScuola> getElencoScuoleByIndirizzo(CallerInfo callerInfo, TipoScuola tipoScuola, String codAnno, String indirizzo, Date dataNascita)
			throws ServiceException {

		final String methodName = "getElencoScuoleByIndirizzo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<InfoScuola> result = new InfoScuolaConverter().convertAll(
				this.scuoleSrvBean.findScuoleByIndirizzo(tipoScuola, codAnno, indirizzo, dataNascita));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<InfoScuola> getElencoScuoleByCircoscrizione(CallerInfo callerInfo, TipoScuola tipoScuola, String codAnno, Integer circoscrizione,
			Date dataNascita) throws ServiceException {

		final String methodName = "getElencoScuoleByCircoscrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<InfoScuola> result = new InfoScuolaConverter().convertAll(
				this.scuoleSrvBean.findScuoleByCircoscrizione(tipoScuola, codAnno, circoscrizione, dataNascita));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public String getCodAnnoNidi(CallerInfo callerInfo, Date data) throws ServiceException {
		final String methodName = "getCodAnnoNidi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(data);

		String result = this.scuoleSrvBean.getCodAnnoNidi(data);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
