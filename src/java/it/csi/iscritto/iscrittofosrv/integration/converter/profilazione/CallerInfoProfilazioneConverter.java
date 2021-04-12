package it.csi.iscritto.iscrittofosrv.integration.converter.profilazione;

import it.csi.iscritto.iscrittofosrv.dto.common.CallerInfo;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione;

public class CallerInfoProfilazioneConverter extends AbstractConverter<CallerInfo, CallerInfoProfilazione> {

	@Override
	public CallerInfoProfilazione convert(CallerInfo source) {
		CallerInfoProfilazione target = null;
		if (source != null) {
			target = new CallerInfoProfilazione();

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
