package com.agilethought.intership.cv.validator;

import static com.agilethought.intership.cv.validator.ValidationUtils.isValidString;

import org.springframework.stereotype.Service;

import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.SocialMedia;

@Service
public class SocialMediaValidator {

	private static final String FACEBOOK = "Facebook";
	private static final String INSTAGRAM = "Instagram";
	private static final String SNAPCHAT = "Snapchat";
	private static final String PINTEREST = "Pinterest";
	private static final String TWITTER = "Twitter";
	private static final String LINKEDIN = "LinkedIn";

	private static final String INCORRECT_FIELD_MESSAGE = "The field %s in Social media has an incorrect format. The correct format is an String";

	public void validate(SocialMedia socialMedia) {
		validateFacebook(socialMedia.getFacebook());
		validateInstagram(socialMedia.getInstagram());
		validateSnapchat(socialMedia.getSnapchat());
		validatePinterest(socialMedia.getPinterest());
		validateTwitter(socialMedia.getTwitter());
		validateLinkedin(socialMedia.getLinkedin());
	}

	private void validateFacebook(String facebook) {
		if (facebook != null) {
			if (!isValidString(facebook)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, FACEBOOK));
			}
		}
	}

	private void validateInstagram(String instagram) {
		if (instagram != null) {
			if (!isValidString(instagram)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, INSTAGRAM));
			}
		}
	}

	private void validateSnapchat(String snapchat) {
		if (snapchat != null) {
			if (!isValidString(snapchat)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, SNAPCHAT));
			}
		}
	}

	private void validatePinterest(String pinterest) {
		if (pinterest != null) {
			if (!isValidString(pinterest)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, PINTEREST));
			}
		}
	}

	private void validateTwitter(String twitter) {
		if (twitter != null) {
			if (!isValidString(twitter)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, TWITTER));
			}
		}
	}

	private void validateLinkedin(String linkedin) {
		if (linkedin != null) {
			if (!isValidString(linkedin)) {
				throw new BadRequestException(String.format(INCORRECT_FIELD_MESSAGE, LINKEDIN));
			}
		}
	}

}
