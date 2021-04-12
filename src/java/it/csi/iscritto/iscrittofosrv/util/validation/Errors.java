package it.csi.iscritto.iscrittofosrv.util.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import it.csi.iscritto.iscrittofosrv.integration.service.validation.ErrorCodeEnum;

public class Errors implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Error> errors;

	public Errors() {
		this.errors = new ArrayList<>();
	}

	public Errors addError(Error error) {
		Validate.notNull(error);
		this.errors.add(error);

		return this;
	}

	public Errors addValidationError(String message) {
		if (StringUtils.isNotBlank(message)) {
			String code;
			String description;
			String path = null;

			StringTokenizer tokenizer = new StringTokenizer(message, "|");
			List<String> tokens = new ArrayList<>();
			while (tokenizer.hasMoreElements()) {
				tokens.add(tokenizer.nextToken());
			}

			switch (tokens.size()) {
				case 2:
					code = tokens.get(0);
					description = tokens.get(1);
					path = null;
					break;
				case 3:
					code = tokens.get(0);
					description = tokens.get(1);
					path = tokens.get(2);
					break;

				default:
					code = ErrorCodeEnum.SYS_001.getCode();
					description = message;
					break;
			}

			Error error = new Error(code, description, path, true, ErrorType.VALIDATION);
			this.errors.add(error);
		}

		return this;
	}

	public Errors merge(Errors errors) {
		if (errors != null && errors.hasErrors()) {
			this.errors.addAll(errors.getAllErrors());
		}

		return this;
	}

	public boolean hasErrors() {
		return this.errors.size() > 0;
	}

	public boolean hasErrors(ErrorType errorType) {
		Validate.notNull(errorType);

		for (Error error : errors) {
			if (errorType.equals(error.getErrorType())) {
				return true;
			}
		}

		return false;
	}

	public boolean hasBlockingErrors() {
		for (Error error : errors) {
			if (error.isBlocking()) {
				return true;
			}
		}

		return false;
	}

	public boolean contains(String code) {
		if (code == null || !this.hasErrors()) {
			return false;
		}

		for (Error error : errors) {
			if (code.equals(error.getCode())) {
				return true;
			}
		}

		return false;
	}

	public int getErrorCount() {
		return this.errors.size();
	}

	public List<Error> getAllErrors() {
		return Collections.unmodifiableList(this.errors);
	}

}
