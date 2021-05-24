package com.agilethought.intership.cv.validator;

import static com.agilethought.intership.cv.validator.ValidationUtils.isValidString;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.Languages;

@Service
public class LanguagesValidator {

	private static final String NAME = "Name";
	private static final String PERCENTAGE = "Percentage";

	private static final String REQUIRED_FIELD_MESSAGE = "The field %s in Languages is required.";
	private static final String INCORRECT_FIELD_MESSAGE = "The field %s in Language has an invalid value. The correct value is an integer number grater or equal than 0 and less or equal than 100";

	public void validate(List<Languages> languages) {
		for (Languages language : languages) {
			validateName(language.getName());
			validatePercentage(language.getPercentage());
		}
	}

	private void validateName(String name) {
		if (!isValidString(name)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, NAME));
		}
	}

	private void validatePercentage(Integer percentage) {
		if (percentage == null) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, PERCENTAGE));
		} else if (percentage < 0 || percentage > 100) {
			throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, PERCENTAGE));
		}
	}

}
