package it.csi.iscritto.iscrittofosrv.integration.service.validation;

import it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna;
import it.csi.iscritto.iscrittofosrv.dto.nao.InfoNao;
import it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public interface NaoValidationService {

	Errors validateSoggettiNao(InfoNao infoNao, DomandaNido domandaNido) throws ServiceException;

	Errors validateSoggettiNao(InfoNao infoNao, DomandaMaterna domandaMaterna) throws ServiceException;

}
