package it.csi.iscritto.iscrittofosrv.business.anagrafica;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

// @Api
@Path("/anagrafica")
public interface AnagraficaApi {

	@GET
	@Path("/dettaglio-famiglia/{cf}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoNao.class)
	Response getDettaglioFamiglia(@PathParam("cf") String cf, @Context SecurityContext sc, @Context HttpServletRequest request);

}
