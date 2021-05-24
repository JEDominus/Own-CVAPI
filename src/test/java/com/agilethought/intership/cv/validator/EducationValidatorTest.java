package com.agilethought.intership.cv.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.agilethought.intership.cv.dummy.DummyNewCVRequest;
import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.Education;

public class EducationValidatorTest {

	public DummyNewCVRequest dummyNewCVRequest;

	@InjectMocks
	public EducationValidator educationValidator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dummyNewCVRequest = new DummyNewCVRequest();
		dummyNewCVRequest.populateDummyNewCVRequest();
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheEducationNameFieldTest() {
		Assertions.assertAll(() -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setName(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Education is required.");
		}, () -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setName("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Education is required.");
		}, () -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setName("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Education is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheEducationCareerFieldTest() {
		Assertions.assertAll(() -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setCareer(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Career in Education is required.");
		}, () -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setCareer("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Career in Education is required.");
		}, () -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setCareer("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Career in Education is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheEducationFromFieldTest() {
		Assertions.assertAll(() -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setFrom(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field From in Education is required.");
		}, () -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setFrom("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field From in Education is required.");
		}, () -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setFrom("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field From in Education is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheEducationToFieldTest() {
		Assertions.assertAll(() -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setTo("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field To in Education has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheEducationForeverFieldTest() {
		Assertions.assertAll(() -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setForever(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Forever in Education is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheDegreeToFieldTest() {
		Assertions.assertAll(() -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setDegree(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Degree in Education is required.");
		}, () -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setDegree("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Degree in Education is required.");
		}, () -> {
			for (Education educ : dummyNewCVRequest.getNewCVRequest().getEducation()) {
				educ.setDegree("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Degree in Education is required.");
		});
	}

	@Test
	public void allTheEducationValidationsWillBeOk() {
		educationValidator.validate(dummyNewCVRequest.getNewCVRequest().getEducation());
	}
}
