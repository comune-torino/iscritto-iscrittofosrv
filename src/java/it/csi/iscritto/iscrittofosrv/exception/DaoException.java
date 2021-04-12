package it.csi.iscritto.iscrittofosrv.exception;

import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public final class DaoException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(Errors errors) {
		super();
		this.errors = errors;
	}

	public DaoException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public DaoException(String message, Throwable cause, Errors errors) {
		super(message, cause);
		this.errors = errors;
	}

	public DaoException(Throwable cause, Errors errors) {
		super(cause);
		this.errors = errors;
	}

}
