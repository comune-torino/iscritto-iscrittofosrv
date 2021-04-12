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
@Path("/province")
public interface ProvinceApi {

	@GET
	@Path("/attive")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Provincia[].class)
	Response getElencoProvinceAttive(
			@Context SecurityContext sc, @Context HttpServletRequest request);

	@GET
	@Path("/attive/istat-regione/{istatRegione}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Provincia[].class)
	Response getElencoProvinceAttiveByIstatRegione(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("istatRegione") String istatRegione);

	@GET
	@Path("/attive-alla-data/{data}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Provincia[].class)
	Response getElencoProvinceAttiveAllaData(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("data") String data);

	@GET
	@Path("/attive-alla-data/{data}/istat-regione/{istatRegione}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Provincia[].class)
	Response getElencoProvinceAttiveAllaDataByIstatRegione(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("data") String data,
			@PathParam("istatRegione") String istatRegione);

}
