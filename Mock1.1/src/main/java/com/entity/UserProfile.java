package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	@Id
	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASS_WORD")
	private String passWord;

	@Column(name = "CREATED_TIME")
	private String createdTime;

	@Column(name = "LAST_ACCESS")
	private String lastAccess;

	@ManyToOne
	@JoinColumn(name = "ROLE")
	private Role role;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "SKY")
	private String sky;

	@Column(name = "FACEBOOK")
	private String facebook;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EDUCATION")
	private String education;

	@Column(name = "UNIVERSITY")
	private String university;

	@Column(name = "MAJOR")
	private String major;

	@Column(name = "GRADUATED_YEAR")
	private int graduatedYear;

	@Column(name = "SKILLS")
	private String skills;

	@Column(name = "EXPERIENCE")
	private String experience;

	@Column(name = "IMAGE_URL")
	private String imageUrl;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSky() {
		return sky;
	}

	public void setSky(String sky) {
		this.sky = sky;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGraduatedYear() {
		return graduatedYear;
	}

	public void setGraduatedYear(int graduatedYear) {
		this.graduatedYear = graduatedYear;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String passWord, String createdTime, String lastAccess, Role role, String fullName,
			String dob, String email, String mobile, String sky, String facebook, String address, String education,
			String university, String major, int graduatedYear, String skills, String experience, String imageUrl) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.createdTime = createdTime;
		this.lastAccess = lastAccess;
		this.role = role;
		this.fullName = fullName;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.sky = sky;
		this.facebook = facebook;
		this.address = address;
		this.education = education;
		this.university = university;
		this.major = major;
		this.graduatedYear = graduatedYear;
		this.skills = skills;
		this.experience = experience;
		this.imageUrl = imageUrl;
	}

}
