package it.csi.iscritto.iscrittofosrv.business.domanda;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/domande")
public interface DomandaApi {

	@GET
	@Path("/richiedente/{codiceFiscale}")
	@Produces({ "application/json" })
	Response getElencoDomandeByCfRichiedente(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("codiceFiscale") String codiceFiscale);

	@GET
	@Path("/{idDomanda}/richiedente/{cfRichiedente}/ricevuta-accettazione")
	@Produces({ "application/octet-stream" })
	Response downloadRicevutaAccettazione(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomanda") Long idDomanda,
			@PathParam("cfRichiedente") String cfRichiedente);

	@DELETE
	@Path("/{idDomandaIscrizione}/{cfRichiedente}")
	@Produces({ "application/json" })
	Response deleteDomanda(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomandaIscrizione") Long idDomandaIscrizione,
			@PathParam("cfRichiedente") String cfRichiedente,
			@QueryParam("cfOperatore") String cfOperatore);

}
