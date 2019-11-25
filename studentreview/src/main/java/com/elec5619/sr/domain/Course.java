package com.elec5619.sr.domain;

import java.io.Serializable;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="course")
public class Course implements Serializable {
	
	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
//	@OneToMany(mappedBy="unitCodeCourse", cascade = CascadeType.ALL)
//	Set unitCodeCourse = new HashSet();
	
	public String getCode() {
		return this.code;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String des) {
		this.description = des;
	}
	
}
