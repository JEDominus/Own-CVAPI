package com.agilethought.intership.cv.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.agilethought.intership.cv.dummy.DummyNewCVRequest;
import com.agilethought.intership.cv.exception.BadRequestException;
import com.agilethought.intership.cv.model.Languages;

public class LanguagesValidatorTest {

	public DummyNewCVRequest dummyNewCVRequest;

	@InjectMocks
	public LanguagesValidator languagesValidator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dummyNewCVRequest = new DummyNewCVRequest();
		dummyNewCVRequest.populateDummyNewCVRequest();
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheLanguagesNameFieldTest() {
		Assertions.assertAll(() -> {
			for (Languages language : dummyNewCVRequest.getNewCVRequest().getLanguages()) {
				language.setName(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				languagesValidator.validate(dummyNewCVRequest.getNewCVRequest().getLanguages());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Languages is required.");
		}, () -> {
			for (Languages language : dummyNewCVRequest.getNewCVRequest().getLanguages()) {
				language.setName("");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				languagesValidator.validate(dummyNewCVRequest.getNewCVRequest().getLanguages());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Languages is required.");
		}, () -> {
			for (Languages language : dummyNewCVRequest.getNewCVRequest().getLanguages()) {
				language.setName("   ");
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				languagesValidator.validate(dummyNewCVRequest.getNewCVRequest().getLanguages());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Name in Languages is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheLanguagesPercentageFieldTest() {
		Assertions.assertAll(() -> {
			for (Languages language : dummyNewCVRequest.getNewCVRequest().getLanguages()) {
				language.setPercentage(null);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				languagesValidator.validate(dummyNewCVRequest.getNewCVRequest().getLanguages());
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Percentage in Languages is required.");
		}, () -> {
			for (Languages language : dummyNewCVRequest.getNewCVRequest().getLanguages()) {
				language.setPercentage(-1);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				languagesValidator.validate(dummyNewCVRequest.getNewCVRequest().getLanguages());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Percentage in Language has an invalid value. The correct value is an integer number grater or equal than 0 and less or equal than 100");
		}, () -> {
			for (Languages language : dummyNewCVRequest.getNewCVRequest().getLanguages()) {
				language.setPercentage(101);
			}

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				languagesValidator.validate(dummyNewCVRequest.getNewCVRequest().getLanguages());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Percentage in Language has an invalid value. The correct value is an integer number grater or equal than 0 and less or equal than 100");
		});
	}

	@Test
	public void allTheLanguagesValidationWillBeOk() {
		languagesValidator.validate(dummyNewCVRequest.getNewCVRequest().getLanguages());
	}

}
