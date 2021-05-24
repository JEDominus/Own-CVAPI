package com.agilethought.intership.cv.validator;

import static com.agilethought.intership.cv.validator.ValidationUtils.isValidString;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.Education;

@Service
public class EducationValidator {

	private static final String NAME = "Name";
	private static final String CAREER = "Career";
	private static final String FROM = "From";
	private static final String TO = "To";
	private static final String FOREVER = "Forever";
	private static final String DEGREE = "Degree";

	private static final String REQUIRED_FIELD_MESSAGE = "The field %s in Education is required.";
	private static final String INCORRECT_FIELD_MESSAGE = "The field %s in Education has an incorrect format. The correct format is an String";

	public void validate(List<Education> educations) {
		for (Education education : educations) {
			validateName(education.getName());
			validateCareer(education.getCareer());
			validateFrom(education.getFrom());
			validateTo(education.getTo());
			validateCurrent(education.getForever());
			validateDegree(education.getDegree());
		}
	}

	private void validateName(String name) {
		if (!isValidString(name)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, NAME));
		}
	}

	private void validateCareer(String career) {
		if (!isValidString(career)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, CAREER));
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

	private void validateCurrent(Boolean forever) {
		if (forever == null) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, FOREVER));
		}
	}

	private void validateDegree(String degree) {
		if (!isValidString(degree)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, DEGREE));
		}
	}

}
