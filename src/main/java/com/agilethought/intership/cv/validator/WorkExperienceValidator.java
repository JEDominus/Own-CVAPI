package com.agilethought.intership.cv.validator;

import static com.agilethought.intership.cv.validator.ValidationUtils.isValidString;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.WorkExperience;

@Service
public class WorkExperienceValidator {

	private static final String TITLE = "Title";
	private static final String COMPANY = "Company";
	private static final String FROM = "From";
	private static final String TO = "To";
	private static final String CURRENT = "Current";
	private static final String DESCRIPTION = "Description";

	private static final String REQUIRED_FIELD_MESSAGE = "The field %s in Work experience is required.";
	private static final String INCORRECT_FIELD_MESSAGE = "The field %s in Work experience has an incorrect format. The correct format is an String";

	public void validate(List<WorkExperience> workExperience) {
		for (WorkExperience work : workExperience) {
			validateTitle(work.getTitle());
			validateCompany(work.getCompany());
			validateFrom(work.getFrom());
			validateTo(work.getTo());
			validateCurrent(work.getCurrent());
			validateDescription(work.getDescription());
		}
	}

	private void validateTitle(String title) {
		if (!isValidString(title)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, TITLE));
		}
	}

	private void validateCompany(String company) {
		if (!isValidString(company)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, COMPANY));
		}
	}

	private void validateFrom(String from) {
		if (!isValidString(from)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, FROM));
		}
	}

	private void validateTo(String to) {
		if (to != null && to != "") {
			if (!isValidString(to)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, TO));
			}
		}
	}

	private void validateCurrent(Boolean current) {
		if (current == null) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, CURRENT));
		}
	}

	private void validateDescription(String description) {
		if (!isValidString(description)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, DESCRIPTION));
		}
	}

}
