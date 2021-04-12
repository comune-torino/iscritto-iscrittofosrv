package it.csi.iscritto.iscrittofosrv.util;

import static it.csi.iscritto.iscrittofosrv.util.DateUtils.between;
import static it.csi.iscritto.iscrittofosrv.util.DateUtils.withoutTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;

import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiFasciaEta;
import it.csi.iscritto.iscrittofosrv.integration.dao.TipoScuola;

public final class FasciaEtaUtils {
	private FasciaEtaUtils() {
		/* NOP */
	}

	public static List<DatiFasciaEta> filterByDataNascita(TipoScuola tipoScuola, Date dataNascita, List<DatiFasciaEta> datiFasceEta) {
		Validate.notNull(tipoScuola);
		List<DatiFasciaEta> result = new ArrayList<>();

		if (dataNascita == null || CollectionUtils.isEmpty(datiFasceEta)) {
			return result;
		}

		List<DatiFasciaEta> fasceEta = filterByTipoScuola(tipoScuola, datiFasceEta);
		for (DatiFasciaEta fasciaEta : fasceEta) {
			Date start = withoutTime(fasciaEta.getDataDa());
			Date end = withoutTime(fasciaEta.getDataA());
			if (between(dataNascita, start, end)) {
				result.add(fasciaEta);
			}
		}

		return result;
	}

	public static List<DatiFasciaEta> filterByTipoScuola(TipoScuola tipoScuola, List<DatiFasciaEta> values) {
		List<DatiFasciaEta> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(values)) {
			for (DatiFasciaEta value : values) {
				if (value == null) {
					continue;
				}

				if (tipoScuola.getCod().equalsIgnoreCase(value.getCodOrdineScuola())) {
					result.add(value);
				}
			}
		}

		return result;
	}

}
