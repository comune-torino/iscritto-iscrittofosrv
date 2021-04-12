package it.csi.iscritto.iscrittofosrv.integration.service.validation.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

import it.csi.iscritto.iscrittofosrv.integration.service.validation.CalcoloGiorniStrategy;
import it.csi.iscritto.iscrittofosrv.integration.service.validation.model.PeriodoLavorativo;
import it.csi.iscritto.iscrittofosrv.util.DateUtils;
import it.csi.iscritto.iscrittofosrv.util.builder.DateRangeBuilder;

public class CalcoloGiorniDefaultStrategy implements CalcoloGiorniStrategy {

	@Override
	public Integer getGiorniLavorati(Date dataPresentazione, List<PeriodoLavorativo> periodi) {
		Set<String> days = new HashSet<>();

		if (CollectionUtils.isNotEmpty(periodi)) {
			for (PeriodoLavorativo periodo : periodi) {
				List<Date> range = DateRangeBuilder
						.onInterval(periodo.getDataInizio(), periodo.getDataFine())
						.withStartFrame(getInizioValidita(dataPresentazione))
						.withEndFrame(dataPresentazione)
						.build();

				for (Date date : range) {
					days.add(DateUtils.toStringDate(date, DateUtils.DEFAULT_DATE_FORMAT));
				}
			}
		}

		return days.size();
	}

	@Override
	public boolean checkPeriodi(List<PeriodoLavorativo> periodi) {
		if (CollectionUtils.isNotEmpty(periodi)) {
			for (PeriodoLavorativo p : periodi) {
				Date dataInizio = p.getDataInizio();
				Date dataFine = p.getDataFine();

				if (dataInizio == null || dataFine == null || !DateUtils.isValidRange(dataInizio, dataFine)) {
					return false;
				}
			}
		}

		return true;
	}

	private static Date getInizioValidita(Date dataPresentazione) {
		Calendar c = DateUtils.toCalendar(dataPresentazione);
		c.add(Calendar.YEAR, -1);
		return c.getTime();
	}

}
