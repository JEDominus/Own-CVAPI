package com.agilethought.intership.cv.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.agilethought.intership.cv.dummy.DummyNewCVRequest;
import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.Skills;

public class SkillsValidatorTest {

	public DummyNewCVRequest dummyNewCVRequest;

	@InjectMocks
	public SkillsValidator skillsValidator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dummyNewCVRequest = new DummyNewCVRequest();
		dummyNewCVRequest.populateDummyNewCVRequest();
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheSkillsNameFieldTest() {
		Assertions.assertAll(() -> {
			for (Skills skill : dummyNewCVRequest.getNewCVRequest().getSkills()) {
				skill.setName(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				skillsValidator.validate(dummyNewCVRequest.getNewCVRequest().getSkills());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Skills is required.");
		}, () -> {
			for (Skills skill : dummyNewCVRequest.getNewCVRequest().getSkills()) {
				skill.setName("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				skillsValidator.validate(dummyNewCVRequest.getNewCVRequest().getSkills());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Skills is required.");
		}, () -> {
			for (Skills skill : dummyNewCVRequest.getNewCVRequest().getSkills()) {
				skill.setName("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				skillsValidator.validate(dummyNewCVRequest.getNewCVRequest().getSkills());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Skills is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheSkillsPercentageFieldTest() {
		Assertions.assertAll(() -> {
			for (Skills skill : dummyNewCVRequest.getNewCVRequest().getSkills()) {
				skill.setPercentage(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				skillsValidator.validate(dummyNewCVRequest.getNewCVRequest().getSkills());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Percentage in Skills is required.");
		}, () -> {
			for (Skills skill : dummyNewCVRequest.getNewCVRequest().getSkills()) {
				skill.setPercentage(-1);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				skillsValidator.validate(dummyNewCVRequest.getNewCVRequest().getSkills());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Percentage in Skills has an invalid value. The correct value is an integer number grater or equal than 0 and less or equal than 100");
		}, () -> {
			for (Skills skill : dummyNewCVRequest.getNewCVRequest().getSkills()) {
				skill.setPercentage(101);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				skillsValidator.validate(dummyNewCVRequest.getNewCVRequest().getSkills());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Percentage in Skills has an invalid value. The correct value is an integer number grater or equal than 0 and less or equal than 100");
		});
	}

	@Test
	public void allTheSkillsValidationsWillBeOk() {
		skillsValidator.validate(dummyNewCVRequest.getNewCVRequest().getSkills());
	}

}
