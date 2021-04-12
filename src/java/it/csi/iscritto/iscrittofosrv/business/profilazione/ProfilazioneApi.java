package it.csi.iscritto.iscrittofosrv.business.profilazione;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.iscritto.iscrittofosrv.dto.profilazione.Profilazione;

// @Api
@Path("/profilazione")
public interface ProfilazioneApi {

	@GET
	@Path("/privilegi/inserimento/{cfOperatore}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Boolean.class)
	Response checkPrivilegioInserimento(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("cfOperatore") String cfOperatore);

	@GET
	@Path("/operatore/{cfOperatore}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Boolean.class)
	Response checkOperatore(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("cfOperatore") String cfOperatore);

}
