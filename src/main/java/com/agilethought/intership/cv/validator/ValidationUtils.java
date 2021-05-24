package com.agilethought.intership.cv.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	public static boolean isValidString(String stringValue) {
		if (stringValue == null || stringValue.isEmpty())
			return false;
		Pattern patternString = Pattern.compile("^\\s+$");

		Matcher matcherString = patternString.matcher(stringValue);

		return !matcherString.find();
	}

	static boolean isValidEmail(String emailValue) {
		Pattern patternEmail = Pattern.compile("^[\\p{L}\\p{N}\\._%+-]+@[\\p{L}\\p{N}\\.\\-]+\\.[\\p{L}]{2,}$");

		Matcher matcherEmail = patternEmail.matcher(emailValue);

		return matcherEmail.find();
	}

}
