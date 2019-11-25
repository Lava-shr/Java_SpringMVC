package com.elec5619.sr.domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.*;
import javax.persistence.CascadeType;
	


/*
 * Please set the table attribute to lower letter
 * 
 */
	
// POJO CLASS
@Entity
@Table(name="user")
public class User implements Serializable {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="hashPass")
	private String hashPass;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="age")
	private int age;
	
	@Column(name="university")
	private String university;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="biography")
	private String biography;
	
	@Lob
	@Column(name="avatar")
	private byte[] avatar;
	
	
	
//	@OneToMany(mappedBy="userCourseEnrolled", cascade = CascadeType.ALL)
//	Set userCourseEnrolled = new HashSet();

//	@OneToMany(mappedBy="userGroup", cascade = CascadeType.ALL)
//	Set userGroup = new HashSet();
//	
//	@OneToMany(mappedBy="userStudentReview", cascade = CascadeType.ALL)
//	Set userStudentReview = new HashSet();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHashPass() {
		return this.hashPass;
	}

	public void setHashPass(String hashPass) {
		this.hashPass = hashPass;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBiography() {
		return this.biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public byte[] getAvatar() {
		return this.avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	
	
	

	
}
