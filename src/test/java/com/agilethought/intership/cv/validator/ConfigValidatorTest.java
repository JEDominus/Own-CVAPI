package com.agilethought.intership.cv.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.agilethought.intership.cv.dummy.DummyNewCVRequest;
import com.agilethought.intership.cv.exception.BadRequestException;

public class ConfigValidatorTest {

	public DummyNewCVRequest dummyNewCVRequest;

	@InjectMocks
	public ConfigValidator configValidator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dummyNewCVRequest = new DummyNewCVRequest();
		dummyNewCVRequest.populateDummyNewCVRequest();
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheConfigColorFieldTest() {
		Assertions.assertAll(() -> {
			dummyNewCVRequest.getNewCVRequest().getConfig().setColor("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				configValidator.validate(dummyNewCVRequest.getNewCVRequest().getConfig());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Color in Config has an incorrect format. The correct format is an String");
		}, () -> {
			dummyNewCVRequest.getNewCVRequest().getConfig().setColor("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				configValidator.validate(dummyNewCVRequest.getNewCVRequest().getConfig());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Color in Config has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheConfigFontFamilyFieldTest() {
		Assertions.assertAll(() -> {
			dummyNewCVRequest.getNewCVRequest().getConfig().setFontFamily("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				configValidator.validate(dummyNewCVRequest.getNewCVRequest().getConfig());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Font family in Config has an incorrect format. The correct format is an String");
		}, () -> {
			dummyNewCVRequest.getNewCVRequest().getConfig().setFontFamily("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				configValidator.validate(dummyNewCVRequest.getNewCVRequest().getConfig());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Font family in Config has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheConfigGenericFamilyFieldTest() {
		Assertions.assertAll(() -> {
			dummyNewCVRequest.getNewCVRequest().getConfig().setGenericFamily("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				configValidator.validate(dummyNewCVRequest.getNewCVRequest().getConfig());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Generic family in Config has an incorrect format. The correct format is an String");
		}, () -> {
			dummyNewCVRequest.getNewCVRequest().getConfig().setGenericFamily("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				configValidator.validate(dummyNewCVRequest.getNewCVRequest().getConfig());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Generic family in Config has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void allTheConfigValidationsWillBeOk() {
		configValidator.validate(dummyNewCVRequest.getNewCVRequest().getConfig());
	}
}
