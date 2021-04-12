package it.csi.iscritto.iscrittofosrv.integration.service.luoghi;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.luoghi.Luogo;
import it.csi.iscritto.serviscritto.interfacecsi.luoghi.LuoghiSrv;

public class LuoghiSrvBean {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");

	private LuoghiSrv serviceInterface;

	public void setServiceInterface(LuoghiSrv serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	public List<Luogo> findStatiAttiviAllaData(Date data) throws ServiceException {
		final String methodName = "findStatiAttiviAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Luogo> result;
		try {
			result = ConvertUtils.toList(this.serviceInterface.findStatiAttiviAllaData(data));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Luogo> findRegioniAttiveAllaData(Date data) throws ServiceException {
		final String methodName = "findRegioniAttiveAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Luogo> result;
		try {
			result = ConvertUtils.toList(this.serviceInterface.findRegioniAttiveAllaData(data));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Luogo> findProvinceAttiveAllaData(Date data, String istatRegione) throws ServiceException {
		final String methodName = "findProvinceAttiveAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Luogo> result;
		try {
			result = ConvertUtils.toList(this.serviceInterface.findProvinceAttiveAllaData(data, istatRegione));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Luogo> findComuniAttiviAllaData(Date data, String istatProvincia) throws ServiceException {
		final String methodName = "findComuniAttiviAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Luogo> result;
		try {
			result = ConvertUtils.toList(this.serviceInterface.findComuniAttiviAllaData(data, istatProvincia));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Luogo> findByIstatComuneAllaData(Date data, String istatComune) throws ServiceException {
		final String methodName = "findByIstatComuneAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Luogo> result;
		try {
			result = ConvertUtils.toList(this.serviceInterface.findByIstatComuneAllaData(data, istatComune));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Luogo findByIstatStatoAllaData(Date data, String istatStato) throws ServiceException {
		final String methodName = "findByIstatStatoAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Luogo result;
		try {
			result = this.serviceInterface.findByIstatStatoAllaData(data, istatStato);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
