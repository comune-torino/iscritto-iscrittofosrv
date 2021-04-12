package it.csi.iscritto.iscrittofosrv.integration.service.profilazione;

import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.iscrittofosrv.util.LoggingUtils.buildMessage;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.converter.profilazione.CallerInfoProfilazioneConverter;
import it.csi.iscritto.iscrittofosrv.util.Constants;
import it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione;
import it.csi.iscritto.serviscritto.dto.profilazione.Operatore;
import it.csi.iscritto.serviscritto.dto.profilazione.PrivilegioOperatore;
import it.csi.iscritto.serviscritto.dto.profilazione.Profilo;
import it.csi.iscritto.serviscritto.interfacecsi.profilazione.ProfilazioneSrv;

public class ProfilazioneSrvBean {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".integration.service");
	public static final String PRIV_INS_DOM = "P_DOM_INS";

	private ProfilazioneSrv serviceInterface;

	public void setServiceInterface(ProfilazioneSrv serviceInterface) {
		this.serviceInterface = serviceInterface;
	}

	public boolean isAbilitatoInserimento(CallerInfo callerInfo, String codiceFiscale) throws ServiceException {
		final String methodName = "isAbilitatoInserimento";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notBlank(codiceFiscale);
		log.info("@@ isAbilitatoInserimento");
		
		boolean result = false;
		try {
			CallerInfoProfilazione callerInfoProfilazione = new CallerInfoProfilazioneConverter().convert(callerInfo);

			Profilo[] profili = this.serviceInterface.getProfiliOperatore(callerInfoProfilazione, codiceFiscale);
			if (ArrayUtils.isNotEmpty(profili)) {
				for (Profilo profilo : profili) {
					boolean hasPrivilegioInserimento = this.hasPrivilegioInserimento(
							callerInfoProfilazione, codiceFiscale, profilo.getCodProfilo());

					if (hasPrivilegioInserimento) {
						result = true;
						break;
					}
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

	public boolean isAbilitatoInserimentoNidi(CallerInfo callerInfo, String codiceFiscale) throws ServiceException {
		final String methodName = "isAbilitatoInserimento";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("@@ isAbilitatoInserimentoNidi");
		Validate.notBlank(codiceFiscale);
		
		boolean result = false;
		try {
			CallerInfoProfilazione callerInfoProfilazione = new CallerInfoProfilazioneConverter().convert(callerInfo);

			Boolean auth = this.serviceInterface.getAutorizzatoNidi(callerInfoProfilazione, codiceFiscale);

			result = auth;

		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public boolean isAbilitatoInserimentoMaterne(CallerInfo callerInfo, String codiceFiscale) throws ServiceException {
		final String methodName = "isAbilitatoInserimento";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("@@ isAbilitatoInserimentoMaterne");
		Validate.notBlank(codiceFiscale);
		
		boolean result = false;
		try {
			CallerInfoProfilazione callerInfoProfilazione = new CallerInfoProfilazioneConverter().convert(callerInfo);

			Boolean auth = this.serviceInterface.getAutorizzatoMaterne(callerInfoProfilazione, codiceFiscale);

			result = auth;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public boolean operatorePresente(CallerInfo callerInfo, String codiceFiscale) throws ServiceException {
		final String methodName = "operatorePresente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notBlank(codiceFiscale);
		log.info("@@ FO operatorePresente, cod f:"+codiceFiscale);
		boolean result;
		try {
			CallerInfoProfilazione callerInfoProfilazione = new CallerInfoProfilazioneConverter().convert(callerInfo);
			
			Operatore operatore = this.serviceInterface.getOperatoreByCodiceFiscale(callerInfoProfilazione, codiceFiscale);
			log.info("@@ FO2 operatore: "+operatore);
			result = operatore != null;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private boolean hasPrivilegioInserimento(CallerInfoProfilazione callerInfo, String codiceFiscale, String codiceProfilo) throws Exception {
		PrivilegioOperatore[] privilegiOperatore = this.serviceInterface.getPrivilegiOperatore(
				callerInfo, codiceFiscale, codiceProfilo);

		if (ArrayUtils.isEmpty(privilegiOperatore)) {
			return false;
		}

		for (PrivilegioOperatore priv : privilegiOperatore) {
			if (PRIV_INS_DOM.equals(priv.getCodicePrivilegio())) {
				return true;
			}
		}

		return false;
	}

}
