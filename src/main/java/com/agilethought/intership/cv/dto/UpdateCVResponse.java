package com.agilethought.intership.cv.dto;

import java.util.List;

import com.agilethought.intership.cv.model.CV;
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
public class UpdateCVResponse {

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

	public UpdateCVResponse(CV cv) {
		this.id = cv.getId();
		this.firstName = cv.getFirstName();
		this.lastName = cv.getLastName();
		this.job = cv.getJob();
		this.city = cv.getCity();
		this.country = cv.getCountry();
		this.email = cv.getEmail();
		this.phoneNumber = cv.getPhoneNumber();
		this.skills = cv.getSkills();
		this.languages = cv.getLanguages();
		this.workexperience = cv.getWorkexperience();
		this.education = cv.getEducation();
		this.socialMedia = cv.getSocialMedia();
		this.challenges = cv.getChallenges();
		this.config = cv.getConfig();
	}

}
