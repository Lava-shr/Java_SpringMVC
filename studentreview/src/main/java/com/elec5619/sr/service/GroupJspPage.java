package com.elec5619.sr.service;

import java.util.ArrayList;

public class GroupJspPage {

	String course;
	String group_no;
	String group_limit;
	String contract;
	ArrayList<String> group_member;
	
	
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGroup_no() {
		return group_no;
	}
	public void setGroup_no(String group_no) {
		this.group_no = group_no;
	}
	public String getGroup_limit() {
		return group_limit;
	}
	public void setGroup_limit(String group_limit) {
		this.group_limit = group_limit;
	}
	public ArrayList<String> getGroup_member() {
		return group_member;
	}
	public void setGroup_member(ArrayList<String> group_member) {
		this.group_member = group_member;
	}
	
	
}
