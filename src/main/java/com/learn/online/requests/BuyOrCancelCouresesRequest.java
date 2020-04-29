package com.learn.online.requests;

import java.util.List;

public class BuyOrCancelCouresesRequest {

	private String studentEmail;
	private List<String> courseKeys;

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public List<String> getCourseKeys() {
		return courseKeys;
	}

	public void setCourseKeys(List<String> courseKeys) {
		this.courseKeys = courseKeys;
	}

}
