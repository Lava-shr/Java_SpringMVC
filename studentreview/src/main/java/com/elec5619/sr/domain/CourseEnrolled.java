package com.elec5619.sr.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course_enrolled")
public class CourseEnrolled implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="unit_code")
	private Course unitCodeCourse;

	@ManyToOne
	@JoinColumn(name="student_username")
	private User userCourseEnrolled;

	@Column(name="enrolled_status")
	private String enrolledStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getUnitCodeCourse() {
		return unitCodeCourse;
	}

	public void setUnitCodeCourse(Course unitCodeCourse) {
		this.unitCodeCourse = unitCodeCourse;
	}

	public User getUserCourseEnrolled() {
		return userCourseEnrolled;
	}

	public void setUserCourseEnrolled(User userCourseEnrolled) {
		this.userCourseEnrolled = userCourseEnrolled;
	}

	public String getEnrolledStatus() {
		return enrolledStatus;
	}

	public void setEnrolledStatus(String enrolledStatus) {
		this.enrolledStatus = enrolledStatus;
	}
	
//	@OneToMany(mappedBy="courseEnrolledGroup", cascade = CascadeType.ALL)
//	Set courseEnrolledGroup = new HashSet();


	
}
