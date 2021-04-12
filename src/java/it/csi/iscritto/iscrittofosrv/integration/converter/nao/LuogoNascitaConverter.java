package it.csi.iscritto.iscrittofosrv.integration.converter.nao;

import static org.apache.commons.lang3.StringUtils.trim;

import it.csi.iscritto.iscrittofosrv.dto.nao.LuogoNascitaComponente;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.Luogo;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;

public class LuogoNascitaConverter extends AbstractConverter<Luogo, LuogoNascitaComponente> {

	@Override
	public LuogoNascitaComponente convert(Luogo source) {
		LuogoNascitaComponente target = null;
		if (source != null) {
			target = new LuogoNascitaComponente();

			target.setCodComune(trim(source.getCodIstatComune()));
			target.setCodNazione(trim(source.getCodCatNazione()));
			target.setCodProvincia(trim(source.getCodIstatProvincia()));
			target.setDescComune(source.getDescLuogo());
			target.setDescNazione(source.getDescNazione());
			target.setDescProvincia(source.getDescProvincia());

			target.setCodRegione(null); // gestito esternamente
			target.setDescRegione(null); // gestito esternamente
		}

		return target;
	}

}
