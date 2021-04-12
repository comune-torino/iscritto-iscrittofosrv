package it.csi.iscritto.iscrittofosrv.integration.service.nao;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.DatiProfilati;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.Identita;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.client.UtenteServizio;
import it.csi.iscritto.iscrittofosrv.integration.service.nao.config.NaoServiceConfig;

public abstract class AbstractServiceNao {

	@Autowired
	protected NaoServiceConfig naoServiceConfig;

	protected DatiProfilati buildDatiProfilati() {
		DatiProfilati result = new DatiProfilati();

		result.setFlgPaternitaMaternita(this.naoServiceConfig.getFlgPaternitaMaternita());
		result.setFlgProtocolliRiservatiE(this.naoServiceConfig.getFlgProtocolliRiservatiE());
		result.setFlgProtocolliRiservatiQ(this.naoServiceConfig.getFlgProtocolliRiservatiQ());
		result.setFlgRettificheGeneralita(this.naoServiceConfig.getFlgRettificheGeneralita());
		result.setFlgSoggettiCancellati(this.naoServiceConfig.getFlgSoggettiCancellati());

		return result;
	}

	protected Identita buildIdentita() {
		Identita result = new Identita();

		result.setCodFiscale(this.naoServiceConfig.getCodFiscale());
		result.setCognome(this.naoServiceConfig.getCognome());
		result.setIdProvider(this.naoServiceConfig.getIdProvider());
		result.setLivelloAutenticazione(this.naoServiceConfig.getLivelloAutenticazione());
		result.setNome(this.naoServiceConfig.getNome());

		return result;
	}

	protected UtenteServizio buildUtenteServizio() {
		UtenteServizio result = new UtenteServizio();

		result.setCodiceUtente(this.naoServiceConfig.getCodiceUtente());
		result.setIdentita(this.buildIdentita());

		return result;
	}

}
