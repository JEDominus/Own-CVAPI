package com.agilethought.intership.cv.service;

import java.util.List;

import com.agilethought.intership.cv.dto.NewCVRequest;
import com.agilethought.intership.cv.dto.NewCVResponse;
import com.agilethought.intership.cv.dto.UpdateCVRequest;
import com.agilethought.intership.cv.dto.UpdateCVResponse;
import com.agilethought.intership.cv.model.CV;

public interface CVService {
	
	public List<CV> getAllCV();

	public CV getCvById(String id);

	public NewCVResponse createCV(NewCVRequest request);

	public UpdateCVResponse updateCvById(UpdateCVRequest request, String id);

	public void deleteCvById(String id);

}
