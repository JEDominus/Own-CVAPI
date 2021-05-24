package com.agilethought.intership.cv.validator;

import static com.agilethought.intership.cv.validator.ValidationUtils.isValidString;

import org.springframework.stereotype.Service;

import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.Config;

@Service
public class ConfigValidator {

	private static final String COLOR = "Color";
	private static final String FONT_FAMILY = "Font family";
	private static final String GENERIC_FAMILY = "Generic family";

	private static final String INCORRECT_FIELD_MESSAGE = "The field %s in Config has an incorrect format. The correct format is an String";

	public void validate(Config config) {
		validateColor(config.getColor());
		validateFontFamily(config.getFontFamily());
		validateGenericFamily(config.getGenericFamily());
	}

	private void validateColor(String color) {
		if (color != null) {
			if (!isValidString(color)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, COLOR));
			}
		}
	}

	private void validateFontFamily(String fontFamily) {
		if (fontFamily != null) {
			if (!isValidString(fontFamily)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, FONT_FAMILY));
			}
		}
	}

	private void validateGenericFamily(String genericFamily) {
		if (genericFamily != null) {
			if (!isValidString(genericFamily)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, GENERIC_FAMILY));
			}
		}
	}

}
