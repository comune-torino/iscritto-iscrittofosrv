package it.csi.iscritto.iscrittofosrv.business.scuola;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

// @Api
@Path("/scuole")
public interface ScuoleApi {

	@GET
	@Path("/nidi")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoScuola[].class)
	Response getElencoNidi(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@QueryParam("dataNascita") String dataNascita);

	@GET
	@Path("/materne")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoScuola[].class)
	Response getElencoMaterne(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@QueryParam("anno") String anno,
			@QueryParam("dataNascita") String dataNascita,
			@QueryParam("cfOperatore") String cfOperatore);

	@GET
	@Path("/nidi/descrizione/{descrizione}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoScuola[].class)
	Response getElencoNidiByDescrizione(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("descrizione") String descrizione,
			@QueryParam("dataNascita") String dataNascita);

	@GET
	@Path("/materne/anno/{anno}/descrizione/{descrizione}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoScuola[].class)
	Response getElencoMaterneByDescrizione(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("anno") String anno,
			@PathParam("descrizione") String descrizione,
			@QueryParam("dataNascita") String dataNascita);

	@GET
	@Path("/nidi/indirizzo/{indirizzo}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoScuola[].class)
	Response getElencoNidiByIndirizzo(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("indirizzo") String indirizzo,
			@QueryParam("dataNascita") String dataNascita);

	@GET
	@Path("/materne/anno/{anno}/indirizzo/{indirizzo}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoScuola[].class)
	Response getElencoMaterneByIndirizzo(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("anno") String anno,
			@PathParam("indirizzo") String indirizzo,
			@QueryParam("dataNascita") String dataNascita);

	@GET
	@Path("/nidi/circoscrizione/{circoscrizione}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoScuola[].class)
	Response getElencoNidiByCircoscrizione(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("circoscrizione") Integer circoscrizione,
			@QueryParam("dataNascita") String dataNascita);

	@GET
	@Path("/materne/anno/{anno}/circoscrizione/{circoscrizione}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoScuola[].class)
	Response getElencoMaterneByCircoscrizione(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("anno") String anno,
			@PathParam("circoscrizione") Integer circoscrizione,
			@QueryParam("dataNascita") String dataNascita);

}
