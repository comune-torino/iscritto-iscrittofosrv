package it.csi.iscritto.iscrittofosrv.util;

import it.csi.iscritto.iscrittofosrv.dto.materna.DomandaMaterna;
import it.csi.iscritto.iscrittofosrv.dto.nido.DomandaNido;
import it.csi.iscritto.iscrittofosrv.dto.nido.GenitoreSolo;
import it.csi.iscritto.iscrittofosrv.dto.nido.Richiedente;
import it.csi.iscritto.iscrittofosrv.dto.nido.Soggetto1;
import it.csi.iscritto.iscrittofosrv.dto.nido.Soggetto3;

public final class DomandaUtils {
	public static final String STEP_1_4_OPT3 = "C";
	public static final String STEP_1_4_OPT4 = "D";

	public static final String STEP_1_6_OPT4 = "NUB_CEL_RIC";
	public static final String STEP_1_6_OPT5 = "DIV";
	public static final String STEP_1_6_OPT6 = "IST_SEP";
	public static final String STEP_1_6_OPT7 = "SEP";

	private DomandaUtils() {
		/* NOP */
	}

	//////////////////////////////////////////////////////////////////////
	// Richiedente
	//////////////////////////////////////////////////////////////////////
	public static Richiedente getRichiedente(DomandaNido domandaNido) {
		if (domandaNido == null) {
			return null;
		}

		return domandaNido.getRichiedente();
	}

	public static Richiedente getRichiedente(DomandaMaterna domandaMaterna) {
		if (domandaMaterna == null) {
			return null;
		}

		return domandaMaterna.getRichiedente();
	}

	//////////////////////////////////////////////////////////////////////
	// Soggetto 1
	//////////////////////////////////////////////////////////////////////
	public static Soggetto1 getSoggetto1(DomandaNido domandaNido) {
		if (domandaNido == null) {
			return null;
		}

		return domandaNido.getSoggetto1();
	}

	public static Soggetto1 getSoggetto1(DomandaMaterna domandaMaterna) {
		if (domandaMaterna == null) {
			return null;
		}

		return domandaMaterna.getSoggetto1();
	}

	//////////////////////////////////////////////////////////////////////
	// Soggetto 3
	//////////////////////////////////////////////////////////////////////
	public static boolean hasSoggetto3(Richiedente richiedente, Soggetto1 soggetto1) {
		if (richiedente == null) {
			return false;
		}

		String condizioneCoabitazione = richiedente.getCondizioneCoabitazione();
		if (anyMatch(condizioneCoabitazione, STEP_1_4_OPT3)) {
			return true;
		}

		if (anyMatch(condizioneCoabitazione, STEP_1_4_OPT4)) {
			GenitoreSolo genitoreSolo = soggetto1.getGenitoreSolo();
			if (genitoreSolo == null) {
				return false;
			}

			if (anyMatch(genitoreSolo.getStato(), STEP_1_6_OPT4, STEP_1_6_OPT5, STEP_1_6_OPT6, STEP_1_6_OPT7)) {
				return true;
			}
		}

		return false;
	}

	public static Soggetto3 getSoggetto3(DomandaNido domandaNido) {
		if (domandaNido == null) {
			return null;
		}

		return domandaNido.getSoggetto3();
	}

	public static Soggetto3 getSoggetto3(DomandaMaterna domandaMaterna) {
		if (domandaMaterna == null) {
			return null;
		}

		return domandaMaterna.getSoggetto3();
	}

	//////////////////////////////////////////////////////////////////////

	private static boolean anyMatch(String target, String... values) {
		if (target == null || values == null) {
			return false;
		}

		for (String value : values) {
			if (target.equalsIgnoreCase(value)) {
				return true;
			}
		}

		return false;
	}

}
