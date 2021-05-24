package com.agilethought.intership.cv.dummy;

import java.util.ArrayList;
import java.util.List;

import com.agilethought.intership.cv.dto.NewCVRequest;
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
public class DummyNewCVRequest extends NewCVRequest {

	public NewCVRequest newCVRequest;
	public Skills skill;
	public Languages language;
	public WorkExperience work;
	public Education educ;
	public Challenges challenge;

	public DummyNewCVRequest() {
		super();
		this.newCVRequest = new NewCVRequest();
		this.skill = new Skills();
		this.language = new Languages();
		this.work = new WorkExperience();
		this.educ = new Education();
		this.challenge = new Challenges();
	}

	public void populateDummyNewCVRequest() {
		settingUpTheCV();
	}

	private void settingUpTheCV() {
		newCVRequest.setFirstName("Javier");
		newCVRequest.setLastName("Mota");
		newCVRequest.setJob("Backen developer");
		newCVRequest.setCity("Colima");
		newCVRequest.setCountry("Colima");
		newCVRequest.setEmail("je.dominus.hatred@gmail.com");
		newCVRequest.setPhoneNumber("3320801954");

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

		List<Skills> localSkillsList = new ArrayList<Skills>();
		localSkillsList.add(skill);
		newCVRequest.setSkills(localSkillsList);
	}

	private void settingUpTheLanguages() {
		language.setName("Spanish");
		language.setPercentage(100);

		List<Languages> localLanguagesList = new ArrayList<Languages>();
		localLanguagesList.add(language);
		newCVRequest.setLanguages(localLanguagesList);
	}

	private void settingUpTheWorkExperience() {
		work.setTitle("Backend developer");
		work.setCompany("AgileThought");
		work.setFrom("Feb 2021");
		work.setTo("");
		work.setCurrent(true);
		work.setDescription("BackEnd using springboot");

		List<WorkExperience> localWorkExperienceList = new ArrayList<WorkExperience>();
		localWorkExperienceList.add(work);
		newCVRequest.setWorkexperience(localWorkExperienceList);
	}

	private void settingUpTheEducation() {
		educ.setName("Unversidad de Colima, Facultad de Telematica");
		educ.setCareer("Ingenieria de Software");
		educ.setFrom("2018");
		educ.setTo("2022");
		educ.setForever(false);
		educ.setDegree("Ingeniero de Software");

		List<Education> localEducationList = new ArrayList<Education>();
		localEducationList.add(educ);
		newCVRequest.setEducation(localEducationList);
	}

	private void settingUpTheSocialMedia() {
		SocialMedia localSocialMedia = new SocialMedia();
		localSocialMedia.setFacebook("https://www.socialMedia.com/");
		localSocialMedia.setInstagram("https://www.socialMedia.com/");
		localSocialMedia.setSnapchat("https://www.socialMedia.com/");
		localSocialMedia.setPinterest("https://www.socialMedia.com/");
		localSocialMedia.setTwitter("https://www.socialMedia.com/");
		localSocialMedia.setLinkedin("https://www.socialMedia.com/");

		newCVRequest.setSocialMedia(localSocialMedia);
	}

	private void settingUpTheChallenges() {
		challenge.setName("cv-api");
		challenge.setDate("Jun 2021");
		challenge.setDescription("An CV api");
		challenge.setUrl("SomeHerokuURL");

		List<Challenges> localChallengesList = new ArrayList<Challenges>();
		localChallengesList.add(challenge);
		newCVRequest.setChallenges(localChallengesList);
	}

	private void settingUpTheConfig() {
		Config localConfig = new Config();
		localConfig.setColor("some-red");
		localConfig.setFontFamily("Times new roman");
		localConfig.setGenericFamily("italic");

		newCVRequest.setConfig(localConfig);
	}
}
