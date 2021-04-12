package it.csi.iscritto.iscrittofosrv.integration.service.validation;

import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public interface ValidationService {

	Errors validateCodiceFiscale(String codiceFiscale) throws ServiceException;

}
