package it.csi.iscritto.iscrittofosrv.integration.service.scuole;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.dao.TipoScuola;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.scuole.CriterioRicerca;
import it.csi.iscritto.serviscritto.dto.scuole.Scuola;
import it.csi.iscritto.serviscritto.interfacecsi.scuole.ScuoleSrv;

public class ScuoleSrvBean {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");

	private ScuoleSrv serviceInterface;

	public void setServiceInterface(ScuoleSrv serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	public List<Scuola> findScuole(TipoScuola tipoScuola, String codAnno, Date dataNascita, String cfOperatore) throws ServiceException {
		final String methodName = "findScuole";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Scuola> result;
		try {
			CriterioRicerca cr = new CriterioRicerca();
			cr.setTipoScuola(tipoScuola.getCod());
			cr.setCodAnno(codAnno);
			cr.setDataNascita(dataNascita);
			cr.setCodiceCfOperatore(cfOperatore);

			result = ConvertUtils.toList(this.serviceInterface.getElencoScuole(cr));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Scuola> findScuoleByDescrizione(TipoScuola tipoScuola, String codAnno, String descrizione, Date dataNascita) throws ServiceException {
		final String methodName = "findScuoleByDescrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Scuola> result;
		try {
			CriterioRicerca cr = new CriterioRicerca();
			cr.setTipoScuola(tipoScuola.getCod());
			cr.setCodAnno(codAnno);
			cr.setDataNascita(dataNascita);
			cr.setDescrizione(descrizione);

			result = ConvertUtils.toList(this.serviceInterface.getElencoScuole(cr));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Scuola> findScuoleByIndirizzo(TipoScuola tipoScuola, String codAnno, String indirizzo, Date dataNascita) throws ServiceException {
		final String methodName = "findScuoleByIndirizzo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Scuola> result;
		try {
			CriterioRicerca cr = new CriterioRicerca();
			cr.setTipoScuola(tipoScuola.getCod());
			cr.setCodAnno(codAnno);
			cr.setDataNascita(dataNascita);
			cr.setIndirizzo(indirizzo);

			result = ConvertUtils.toList(this.serviceInterface.getElencoScuole(cr));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Scuola> findScuoleByCircoscrizione(TipoScuola tipoScuola, String codAnno, Integer circoscrizione, Date dataNascita) throws ServiceException {
		final String methodName = "findScuoleByCircoscrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Scuola> result;
		try {
			CriterioRicerca cr = new CriterioRicerca();
			cr.setTipoScuola(tipoScuola.getCod());
			cr.setCodAnno(codAnno);
			cr.setDataNascita(dataNascita);
			cr.setCircoscrizione(circoscrizione);

			result = ConvertUtils.toList(this.serviceInterface.getElencoScuole(cr));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public String getCodAnnoNidi(Date data) throws ServiceException {
		final String methodName = "getCodAnnoNidi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		String result;
		try {
			result = this.serviceInterface.getCodAnnoNidi(data);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<String> getCodAnniMaterne(Date data) throws ServiceException {
		final String methodName = "getCodAnniMaterne";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<String> result;
		try {
			result = ConvertUtils.toList(this.serviceInterface.getCodAnniMaterne(data));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
