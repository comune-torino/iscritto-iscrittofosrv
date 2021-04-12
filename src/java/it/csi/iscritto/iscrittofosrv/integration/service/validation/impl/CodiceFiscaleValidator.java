package it.csi.iscritto.iscrittofosrv.integration.service.validation.impl;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import it.csi.iscritto.iscrittofosrv.integration.service.validation.ErrorCodeEnum;
import it.csi.iscritto.iscrittofosrv.util.validation.Errors;
import it.csi.iscritto.iscrittofosrv.util.validation.Validator;

public class CodiceFiscaleValidator implements Validator<String> {
	public static final int NUMERIC_LENGTH = 11;
	public static final int ALPHANUMERIC_LENGTH = 16;

	private static final String REGEX_NUMERIC = "\\d+";
	private static final Pattern PATTERN_NUMERIC = Pattern.compile(REGEX_NUMERIC);

	private static final String REGEX_ALPHANUMERIC = "[A-Za-z0-9]+";
	private static final Pattern PATTERN_ALPHANUMERIC = Pattern.compile(REGEX_ALPHANUMERIC);

	@Override
	public void validate(String target, Errors errors) {
		if (StringUtils.isEmpty(target)) {
			errors.addError(ErrorCodeEnum.VAL_CF_001.buildBlockingError());
			return;
		}

		if (!checkLength(target)) {
			errors.addError(ErrorCodeEnum.VAL_CF_002.buildBlockingError());
			return;
		}

		if (isNumericType(target)) {
			if (!checkNumericFormat(target)) {
				errors.addError(ErrorCodeEnum.VAL_CF_003.buildBlockingError());
				return;
			}
		}

		if (isAlphanumericType(target)) {
			if (!checkAlphanumericFormat(target)) {
				errors.addError(ErrorCodeEnum.VAL_CF_004.buildBlockingError());
				return;
			}

			if (!checkDigit(target)) {
				errors.addError(ErrorCodeEnum.VAL_CF_005.buildError());
			}
		}
	}

	private static boolean isNumericType(String cf) {
		return cf.length() == NUMERIC_LENGTH;
	}

	private static boolean isAlphanumericType(String cf) {
		return cf.length() == ALPHANUMERIC_LENGTH;
	}

	private static boolean checkLength(String cf) {
		return isNumericType(cf) || isAlphanumericType(cf);
	}

	private static boolean checkNumericFormat(String cf) {
		if (!PATTERN_NUMERIC.matcher(cf).matches()) {
			return false;
		}

		return true;
	}

	private static boolean checkAlphanumericFormat(String cf) {
		if (!PATTERN_ALPHANUMERIC.matcher(cf).matches()) {
			return false;
		}

		return true;
	}

	private static boolean checkDigit(String cf) {
		int c, i, checkDigit;
		int setdisp[] = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23 };

		String codiceFiscale = cf.toUpperCase();
		checkDigit = 0;

		for (i = 1; i <= 13; i += 2) {
			c = codiceFiscale.charAt(i);
			if (c >= '0' && c <= '9') {
				checkDigit += c - '0';
			}
			else {
				checkDigit += c - 'A';
			}
		}

		for (i = 0; i <= 14; i += 2) {
			c = codiceFiscale.charAt(i);
			if (c >= '0' && c <= '9') {
				c = c - '0' + 'A';
			}
			checkDigit += setdisp[c - 'A'];
		}

		if (checkDigit % 26 + 'A' != codiceFiscale.charAt(15)) {
			return false;
		}

		return true;
	}

}
