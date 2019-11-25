package com.elec5619.sr.domain;


import java.io.Serializable;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="student_reviews")
public class StudentReview implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="student_username")
	private User userStudentReview;
	//changed re_id to title. think we can delete review and set description on the fly
	@Column(name="title")
	private String title;
	
	@Column(name="rev_points")
	private int rev_points;
	
	@Column(name="rev_count")
	private int rev_count;
	
//	@OneToMany(mappedBy="studentReview", cascade = CascadeType.ALL)
//	Set studentReview = new HashSet();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getStudentUsername() {
		return userStudentReview;
	}

	public void setStudentUsername(User studentUsername) {
		this.userStudentReview = studentUsername;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRev_points() {
		return rev_points;
	}

	public void setRev_points(int rev_points) {
		this.rev_points = rev_points;
	}

	public int getRev_count() {
		return rev_count;
	}

	public void setRev_count(int rev_count) {
		this.rev_count = rev_count;
	}
	
}
