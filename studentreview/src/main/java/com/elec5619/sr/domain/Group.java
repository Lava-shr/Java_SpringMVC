package com.elec5619.sr.domain;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="group_table")
public class Group implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="unit_group_id")
	private String unitGroupId;

	@ManyToOne
	@JoinColumn(name="course_enrolled_unitcode")
	private CourseEnrolled courseEnrolledGroup;

	@ManyToOne
	@JoinColumn(name="student_username")
	private User userGroup;

	@Column(name="group_limit")
	private String groupLimit;

	@Column(name="group_mini_limit")
	private String groupMiniLimit;

	@Column(name="contract")
	private String contract;

	@Column(name="locked")
	private boolean locked ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnitGroupId() {
		return unitGroupId;
	}

	public void setUnitGroupId(String unitGroupId) {
		this.unitGroupId = unitGroupId;
	}

	public CourseEnrolled getEnrolledUnitCode() {
		return getEnrolledUnitCode();
	}

	public void setEnrolledUnitCode(CourseEnrolled enrolledUnitCode) {
		this.courseEnrolledGroup = enrolledUnitCode;
	}

	public User getStudentUsername() {
		return userGroup;
	}

	public void setStudentUsername(User studentUsername) {
		this.userGroup = studentUsername;
	}

	public String getGroupLimit() {
		return groupLimit;
	}

	public void setGroupLimit(String groupLimit) {
		this.groupLimit = groupLimit;
	}

	public String getGroupMiniLimit() {
		return groupMiniLimit;
	}

	public void setGroupMiniLimit(String groupMiniLimit) {
		this.groupMiniLimit = groupMiniLimit;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public CourseEnrolled getCourseEnrolledGroup() {
		return courseEnrolledGroup;
	}

	public void setCourseEnrolledGroup(CourseEnrolled courseEnrolledGroup) {
		this.courseEnrolledGroup = courseEnrolledGroup;
	}

	public User getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(User userGroup) {
		this.userGroup = userGroup;
	}
	

}