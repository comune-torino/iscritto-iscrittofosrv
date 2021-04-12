package it.csi.iscritto.iscrittofosrv.exception;

import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public final class ServiceException extends ApplicationException {
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(Errors errors) {
		super();
		this.errors = errors;
	}

	public ServiceException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public ServiceException(String message, Throwable cause, Errors errors) {
		super(message, cause);
		this.errors = errors;
	}

	public ServiceException(Throwable cause, Errors errors) {
		super(cause);
		this.errors = errors;
	}

}
