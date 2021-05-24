package com.agilethought.intership.cv.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agilethought.intership.cv.dto.NewCVResponse;
import com.agilethought.intership.cv.dto.UpdateCVResponse;
import com.agilethought.intership.cv.dummy.DummyNewCVRequest;
import com.agilethought.intership.cv.dummy.DummyUpdateCVRequest;
import com.agilethought.intership.cv.exception.NotFoundException;
import com.agilethought.intership.cv.model.CV;
import com.agilethought.intership.cv.repository.CVRepository;
import com.agilethought.intership.cv.service.implementation.CVServiceImpl;
import com.agilethought.intership.cv.validator.CVValidator;

@RunWith(SpringJUnit4ClassRunner.class)
public class CVServiceImplTest {

	@Mock
	private DummyNewCVRequest dummyNewCVRequest;

	@Mock
	private DummyUpdateCVRequest dummyUpdateCVRequest;

	@Mock
	private CVRepository cvRepository;

	@Mock
	private CVValidator cvValidator;

	@InjectMocks
	private CVServiceImpl cvServiceImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCvByIdSuccesfullyTest() {
		when((cvRepository).findById(anyString())).thenReturn(Optional.of(new CV()));

		CV spected = cvServiceImpl.getCvById("0");

		assertNotNull(spected);
	}

	@Test
	public void getCvByIdFailedTest() {
		when((cvRepository).findById(anyString())).thenReturn(Optional.empty());

		NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> {
			cvServiceImpl.getCvById("0");
		});

		assertEquals(notFoundException.getMessage(), "User with id 0 not found");
	}

	@Test
	public void createCvSuccesfullyTest() {
		dummyNewCVRequest = new DummyNewCVRequest();
		dummyNewCVRequest.populateDummyNewCVRequest();

		doNothing().when(cvValidator).validate(any());
		when((cvRepository).save(any())).thenReturn(new CV());

		NewCVResponse spected = cvServiceImpl.createCV(dummyNewCVRequest);

		assertNotNull(spected);
	}

	@Test
	public void updateCvByIdSuccesfullyTest() {
		dummyUpdateCVRequest = new DummyUpdateCVRequest();
		dummyUpdateCVRequest.populateDummyUpdateCVRequest();

		when((cvRepository).findById(anyString())).thenReturn(Optional.of(new CV()));
		doNothing().when(cvValidator).validate(any());
		when((cvRepository).save(any())).thenReturn(new CV());

		UpdateCVResponse spected = cvServiceImpl.updateCvById(dummyUpdateCVRequest, "0");

		assertNotNull(spected);
	}

	@Test
	public void updateCvByIdFailedTest() {
		dummyUpdateCVRequest = new DummyUpdateCVRequest();
		dummyUpdateCVRequest.populateDummyUpdateCVRequest();

		when((cvRepository).findById(anyString())).thenReturn(Optional.empty());

		NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> {
			cvServiceImpl.updateCvById(dummyUpdateCVRequest, "0");
		});

		assertEquals(notFoundException.getMessage(), "User with id 0 not found");
	}

	@Test
	public void deleteCvByIdSuccesfullyTest() {
		when((cvRepository).findById(anyString())).thenReturn(Optional.of(new CV()));
		doNothing().when(cvRepository).deleteById(anyString());

		cvServiceImpl.deleteCvById(anyString());

		verify(cvRepository).deleteById(anyString());
	}

	@Test
	public void deleteCvByIdFailedTest() {
		when((cvRepository).findById(anyString())).thenReturn(Optional.empty());

		NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> {
			cvServiceImpl.deleteCvById("0");
		});

		assertEquals(notFoundException.getMessage(), "User with id 0 not found");
	}

}
