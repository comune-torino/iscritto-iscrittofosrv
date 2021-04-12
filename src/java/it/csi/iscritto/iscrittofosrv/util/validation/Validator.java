package it.csi.iscritto.iscrittofosrv.util.validation;

public interface Validator<T> {

	void validate(T target, Errors errors);

}
