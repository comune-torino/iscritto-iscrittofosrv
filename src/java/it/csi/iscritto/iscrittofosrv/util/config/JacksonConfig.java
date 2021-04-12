package it.csi.iscritto.iscrittofosrv.util.config;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<org.codehaus.jackson.map.ObjectMapper> {

	private ObjectMapper objectMapper;

	public JacksonConfig() {
		this.objectMapper = new ObjectMapper();

		// sample to convert any DateTime to readable timestamps
		this.objectMapper.configure(org.codehaus.jackson.map.SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		// this.objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	}

	public ObjectMapper getContext(Class<?> objectType) {
		return objectMapper;
	}
}
