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
@Path("/stati")
public interface StatiApi {

	@GET
	@Path("/attivi")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Stato[].class)
	Response getElencoStatiAttivi(
			@Context SecurityContext sc, @Context HttpServletRequest request);

	@GET
	@Path("/attivi-alla-data/{data}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Stato[].class)
	Response getElencoStatiAttiviAllaData(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("data") String data);

}
