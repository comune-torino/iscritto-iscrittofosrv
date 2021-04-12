package it.csi.iscritto.iscrittofosrv.business.nido;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.iscritto.iscrittofosrv.dto.domanda.DatiAccettazionePreferenza;
import it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido;

// @Api
@Path("/nidi")
public interface DomandaNidoApi {

	@POST
	@Path("/domande/{cfRichiedente}")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	// @ApiOperation(value = "", response = DomandaNido.class)
	Response saveBozza(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("cfRichiedente") String cfRichiedente,
			DomandaNido domandaNido);

	@POST
	@Path("/domande/inviata/{idDomandaIscrizione}/{cfRichiedente}")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	// @ApiOperation(value = "", response = String.class)
	Response invioDomanda(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomandaIscrizione") Long idDomandaIscrizione,
			@PathParam("cfRichiedente") String cfRichiedente);

	@GET
	@Path("/domande/{idDomandaIscrizione}/{cfRichiedente}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = DomandaNido.class)
	Response read(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomandaIscrizione") Long idDomandaIscrizione,
			@PathParam("cfRichiedente") String cfRichiedente);

	@GET
	@Path("/domande/richiedente/{codiceFiscale}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = InfoDomanda[].class)
	Response getElencoDomandeNidiByCfRichiedente(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("codiceFiscale") String codiceFiscale);

	@GET
	@Path("/domande/verifica/richiedente/{cfRichiedente}/minore/{cfMinore}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Void.class)
	Response verificaDomanda(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("cfRichiedente") String cfRichiedente,
			@PathParam("cfMinore") String cfMinore);

	@GET
	@Path("/domande/domanda/{idDomandaIscrizione}/{cfRichiedente}/preferenze")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = TestataDomandaAccettazione.class)
	Response getTestataDomandaAccettazione(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomandaIscrizione") Long idDomandaIscrizione,
			@PathParam("cfRichiedente") String cfRichiedente);

	@POST
	@Path("/domande/domanda/{idDomandaIscrizione}/preferenze/preferenza/{codiceScuola}/{codiceTipoFrequenza}/accetta")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	// @ApiOperation(value = "", response = TestataDomandaAccettazione.class)
	Response accettaPreferenza(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomandaIscrizione") Long idDomandaIscrizione,
			@PathParam("codiceScuola") String codiceScuola,
			@PathParam("codiceTipoFrequenza") String codiceTipoFrequenza,
			@NotNull DatiAccettazionePreferenza datiAccettazionePreferenza);

	@POST
	@Path("/domande/domanda/{idDomandaIscrizione}/preferenze/preferenza/{codiceScuola}/{codiceTipoFrequenza}/rinuncia")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	// @ApiOperation(value = "", response = TestataDomandaAccettazione.class)
	Response rifiutaPreferenza(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomandaIscrizione") Long idDomandaIscrizione,
			@PathParam("codiceScuola") String codiceScuola,
			@PathParam("codiceTipoFrequenza") String codiceTipoFrequenza,
			@NotNull DatiAccettazionePreferenza datiAccettazionePreferenza);

}
