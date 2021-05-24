package com.agilethought.intership.cv.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.agilethought.intership.cv.dummy.DummyNewCVRequest;
import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.WorkExperience;

public class WorkExperienceTest {

	public DummyNewCVRequest dummyNewCVRequest;

	@InjectMocks
	public WorkExperienceValidator workExperienceValidator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dummyNewCVRequest = new DummyNewCVRequest();
		dummyNewCVRequest.populateDummyNewCVRequest();
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheWorkExperienceTitleFieldTest() {
		Assertions.assertAll(() -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setTitle(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Title in Work experience is required.");
		}, () -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setTitle("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Title in Work experience is required.");
		}, () -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setTitle("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Title in Work experience is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheWorkExperienceCompanyFieldTest() {
		Assertions.assertAll(() -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setCompany(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Company in Work experience is required.");
		}, () -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setCompany("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Company in Work experience is required.");
		}, () -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setCompany("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Company in Work experience is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheWorkExperiencFromFieldTest() {
		Assertions.assertAll(() -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setFrom(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field From in Work experience is required.");
		}, () -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setFrom("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field From in Work experience is required.");
		}, () -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setFrom("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field From in Work experience is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheWorkExperiencToFieldTest() {
		Assertions.assertAll(() -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setTo("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field To in Work experience has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheWorkExperiencCurrentFieldTest() { // a
		Assertions.assertAll(() -> {
			fixTheToField();
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setCurrent(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Current in Work experience is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheWorkExperiencDescriptionFieldTest() {
		Assertions.assertAll(() -> {
			fixTheToField();
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setDescription(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Description in Work experience is required.");
		}, () -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setDescription("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Description in Work experience is required.");
		}, () -> {
			for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
				work.setDescription("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Description in Work experience is required.");
		});
	}

	@Test
	public void allTheWorkExperienceValidationsWillBeOk() {
		fixTheToField();
		workExperienceValidator.validate(dummyNewCVRequest.getNewCVRequest().getWorkexperience());
	}

	public void fixTheToField() {
		for (WorkExperience work : dummyNewCVRequest.getNewCVRequest().getWorkexperience()) {
			work.setTo("2012");
		}
	}
}
