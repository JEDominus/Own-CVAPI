package com.agilethought.intership.cv.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Document(collection = "CVs")
public class CV {

	@Id
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
