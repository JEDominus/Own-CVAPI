package com.agilethought.intership.cv.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agilethought.intership.cv.dto.NewCVRequest;
import com.agilethought.intership.cv.dto.NewCVResponse;
import com.agilethought.intership.cv.dto.UpdateCVRequest;
import com.agilethought.intership.cv.dto.UpdateCVResponse;
import com.agilethought.intership.cv.exception.NotFoundException;
import com.agilethought.intership.cv.model.CV;
import com.agilethought.intership.cv.repository.CVRepository;
import com.agilethought.intership.cv.service.CVService;
import com.agilethought.intership.cv.validator.CVValidator;

@Service
public class CVServiceImpl implements CVService {

	@Autowired
	private CVRepository cvRepository;

	@Autowired
	private CVValidator cvValidator;

	@Override
	public CV getCvById(String id) {
		Optional<CV> cvFound = cvRepository.findById(id);

		if (cvFound.isPresent()) {
			CV cv = cvFound.get();
			return cv;
		} else {
			throw new NotFoundException(String.format("User with id %s not found", id));
		}
	}

	@Override
	public NewCVResponse createCV(NewCVRequest request) {
		CV cv = new CV();
		cv.setFirstName(request.getFirstName());
		cv.setLastName(request.getLastName());
		cv.setJob(request.getJob());
		cv.setCity(request.getCity());
		cv.setCountry(request.getCountry());
		cv.setEmail(request.getEmail());
		cv.setPhoneNumber(request.getPhoneNumber());
		cv.setSkills(request.getSkills());
		cv.setLanguages(request.getLanguages());
		cv.setWorkexperience(request.getWorkexperience());
		cv.setEducation(request.getEducation());
		cv.setSocialMedia(request.getSocialMedia());
		cv.setChallenges(request.getChallenges());
		cv.setConfig(request.getConfig());

		cvValidator.validate(cv);

		CV cvSaved = cvRepository.save(cv);

		return new NewCVResponse(cvSaved.getId());
	}

	@Override
	public UpdateCVResponse updateCvById(UpdateCVRequest request, String id) {
		Optional<CV> cvFound = cvRepository.findById(id);

		if (cvFound.isPresent()) {
			CV updatedCvFields = cvFound.get();
			updatedCvFields.setFirstName(request.getFirstName());
			updatedCvFields.setLastName(request.getLastName());
			updatedCvFields.setJob(request.getJob());
			updatedCvFields.setCity(request.getCity());
			updatedCvFields.setCountry(request.getCountry());
			updatedCvFields.setEmail(request.getEmail());
			updatedCvFields.setPhoneNumber(request.getPhoneNumber());
			updatedCvFields.setSkills(request.getSkills());
			updatedCvFields.setLanguages(request.getLanguages());
			updatedCvFields.setWorkexperience(request.getWorkexperience());
			updatedCvFields.setEducation(request.getEducation());
			updatedCvFields.setSocialMedia(request.getSocialMedia());
			updatedCvFields.setChallenges(request.getChallenges());
			updatedCvFields.setConfig(request.getConfig());

			cvValidator.validate(updatedCvFields);

			CV cvUpdated = cvRepository.save(updatedCvFields);

			return new UpdateCVResponse(cvUpdated);
		} else {
			throw new NotFoundException(String.format("User with id %s not found", id));
		}

	}

	@Override
	public void deleteCvById(String id) {
		Optional<CV> cvFound = cvRepository.findById(id);

		if (cvFound.isPresent()) {
			cvRepository.deleteById(id);
		} else {
			throw new NotFoundException(String.format("User with id %s not found", id));
		}
	}

}
