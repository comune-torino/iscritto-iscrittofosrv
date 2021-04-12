package it.csi.iscritto.iscrittofosrv.integration.service.validation;

import it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna;
import it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public interface DomandaValidationService {

	Errors validateSoggetto3(DomandaNido domandaNido) throws ServiceException;

	Errors validateSoggetto3(DomandaMaterna domandaMaterna) throws ServiceException;

}
