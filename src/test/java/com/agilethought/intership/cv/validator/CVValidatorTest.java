package com.agilethought.intership.cv.validator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.agilethought.intership.cv.dummy.DummyCV;
import com.agilethought.intership.cv.exception.BadRequestException;

public class CVValidatorTest {

	public DummyCV dummyCV;

	@Mock
	public SkillsValidator skillsValidator;

	@Mock
	public LanguagesValidator languagesValidator;

	@Mock
	public WorkExperienceValidator workExperienceValidator;

	@Mock
	public EducationValidator educationValidator;

	@Mock
	public SocialMediaValidator socialMediaValidator;

	@Mock
	public ChallengesValidator challengesValidator;

	@Mock
	public ConfigValidator configValidator;

	@InjectMocks
	public CVValidator cvValidator;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dummyCV = new DummyCV();
		dummyCV.populateCV();
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheCVFirstNameFieldTest() {
		Assertions.assertAll(() -> {
			fixTheCVFields();
			dummyCV.setFirstName(null);

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field First name in CV is required.");
		}, () -> {
			dummyCV.setFirstName("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field First name in CV is required.");
		}, () -> {
			dummyCV.setFirstName("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field First name in CV is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheCVLastNameFieldTest() {
		Assertions.assertAll(() -> {
			fixTheCVFields();
			dummyCV.setLastName(null);

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Last name in CV is required.");
		}, () -> {
			dummyCV.setLastName("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Last name in CV is required.");
		}, () -> {
			dummyCV.setLastName("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Last name in CV is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheCVJobFieldTest() {
		Assertions.assertAll(() -> {
			fixTheCVFields();
			dummyCV.setJob(null);

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Job in CV is required.");
		}, () -> {
			dummyCV.setJob("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Job in CV is required.");
		}, () -> {
			dummyCV.setJob("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Job in CV is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheCVCityFieldTest() {
		Assertions.assertAll(() -> {
			fixTheCVFields();
			dummyCV.setCity(null);

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field City in CV is required.");
		}, () -> {
			dummyCV.setCity("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field City in CV is required.");
		}, () -> {
			dummyCV.setCity("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field City in CV is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheCVCountryFieldTest() {
		Assertions.assertAll(() -> {
			fixTheCVFields();
			dummyCV.setCountry(null);

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Country in CV is required.");
		}, () -> {
			dummyCV.setCountry("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Country in CV is required.");
		}, () -> {
			dummyCV.setCountry("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Country in CV is required.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheCVEmailFieldTest() {
		Assertions.assertAll(() -> {
			fixTheCVFields();
			dummyCV.setEmail(null);

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV is required.");
		}, () -> {
			dummyCV.setEmail("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV is required.");
		}, () -> {
			dummyCV.setEmail("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV is required.");
		}, () -> {
			dummyCV.setEmail("je");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV has an incorrect format.");
		}, () -> {
			dummyCV.setEmail("@gmail");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV has an incorrect format.");
		}, () -> {
			dummyCV.setEmail("@gmail.com");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV has an incorrect format.");
		}, () -> {
			dummyCV.setEmail("@.com");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV has an incorrect format.");
		}, () -> {
			dummyCV.setEmail("je@.gmail");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV has an incorrect format.");
		}, () -> {
			dummyCV.setEmail("je@.com");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV has an incorrect format.");
		}, () -> {
			dummyCV.setEmail(".com");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Email in CV has an incorrect format.");
		});
	}

	@Test
	public void itShouldThrowAnErrorMessageInTheCVPhoneNumberFieldTest() {
		Assertions.assertAll(() -> {
			fixTheCVFields();
			dummyCV.setPhoneNumber(null);

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Phone number in CV is required.");
		}, () -> {
			dummyCV.setPhoneNumber("");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Phone number in CV is required.");
		}, () -> {
			dummyCV.setPhoneNumber("   ");

			BadRequestException badRequest = Assertions.assertThrows(BadRequestException.class, () -> {
				cvValidator.validate(dummyCV);
			});

			Assertions.assertEquals(badRequest.getMessage(), "The field Phone number in CV is required.");
		});
	}

	@Test
	public void allTheCVValidationsWillBeOk() {
		fixTheCVFields();
		doNothing().when(skillsValidator).validate(anyList());
		doNothing().when(educationValidator).validate(anyList());
		doNothing().when(workExperienceValidator).validate(anyList());
		doNothing().when(languagesValidator).validate(anyList());
		doNothing().when(challengesValidator).validate(anyList());
		doNothing().when(configValidator).validate(any());
		doNothing().when(socialMediaValidator).validate(any());
		cvValidator.validate(dummyCV);
	}

	public void fixTheCVFields() {
		dummyCV.setId("0");
		dummyCV.setFirstName("Javier");
		dummyCV.setLastName("Mota");
		dummyCV.setJob("Backen developer");
		dummyCV.setCity("Colima");
		dummyCV.setCountry("Colima");
		dummyCV.setEmail("je.dominus.hatred@gmail.com");
		dummyCV.setPhoneNumber("3320801954");
	}
}
