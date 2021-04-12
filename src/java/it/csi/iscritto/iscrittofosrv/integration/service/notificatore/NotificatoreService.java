package it.csi.iscritto.iscrittofosrv.integration.service.notificatore;

import it.csi.iride2.policy.entity.Identita;
import it.csi.iscritto.iscrittofosrv.dto.notificatore.InfoUtente;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public interface NotificatoreService {

	InfoUtente getInfoUtente(Identita identita) throws ServiceException;

	Errors validateInfoUtente(InfoUtente infoUtente) throws ServiceException;

}
