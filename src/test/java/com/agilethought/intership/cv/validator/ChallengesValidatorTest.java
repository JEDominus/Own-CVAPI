package com.agilethought.intership.cv.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.agilethought.intership.cv.dummy.DummyNewCVRequest;
import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.Challenges;

public class ChallengesValidatorTest {

	public DummyNewCVRequest dummyNewCVRequest;

	@InjectMocks
	public ChallengesValidator challengesValidator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dummyNewCVRequest = new DummyNewCVRequest();
		dummyNewCVRequest.populateDummyNewCVRequest();
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheChallengesNameFieldTest() {
		Assertions.assertAll(() -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setName(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Challenges is required.");
		}, () -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setName("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Challenges is required.");
		}, () -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setName("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Challenges is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheChallengesDateFieldTest() {
		Assertions.assertAll(() -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setDate(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Date in Challenges is required.");
		}, () -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setDate("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Date in Challenges is required.");
		}, () -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setDate("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Date in Challenges is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheChallengesDescriptionFieldTest() {
		Assertions.assertAll(() -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setDescription(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Description in Challenges is required.");
		}, () -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setDescription("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Description in Challenges is required.");
		}, () -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setDescription("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Description in Challenges is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheChallengesURLFieldTest() {
		Assertions.assertAll(() -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setUrl(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field URL in Challenges is required.");
		}, () -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setUrl("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field URL in Challenges is required.");
		}, () -> {
			for (Challenges challenge : dummyNewCVRequest.getNewCVRequest().getChallenges()) {
				challenge.setUrl("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field URL in Challenges is required.");
		});
	}

	@Test
	public void allTheChallengesValidationsWillBeOk() {
		challengesValidator.validate(dummyNewCVRequest.getNewCVRequest().getChallenges());
	}
}
