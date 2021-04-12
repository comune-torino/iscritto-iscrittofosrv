package it.csi.iscritto.iscrittofosrv.integration.converter.allegato;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import it.csi.iscritto.iscrittofosrv.dto.allegato.Allegato;
import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.util.AllegatoUtils;
import it.csi.iscritto.iscrittofosrv.util.converter.AbstractConverter;

public class AllegatoConverter extends AbstractConverter<it.csi.iscritto.serviscritto.dto.domanda.Allegato, Allegato> {

	@Override
	public Allegato convert(it.csi.iscritto.serviscritto.dto.domanda.Allegato source) {
		Allegato target = null;
		if (source != null) {
			target = new Allegato();

			target.setDataInserimento(source.getDataInserimento());
			target.setDocumento(source.getDocumento());
			target.setIdAllegato(source.getIdAllegato());
			target.setIdAnagraficaSoggetto(source.getIdAnagraficaSoggetto());
			target.setCodTipoAllegato(source.getCodTipoAllegato());
			target.setMimeType(source.getMimeType());
			target.setNomeFile(source.getNomeFile());
			target.setProtocollo(source.getProtocollo());
		}

		return target;
	}

	//////////////////////////////////////////////////////////////////////

	public static final List<Allegato> buildAllegato(MultipartFormDataInput input)
			throws IOException, ServiceException {

		List<Allegato> result = new ArrayList<>();

		List<InputPart> inputParts = getParts(input);
		for (InputPart inputPart : inputParts) {
			result.add(buildAllegato(inputPart));
		}

		return result;
	}

	public static final List<Allegato> buildAllegato(Long idSoggetto, String codTipoAllegato, MultipartFormDataInput input)
			throws IOException {

		List<Allegato> result = new ArrayList<>();

		List<InputPart> inputParts = getParts(input);
		for (InputPart inputPart : inputParts) {
			result.add(buildAllegato(idSoggetto, codTipoAllegato, inputPart));
		}

		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private static Allegato buildAllegato(InputPart inputPart) throws IOException, ServiceException {
		MultivaluedMap<String, String> header = inputPart.getHeaders();

		Long idSoggetto = AllegatoUtils.getIdSoggetto(header);
		String codTipoAllegato = AllegatoUtils.getCodTipoAllegato(header);

		return buildAllegato(idSoggetto, codTipoAllegato, inputPart);
	}

	private static Allegato buildAllegato(Long idSoggetto, String codTipoAllegato, InputPart inputPart)
			throws IOException {

		MultivaluedMap<String, String> header = inputPart.getHeaders();

		String fileName = AllegatoUtils.getFileName(header);
		String mimeType = AllegatoUtils.getMimeType(header);
		byte[] content = IOUtils.toByteArray(inputPart.getBody(InputStream.class, null));

		Allegato target = new Allegato();

		target.setDataInserimento(null);
		target.setDocumento(content);
		target.setIdAllegato(null);
		target.setIdAnagraficaSoggetto(idSoggetto);
		target.setCodTipoAllegato(codTipoAllegato);
		target.setMimeType(mimeType);
		target.setNomeFile(fileName);
		target.setProtocollo(null);

		return target;
	}

	private static List<InputPart> getParts(MultipartFormDataInput input) {
		Map<String, List<InputPart>> form = input.getFormDataMap();

		List<InputPart> result = new ArrayList<>();

		for (Map.Entry<String, List<InputPart>> item : form.entrySet()) {
			List<InputPart> inputParts = item.getValue();
			if (CollectionUtils.isNotEmpty(inputParts)) {
				result.addAll(inputParts);
			}
		}

		return result;
	}

}
