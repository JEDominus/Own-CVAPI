package com.agilethought.intership.cv.dto;

import java.util.List;

import com.agilethought.intership.cv.model.Challenges;
import com.agilethought.intership.cv.model.Config;
import com.agilethought.intership.cv.model.Education;
import com.agilethought.intership.cv.model.Languages;
import com.agilethought.intership.cv.model.Skills;
import com.agilethought.intership.cv.model.SocialMedia;
import com.agilethought.intership.cv.model.WorkExperience;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCVRequest {

	private String id;
	private String firstName;
	private String lastName;
	private String job;
	private String city;
	private String country;
	private String email;
	private String phoneNumber;
	private List<Skills> skills;
	private List<Languages> languages;
	private List<WorkExperience> workexperience;
	private List<Education> education;
	private SocialMedia socialMedia;
	private List<Challenges> challenges;
	private Config config;

}
