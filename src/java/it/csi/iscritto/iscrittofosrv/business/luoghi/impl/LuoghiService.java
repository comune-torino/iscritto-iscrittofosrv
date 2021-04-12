package it.csi.iscritto.iscrittofosrv.business.luoghi.impl;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.dto.luoghi.Comune;
import it.csi.iscritto.iscrittofosrv.dto.luoghi.Provincia;
import it.csi.iscritto.iscrittofosrv.dto.luoghi.Regione;
import it.csi.iscritto.iscrittofosrv.dto.luoghi.Stato;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.converter.luoghi.ComuneConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.luoghi.ProvinciaConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.luoghi.RegioneConverter;
import it.csi.iscritto.iscrittofosrv.integration.converter.luoghi.StatoConverter;
import it.csi.iscritto.iscrittofosrv.integration.service.luoghi.LuoghiSrvBean;
import it.csi.iscritto.iscrittofosrv.util.Constants;

@Component
public class LuoghiService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	@Autowired
	private LuoghiSrvBean luoghiSrvBean;

	//////////////////////////////////////////////////////////////////////
	// Stati
	//////////////////////////////////////////////////////////////////////
	public List<Stato> getElencoStatiAttivi(CallerInfo callerInfo) throws ServiceException {
		final String methodName = "getElencoStatiAttivi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Stato> result = this.getElencoStatiAttiviAllaData(callerInfo, new Date());

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Stato> getElencoStatiAttiviAllaData(CallerInfo callerInfo, Date data) throws ServiceException {
		final String methodName = "getElencoStatiAttiviAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Stato> result = new StatoConverter().convertAll(this.luoghiSrvBean.findStatiAttiviAllaData(data));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////
	// Regioni
	//////////////////////////////////////////////////////////////////////
	public List<Regione> getElencoRegioniAttive(CallerInfo callerInfo) throws ServiceException {
		final String methodName = "getElencoRegioniAttive";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Regione> result = this.getElencoRegioniAttiveAllaData(callerInfo, new Date());

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Regione> getElencoRegioniAttiveAllaData(CallerInfo callerInfo, Date data) throws ServiceException {
		final String methodName = "getElencoRegioniAttiveAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Regione> result = new RegioneConverter().convertAll(this.luoghiSrvBean.findRegioniAttiveAllaData(data));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////
	// Province
	//////////////////////////////////////////////////////////////////////
	public List<Provincia> getElencoProvinceAttive(CallerInfo callerInfo, String istatRegione) throws ServiceException {
		final String methodName = "getElencoRegioniAttive";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Provincia> result = this.getElencoProvinceAttiveAllaData(callerInfo, new Date(), istatRegione);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Provincia> getElencoProvinceAttiveAllaData(CallerInfo callerInfo, Date data, String istatRegione) throws ServiceException {
		final String methodName = "getElencoProvinceAttiveAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Provincia> result = new ProvinciaConverter().convertAll(this.luoghiSrvBean.findProvinceAttiveAllaData(data, istatRegione));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////
	// Comuni
	//////////////////////////////////////////////////////////////////////
	public List<Comune> getElencoComuniAttivi(CallerInfo callerInfo, String istatProvincia) throws ServiceException {
		final String methodName = "getElencoComuniAttivi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Comune> result = this.getElencoComuniAttiviAllaData(callerInfo, new Date(), istatProvincia);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Comune> getElencoComuniAttiviAllaData(CallerInfo callerInfo, Date data, String istatProvincia) throws ServiceException {
		final String methodName = "getElencoComuniAttiviAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Comune> result = new ComuneConverter().convertAll(this.luoghiSrvBean.findComuniAttiviAllaData(data, istatProvincia));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
