package it.csi.iscritto.iscrittofosrv.exception;

import it.csi.iscritto.iscrittofosrv.util.validation.Errors;

public abstract class ApplicationException extends Exception {
	private static final long serialVersionUID = 1L;

	protected Errors errors;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(Errors errors) {
		super();
		this.errors = errors;
	}

	public ApplicationException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public ApplicationException(String message, Throwable cause, Errors errors) {
		super(message, cause);
		this.errors = errors;
	}

	public ApplicationException(Throwable cause, Errors errors) {
		super(cause);
		this.errors = errors;
	}

	public Errors getErrors() {
		return this.errors;
	}

}
