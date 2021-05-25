package com.agilethought.intership.cv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agilethought.intership.cv.dto.NewCVRequest;
import com.agilethought.intership.cv.dto.NewCVResponse;
import com.agilethought.intership.cv.dto.UpdateCVRequest;
import com.agilethought.intership.cv.dto.UpdateCVResponse;
import com.agilethought.intership.cv.model.CV;
import com.agilethought.intership.cv.service.CVService;

@RestController
@RequestMapping(value = "/cv-api")
public class CVController {

	@Autowired
	private CVService cvService;
	
	@ResponseStatus
	@GetMapping("/person")
	public List<CV> getAllCv(){
		return cvService.getAllCV();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/person/{id}")
	public CV getCvById(@PathVariable String id) {
		return cvService.getCvById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/person", consumes = "application/json", produces = "application/json")
	public NewCVResponse postCV(@RequestBody NewCVRequest request) {
		return cvService.createCV(request);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/person/{id}", consumes = "application/json", produces = "application/json")
	public UpdateCVResponse putCV(@RequestBody UpdateCVRequest request, @PathVariable String id) {

		return cvService.updateCvById(request, id);

	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/person/{id}")
	public void deleteCvById(@PathVariable String id) {
		cvService.deleteCvById(id);
	}

}
