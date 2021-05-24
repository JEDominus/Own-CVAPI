package com.agilethought.intership.cv.dummy;

import java.util.ArrayList;
import java.util.List;

import com.agilethought.intership.cv.dto.UpdateCVRequest;
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
public class DummyUpdateCVRequest extends UpdateCVRequest {

	public String id;
	public UpdateCVRequest updateCVRequest;
	public Skills skill;
	public List<Skills> skills;
	public Languages language;
	public List<Languages> languages;
	public WorkExperience work;
	public List<WorkExperience> workexperience;
	public Education educ;
	public List<Education> education;
	public SocialMedia socialMedia;
	public Challenges challenge;
	public List<Challenges> challenges;
	public Config config;

	public DummyUpdateCVRequest() {
		super();
		this.updateCVRequest = new UpdateCVRequest();
		this.skill = new Skills();
		this.skills = new ArrayList<Skills>();
		this.language = new Languages();
		this.languages = new ArrayList<Languages>();
		this.work = new WorkExperience();
		this.workexperience = new ArrayList<WorkExperience>();
		this.educ = new Education();
		this.education = new ArrayList<Education>();
		this.socialMedia = new SocialMedia();
		this.challenge = new Challenges();
		this.challenges = new ArrayList<Challenges>();
		this.config = new Config();
	}

	public void populateDummyUpdateCVRequest() {
		settingUpTheCV();
	}

	private void settingUpTheCV() {
		updateCVRequest.setId("0");
		updateCVRequest.setFirstName("Javier");
		updateCVRequest.setLastName("Mota");
		updateCVRequest.setJob("Backen developer");
		updateCVRequest.setCity("Colima");
		updateCVRequest.setCountry("Colima");
		updateCVRequest.setEmail("je.dominus.hatred@gmail.com");
		updateCVRequest.setPhoneNumber("3320801954");

		settingUpTheSkills();
		settingUpTheLanguages();
		settingUpTheWorkExperience();
		settingUpTheEducation();
		settingUpTheSocialMedia();
		settingUpTheChallenges();
		settingUpTheConfig();
	}

	private void settingUpTheSkills() {
		skill.setName("Teamwork");
		skill.setPercentage(100);
		skills.add(skill);
		updateCVRequest.setSkills(skills);
	}

	private void settingUpTheLanguages() {
		language.setName("Spanish");
		language.setPercentage(100);
		languages.add(language);
		updateCVRequest.setLanguages(languages);
	}

	private void settingUpTheWorkExperience() {
		work.setTitle("Backend developer");
		work.setCompany("AgileThought");
		work.setFrom("Feb 2021");
		work.setTo("");
		work.setCurrent(true);
		work.setDescription("BackEnd using springboot");
		workexperience.add(work);
		updateCVRequest.setWorkexperience(workexperience);
	}

	private void settingUpTheEducation() {
		educ.setName("Unversidad de Colima, Facultad de Telematica");
		educ.setCareer("Ingenieria de Software");
		educ.setFrom("2018");
		educ.setTo("2022");
		educ.setForever(false);
		educ.setDegree("Ingeniero de Software");
		education.add(educ);
		updateCVRequest.setEducation(education);
	}

	private void settingUpTheSocialMedia() {
		socialMedia.setFacebook("https://www.socialMedia.com/");
		socialMedia.setInstagram("https://www.socialMedia.com/");
		socialMedia.setSnapchat("https://www.socialMedia.com/");
		socialMedia.setPinterest("https://www.socialMedia.com/");
		socialMedia.setTwitter("https://www.socialMedia.com/");
		socialMedia.setLinkedin("https://www.socialMedia.com/");
		updateCVRequest.setSocialMedia(socialMedia);
	}

	private void settingUpTheChallenges() {
		challenge.setName("cv-api");
		challenge.setDate("Jun 2021");
		challenge.setDescription("An CV api");
		challenge.setUrl("SomeHerokuURL");
		challenges.add(challenge);
		updateCVRequest.setChallenges(challenges);
	}

	private void settingUpTheConfig() {
		config.setColor("some-red");
		config.setFontFamily("Times new roman");
		config.setGenericFamily("italic");
		updateCVRequest.setConfig(config);
	}

}
