package it.csi.iscritto.iscrittofosrv.util;

import static it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils.toUpper;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import it.csi.iscritto.iscrittofosrv.dto.nao.AnagraficaComponente;
import it.csi.iscritto.iscrittofosrv.dto.nao.ComponenteFamiglia;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.Cittadinanza;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.Generalita;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.VisuraSoggetto;

public final class NaoUtils {
	private NaoUtils() {
		/* NOP */
	}

	public static String getCfComponenteFamiglia(ComponenteFamiglia componente) {
		if (componente == null) {
			return null;
		}

		AnagraficaComponente anagrafica = componente.getAnagrafica();
		if (anagrafica == null) {
			return null;
		}

		String codiceFiscale = anagrafica.getCodiceFiscale();
		if (StringUtils.isBlank(codiceFiscale)) {
			return null;
		}

		return toUpper(codiceFiscale);
	}

	public static String getCfSoggetto(VisuraSoggetto soggetto) {
		if (soggetto == null) {
			return null;
		}

		Generalita generalita = soggetto.getGeneralita();
		if (generalita == null) {
			return null;
		}

		String codiceFiscale = generalita.getCodiceFiscale();
		if (StringUtils.isBlank(codiceFiscale)) {
			return null;
		}

		return toUpper(codiceFiscale);
	}

	public static String getIstatCittadinanza(VisuraSoggetto soggetto) {
		if (soggetto == null) {
			return null;
		}

		Cittadinanza cittadinanza = soggetto.getCittadinanza();
		if (cittadinanza == null) {
			return null;
		}

		return cittadinanza.getCodIstat();
	}

	public static VisuraSoggetto findByCf(String cf, List<VisuraSoggetto> soggetti) {
		if (StringUtils.isBlank(cf) || CollectionUtils.isEmpty(soggetti)) {
			return null;
		}

		for (VisuraSoggetto soggetto : soggetti) {
			if (cf.equalsIgnoreCase(getCfSoggetto(soggetto))) {
				return soggetto;
			}
		}

		return null;
	}

}
