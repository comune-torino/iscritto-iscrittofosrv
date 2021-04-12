package it.csi.iscritto.iscrittofosrv.integration.service.validation;

import java.util.Date;
import java.util.List;

import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.model.PeriodoLavorativo;

public interface CalcoloGiorniService {

	Integer calcoloGiorniLavorati(Date dataPresentazione, List<PeriodoLavorativo> periodi) throws ServiceException;

}
