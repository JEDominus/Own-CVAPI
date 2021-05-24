package com.agilethought.intership.cv.validator;

import static com.agilethought.intership.cv.validator.ValidationUtils.isValidEmail;
import static com.agilethought.intership.cv.validator.ValidationUtils.isValidString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

	@Test
	public void isValidStringSuccesfullyTest() {
		assertEquals(isValidString("a"), true);
	}

	@Test
	public void isValidStringFailedTest() {
		assertEquals(isValidString(null), false);
		assertEquals(isValidString(""), false);
		assertEquals(isValidString("  "), false);
	}

	@Test
	public void isValidEmailSuccesfullyTest() {
		assertEquals(isValidEmail("je.dominus.hatred@gmail.com"), true);
	}

	@Test
	public void isValidEmailFailedTest() {
		assertEquals(isValidEmail(""), false);
		assertEquals(isValidEmail("	"), false);
		assertEquals(isValidEmail("je"), false);
		assertEquals(isValidEmail("@gmail"), false);
		assertEquals(isValidEmail("@gmail.com"), false);
		assertEquals(isValidEmail("@.com"), false);
		assertEquals(isValidEmail("je@.gmail"), false);
		assertEquals(isValidEmail("je@.com"), false);
		assertEquals(isValidEmail(".com"), false);
	}
}
