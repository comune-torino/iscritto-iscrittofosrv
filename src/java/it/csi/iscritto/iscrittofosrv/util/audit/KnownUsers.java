package it.csi.iscritto.iscrittofosrv.util.audit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum KnownUsers {
	// @formatter:off
	ISCRITTOFO(
		// TODO: codice linea cliente 
		"iscritto_coto-01_prod_iscrittofosrv",
		"iscrittofo"
	),
	UNKNOWN(
		null
	);
	// @formatter:on

	private String idApp;
	private List<String> aliases;

	private KnownUsers(String idApp, String... aliases) {
		this.idApp = idApp;
		this.aliases = new ArrayList<>();
		if (aliases != null) {
			this.aliases.addAll(Arrays.asList(aliases));
		}
	}

	public static KnownUsers findUser(String alias) {
		KnownUsers result = KnownUsers.UNKNOWN;
		for (KnownUsers e : values()) {
			for (String knownAlias : e.aliases) {
				if (knownAlias.equalsIgnoreCase(alias)) {
					return e;
				}
			}
		}

		return result;
	}

	public String getIdApp() {
		return idApp;
	}

}
