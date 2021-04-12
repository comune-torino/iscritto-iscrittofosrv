package it.csi.iscritto.iscrittofosrv.integration.converter.domanda;

import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda;

public class CallerInfoDomandaConverter extends AbstractConverter<CallerInfo, CallerInfoDomanda> {

	@Override
	public CallerInfoDomanda convert(CallerInfo source) {
		CallerInfoDomanda target = null;
		if (source != null) {
			target = new CallerInfoDomanda();

			target.setIdApp(source.getIdApp());
			target.setIpAddress(source.getIpAddress());
			target.setKeyOper(source.getKeyOper());
			target.setOggOper(source.getOggOper());
			target.setOperazione(source.getOperazione());
			target.setUtente(source.getUtente());
		}

		return target;
	}

}
