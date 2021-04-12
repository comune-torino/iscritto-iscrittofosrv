package it.csi.iscritto.iscrittofosrv.business.luoghi;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

// @Api
@Path("/regioni")
public interface RegioniApi {

	@GET
	@Path("/attive")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Regione[].class)
	Response getElencoRegioniAttive(
			@Context SecurityContext sc, @Context HttpServletRequest request);

	@GET
	@Path("/attive-alla-data/{data}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Regione[].class)
	Response getElencoRegioniAttiveAllaData(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("data") String data);

}
