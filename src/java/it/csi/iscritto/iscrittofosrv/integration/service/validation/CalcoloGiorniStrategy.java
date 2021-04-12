package it.csi.iscritto.iscrittofosrv.integration.service.validation;

import java.util.Date;
import java.util.List;

import it.csi.iscritto.iscrittofosrv.integration.service.validation.model.PeriodoLavorativo;

public interface CalcoloGiorniStrategy {

	Integer getGiorniLavorati(Date dataPresentazione, List<PeriodoLavorativo> periodi);

	boolean checkPeriodi(List<PeriodoLavorativo> periodi);

}
