package it.csi.iscritto.iscrittofosrv.business.utente;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

// @Api
@Path("/utente")
public interface UtenteApi {

	@GET
	@Path("/info")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoUtente.class)
	Response getInfoUtente(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@QueryParam("identita") String identita);

}
