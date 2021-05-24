package com.agilethought.intership.cv.validator;

import static com.agilethought.intership.cv.validator.ValidationUtils.isValidString;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.Challenges;

@Service
public class ChallengesValidator {

	private static final String NAME = "Name";
	private static final String DATE = "Date";
	private static final String DESCRIPTION = "Description";
	private static final String URL = "URL";

	private static final String REQUIRED_FIELD_MESSAGE = "The field %s in Challenges is required.";

	public void validate(List<Challenges> challenges) {
		for (Challenges challenge : challenges) {
			validateName(challenge.getName());
			validateDate(challenge.getDate());
			validateDescription(challenge.getDescription());
			validateUrl(challenge.getUrl());
		}
	}

	private void validateName(String name) {
		if (!isValidString(name)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, NAME));
		}
	}

	private void validateDate(String date) {
		if (!isValidString(date)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, DATE));
		}
	}

	private void validateDescription(String description) {
		if (!isValidString(description)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, DESCRIPTION));
		}
	}

	private void validateUrl(String url) {
		if (!isValidString(url)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, URL));
		}
	}

}
