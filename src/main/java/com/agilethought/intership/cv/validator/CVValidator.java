package com.agilethought.intership.cv.validator;

import static com.agilethought.intership.cv.validator.ValidationUtils.isValidEmail;
import static com.agilethought.intership.cv.validator.ValidationUtils.isValidString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.CV;

@Service
public class CVValidator {

	private static final String FIRST_NAME = "First name";
	private static final String LAST_NAME = "Last name";
	private static final String JOB = "Job";
	private static final String CITY = "City";
	private static final String COUNTRY = "Country";
	private static final String EMAIL = "Email";
	private static final String PHONE_NUMBER = "Phone number";

	private static final String REQUIRED_FIELD_MESSAGE = "The field %s in CV is required.";
	private static final String INCORRECT_FIELD_MESSAGE = "The field %s in CV has an incorrect format.";

	@Autowired
	private SkillsValidator skillsValidator;

	@Autowired
	private LanguagesValidator languagesValidator;

	@Autowired
	private WorkExperienceValidator workExperienceValidator;

	@Autowired
	private EducationValidator educationValidator;

	@Autowired
	private SocialMediaValidator socialMediaValidator;

	@Autowired
	private ChallengesValidator challengesValidator;

	@Autowired
	private ConfigValidator configValidator;

	public void validate(CV request) {
		validateFirstName(request.getFirstName());
		validateLastName(request.getLastName());
		validateJob(request.getJob());
		validateCity(request.getCity());
		validateCountry(request.getCountry());
		validateEmail(request.getEmail());
		validatePhoneNumber(request.getPhoneNumber());

		skillsValidator.validate(request.getSkills());
		languagesValidator.validate(request.getLanguages());
		workExperienceValidator.validate(request.getWorkexperience());
		educationValidator.validate(request.getEducation());
		socialMediaValidator.validate(request.getSocialMedia());
		challengesValidator.validate(request.getChallenges());
		configValidator.validate(request.getConfig());
	}

	private void validateFirstName(String firstName) {
		if (!isValidString(firstName)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, FIRST_NAME));
		}
	}

	private void validateLastName(String lastName) {
		if (!isValidString(lastName)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, LAST_NAME));
		}
	}

	private void validateJob(String job) {
		if (!isValidString(job)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, JOB));
		}
	}

	private void validateCity(String city) {
		if (!isValidString(city)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, CITY));
		}
	}

	private void validateCountry(String country) {
		if (!isValidString(country)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, COUNTRY));
		}
	}

	private void validateEmail(String email) {
		if (!isValidString(email)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, EMAIL));
		} else if (!isValidEmail(email)) {
			throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, EMAIL));
		}
	}

	private void validatePhoneNumber(String phoneNumber) {
		if (!isValidString(phoneNumber)) {
			throw new BadRequestException(String.format(REQUIRED_FIELD_MESSAGE, PHONE_NUMBER));
		}
	}

}
