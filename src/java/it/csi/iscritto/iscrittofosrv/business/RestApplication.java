package it.csi.iscritto.iscrittofosrv.business;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import it.csi.iscritto.iscrittofosrv.business.allegato.impl.AllegatiApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.anagrafica.impl.AnagraficaApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.domanda.impl.DomandaApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.luoghi.impl.ComuniApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.luoghi.impl.ProvinceApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.luoghi.impl.RegioniApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.luoghi.impl.StatiApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.materna.impl.DomandaMaternaApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.nido.impl.DomandaNidoApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.profilazione.impl.ProfilazioneApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.scuola.impl.ScuoleApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.utente.impl.UtenteApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.business.validazione.impl.ValidazioneApiServiceImpl;
import it.csi.iscritto.iscrittofosrv.util.config.SpringInjectorInterceptor;
import it.csi.iscritto.iscrittofosrv.util.config.SpringSupportedResource;

@ApplicationPath("/iscritto")
public class RestApplication extends Application {
	private Set<Object> singletons = new HashSet<>();

	public RestApplication() {
		// allegato
		this.singletons.add(new AllegatiApiServiceImpl());

		// anagrafica
		this.singletons.add(new AnagraficaApiServiceImpl());

		// domande
		this.singletons.add(new DomandaApiServiceImpl());

		// luoghi
		this.singletons.add(new StatiApiServiceImpl());
		this.singletons.add(new RegioniApiServiceImpl());
		this.singletons.add(new ProvinceApiServiceImpl());
		this.singletons.add(new ComuniApiServiceImpl());

		// materna
		this.singletons.add(new DomandaMaternaApiServiceImpl());

		// nido
		this.singletons.add(new DomandaNidoApiServiceImpl());

		// profilazione
		this.singletons.add(new ProfilazioneApiServiceImpl());

		// scuola
		this.singletons.add(new ScuoleApiServiceImpl());

		// utente
		this.singletons.add(new UtenteApiServiceImpl());

		// validazione
		this.singletons.add(new ValidazioneApiServiceImpl());

		//////////////////////////////////////////////////////////////////////

		// spring
		this.singletons.add(new SpringInjectorInterceptor());
		for (Object c : this.singletons) {
			if (c instanceof SpringSupportedResource) {
				SpringApplicationContextHelper.registerRestEasyController(c);
			}
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> set = new HashSet<>();

		// abilita la generazione del file yaml
		// set.add(javax.annotation.Resource.class);
		// set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		// set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return set;
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}

}
