package it.csi.iscritto.iscrittofosrv.util.config;

import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

import it.csi.iscritto.iscrittofosrv.business.SpringApplicationContextHelper;

@Provider
public class SpringInjectorInterceptor implements PreProcessInterceptor {

	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethod method) {
		SpringApplicationContextHelper.injectSpringBeansIntoRestEasyService(method.getResourceClass().getName());

		return null;
	}
}
