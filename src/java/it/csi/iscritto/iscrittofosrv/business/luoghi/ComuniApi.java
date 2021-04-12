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
@Path("/comuni")
public interface ComuniApi {

	@GET
	@Path("/attivi")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Comune[].class)
	Response getElencoComuniAttivi(
			@Context SecurityContext sc, @Context HttpServletRequest request);

	@GET
	@Path("/attivi/istat-provincia/{istatProvincia}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Comune[].class)
	Response getElencoComuniAttiviByProvincia(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("istatProvincia") String istatProvincia);

	@GET
	@Path("/attivi-alla-data/{data}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Comune[].class)
	Response getElencoComuniAttiviAllaData(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("data") String data);

	@GET
	@Path("/attivi-alla-data/{data}/istat-provincia/{istatProvincia}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Comune[].class)
	Response getElencoComuniAttiviAllaDataByProvincia(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("data") String data,
			@PathParam("istatProvincia") String istatProvincia);

}
