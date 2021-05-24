package com.agilethought.intership.cv.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.agilethought.intership.cv.dto.NewCVRequest;
import com.agilethought.intership.cv.dto.NewCVResponse;
import com.agilethought.intership.cv.dto.UpdateCVRequest;
import com.agilethought.intership.cv.dto.UpdateCVResponse;
import com.agilethought.intership.cv.model.CV;
import com.agilethought.intership.cv.service.CVService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CVController.class)
public class CVControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CVService cvService;

	private static final String REQUEST_MAPPING = "/cv-api";

	@Test
	public void getCvByIdTest() throws Exception {
		String getMapping = "/person/0";

		when((cvService).getCvById(anyString())).thenReturn(new CV());

		mockMvc.perform(get(REQUEST_MAPPING + getMapping).contentType(APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void postCVTest() throws Exception {
		String postMapping = "/person";

		when((cvService).createCV(any(NewCVRequest.class))).thenReturn(new NewCVResponse(anyString()));

		mockMvc.perform(post(REQUEST_MAPPING + postMapping).content("{}").contentType(APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void updateCvByIdTest() throws Exception {
		String putMapping = "/person/0";

		when((cvService).updateCvById(any(UpdateCVRequest.class), anyString()))
				.thenReturn(new UpdateCVResponse(new CV()));

		mockMvc.perform(put(REQUEST_MAPPING + putMapping).content("{}").contentType(APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void deleteCvByIdTest() throws Exception {
		String deleteMapping = "/person/0";

		doNothing().when(cvService).deleteCvById(anyString());

		mockMvc.perform(delete(REQUEST_MAPPING + deleteMapping).contentType(APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}
