package it.csi.iscritto.iscrittofosrv.util.validation;

import java.io.Serializable;

public class Error implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;
	private String description;
	private String message;
	private boolean isBlocking;
	private ErrorType errorType;

	public Error(String code, String description, boolean isBlocking, ErrorType errorType) {
		this(code, description, null, isBlocking, errorType);
	}

	public Error(String code, String description, String message, boolean isBlocking, ErrorType errorType) {
		this.code = code;
		this.description = description;
		this.message = message;
		this.isBlocking = isBlocking;
		this.errorType = errorType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isBlocking() {
		return isBlocking;
	}

	public void setBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

}
