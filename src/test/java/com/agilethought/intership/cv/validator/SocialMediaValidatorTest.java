package com.agilethought.intership.cv.validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.agilethought.intership.cv.dummy.DummyNewCVRequest;
import com.agilethought.intership.cv.exception.BadRequestException;

public class SocialMediaValidatorTest {

	public DummyNewCVRequest dummyNewCVRequest;

	@InjectMocks
	public SocialMediaValidator socialMediaValidator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dummyNewCVRequest = new DummyNewCVRequest();
		dummyNewCVRequest.populateDummyNewCVRequest();
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheSocialMediaFacebookFieldTest() {
		Assertions.assertAll(() -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setFacebook("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Facebook in Social media has an incorrect format. The correct format is an String");
		}, () -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setFacebook("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Facebook in Social media has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheSocialMediaInstagramFieldTest() {
		Assertions.assertAll(() -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setInstagram("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Instagram in Social media has an incorrect format. The correct format is an String");
		}, () -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setInstagram("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Instagram in Social media has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheSocialMediaSnapchatFieldTest() {
		Assertions.assertAll(() -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setSnapchat("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Snapchat in Social media has an incorrect format. The correct format is an String");
		}, () -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setSnapchat("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Snapchat in Social media has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheSocialMediaPinterestFieldTest() {
		Assertions.assertAll(() -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setPinterest("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Pinterest in Social media has an incorrect format. The correct format is an String");
		}, () -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setPinterest("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Pinterest in Social media has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheSocialMediaTwitterFieldTest() {
		Assertions.assertAll(() -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setTwitter("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Twitter in Social media has an incorrect format. The correct format is an String");
		}, () -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setTwitter("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field Twitter in Social media has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheSocialMediaLinkedinFieldTest() {
		Assertions.assertAll(() -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setLinkedin("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field LinkedIn in Social media has an incorrect format. The correct format is an String");
		}, () -> {
			dummyNewCVRequest.getNewCVRequest().getSocialMedia().setLinkedin("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
			});

			Assertions.assertEquals(badRequest.getMessage(),
					"The field LinkedIn in Social media has an incorrect format. The correct format is an String");
		});
	}

	@Test
	public void allTheSocialMediaValidationsWillBeOk() {
		socialMediaValidator.validate(dummyNewCVRequest.getNewCVRequest().getSocialMedia());
	}
}
