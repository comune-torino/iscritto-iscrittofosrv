package it.csi.iscritto.iscrittofosrv.business.validazione;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.iscritto.iscrittofosrv.dto.validazione.GiorniLavoratiFilter;

// @Api
@Path("/controlli")
public interface ValidazioneApi {

	@POST
	@Path("/giorni-lavorati")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Integer.class)
	Response getGiorniLavorati(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			GiorniLavoratiFilter filter);

	@GET
	@Path("/codice-fiscale/{cf}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Integer.class)
	Response validaCodiceFiscale(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("cf") String cf);

}
