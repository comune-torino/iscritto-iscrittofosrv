package it.csi.iscritto.iscrittofosrv.integration.service.validation;

import static it.csi.iscritto.iscrittofosrv.util.validation.ErrorType.SYSTEM;
import static it.csi.iscritto.iscrittofosrv.util.validation.ErrorType.VALIDATION;

import it.csi.iscritto.iscrittofosrv.util.validation.Error;
import it.csi.iscritto.iscrittofosrv.util.validation.ErrorType;;

public enum ErrorCodeEnum {
	// errori di sistema non recuperabili
	SYS_001("SYS-001", SYSTEM, "errore interno"),

	// controllo formali
	FRM_001("FRM-001", SYSTEM, "oggetto nullo"),
	FRM_002("FRM-002", SYSTEM, "formato data non valido"),

	// codice fiscale
	VAL_CF_001("VAL-CF-001", VALIDATION, "codice fiscale vuoto"),
	VAL_CF_002("VAL-CF-002", VALIDATION, "lunghezza codice fiscale non valida"),
	VAL_CF_003("VAL-CF-003", VALIDATION, "formato codice fiscale numerico non valido"),
	VAL_CF_004("VAL-CF-004", VALIDATION, "formato codice fiscale alfanumerico non valido"),
	VAL_CF_005("VAL-CF-005", VALIDATION, "carattere di controllo non valido"),

	// notificatore
	VAL_NT_001("VAL-NT-001", VALIDATION, "sms non presente"),
	VAL_NT_002("VAL-NT-002", VALIDATION, "canale sms non attivo"),

	VAL_NAO_001("VAL-NAO-001", SYSTEM, "servizio anagrafica non raggiungibile"),
	VAL_NAO_002("VAL-NAO-002", VALIDATION, "codice fiscale non presente in anagrafica"),

	// profilazione
	VAL_PRF_001("VAL-PRF-001", VALIDATION, "operatore non abilitato all'inserimento domanda"),
	VAL_PRF_002("VAL-PRF-002", VALIDATION, "operatore non presente in anagrafica"),

	// soggetto3
	VAL_SOG3_001("VAL-SOG3-001", VALIDATION, "dati obbligatori mancanti"),
	;

	private String code;
	private String description;
	private ErrorType errorType;

	private ErrorCodeEnum(String code, ErrorType errorType, String description) {
		this.code = code;
		this.errorType = errorType;
		this.description = description;
	}

	public Error buildError() {
		return new Error(this.code, this.description, null, false, this.errorType);
	}

	public Error buildError(String message) {
		return new Error(this.code, this.description, message, false, this.errorType);
	}

	public Error buildBlockingError() {
		return new Error(this.code, this.description, null, true, this.errorType);
	}

	public Error buildBlockingError(String message) {
		return new Error(this.code, this.description, message, true, this.errorType);
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

}
