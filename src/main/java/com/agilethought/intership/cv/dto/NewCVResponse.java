package com.agilethought.intership.cv.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCVResponse {

	private String id;

	public NewCVResponse(String id) {
		this.id = id;
	}

}
