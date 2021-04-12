package it.csi.iscritto.iscrittofosrv.business.allegato;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

// @Api
@Path("/allegati")
public interface AllegatiApi {

	@POST
	@Path("/{idDomanda}/{idSoggetto}/{codTipologia}/{cfRichiedente}")
	@Consumes({ "multipart/form-data" })
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Long[].class)
	Response uploadAllegato(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomanda") Long idDomanda,
			@PathParam("idSoggetto") Long idSoggetto,
			@PathParam("codTipologia") String codTipologia,
			@PathParam("cfRichiedente") String cfRichiedente,
			MultipartFormDataInput input);

	@POST
	@Path("/multipart/{idDomanda}/{cfRichiedente}")
	@Consumes({ "multipart/form-data" })
	@Produces({ "application/json" })
	Response uploadMultipart(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomanda") Long idDomanda,
			@PathParam("cfRichiedente") String cfRichiedente,
			MultipartFormDataInput input);

	@GET
	@Path("/{idDomanda}/{idAllegato}/{cfRichiedente}")
	@Produces({ "application/octet-stream" })
	// @ApiOperation(value = "", response = Allegato.class)
	Response downloadAllegato(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomanda") Long idDomanda,
			@PathParam("idAllegato") Long idAllegato,
			@PathParam("cfRichiedente") String cfRichiedente);

	@DELETE
	@Path("/{idDomanda}/{idAllegato}/{cfRichiedente}")
	@Produces({ "application/json" })
	// @ApiOperation(value = "", response = Integer.class)
	Response deleteAllegato(
			@Context SecurityContext sc, @Context HttpServletRequest request,
			@PathParam("idDomanda") Long idDomanda,
			@PathParam("idAllegato") Long idAllegato,
			@PathParam("cfRichiedente") String cfRichiedente);

}
