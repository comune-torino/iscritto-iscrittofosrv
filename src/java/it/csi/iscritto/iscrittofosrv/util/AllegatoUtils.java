package it.csi.iscritto.iscrittofosrv.util;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.FilenameUtils;

import it.csi.iscritto.iscrittofosrv.exception.ServiceException;
import it.csi.iscritto.iscrittofosrv.util.converter.ConvertUtils;

public final class AllegatoUtils {
	public static final String CONTENT_DISPOSITION = "Content-Disposition";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String FILE_NAME_KEY = "filename";

	// informazioni codificate nella proprieta' name
	public static final String NAME_KEY = "name";
	public static final String NAME_KEY_DELIM = "_";
	public static final int NAME_KEY_TOKENS = 4;
	public static final int ID_SOGGETTO_INDEX = 2;
	public static final int COD_TIPO_ALLEGATO_INDEX = 3;

	private AllegatoUtils() {
		/* NOP */
	}

	public static String getFileName(MultivaluedMap<String, String> header) {
		String[] contentDisposition = header.getFirst(CONTENT_DISPOSITION).split(";");

		for (String value : contentDisposition) {
			if (value.trim().startsWith(FILE_NAME_KEY)) {
				String[] name = value.split("=");
				if (name.length > 1) {
					return name[1].trim().replaceAll("\"", "");
				}
			}
		}

		return null;
	}

	public static String getMimeType(MultivaluedMap<String, String> header) {
		String[] contentType = header.getFirst(CONTENT_TYPE).split(";");

		for (String value : contentType) {
			if (!value.contains("=")) {
				return value.trim();
			}
		}

		return null;
	}

	public static Long getIdSoggetto(MultivaluedMap<String, String> header) throws ServiceException {
		List<String> tokens = getNamePropertyContent(header);
		return Long.valueOf(tokens.get(ID_SOGGETTO_INDEX));
	}

	public static String getCodTipoAllegato(MultivaluedMap<String, String> header) throws ServiceException {
		List<String> tokens = getNamePropertyContent(header);
		return tokens.get(COD_TIPO_ALLEGATO_INDEX);
	}

	//////////////////////////////////////////////////////////////////////

	private static List<String> getNamePropertyContent(MultivaluedMap<String, String> header) throws ServiceException {
		String[] contentDisposition = header.getFirst(CONTENT_DISPOSITION).split(";");
		String property = null;

		for (String value : contentDisposition) {
			if (value.trim().startsWith(NAME_KEY)) {
				String[] name = value.split("=");
				if (name.length > 1) {
					property = name[1].trim().replaceAll("\"", "");
					break;
				}
			}
		}

		if (property == null) {
			throw new ServiceException(String.format("proprieta' %s non trovata", NAME_KEY));
		}

		property = FilenameUtils.removeExtension(property);

		List<String> tokens = ConvertUtils.split(property, NAME_KEY_DELIM, true);

		if (tokens.size() < NAME_KEY_TOKENS) {
			throw new ServiceException(String.format("formato proprieta' %s non valido", NAME_KEY));
		}

		return tokens;
	}

}
