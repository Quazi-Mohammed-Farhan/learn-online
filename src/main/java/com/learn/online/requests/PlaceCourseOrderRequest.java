package com.learn.online.requests;

import java.util.List;

public class PlaceCourseOrderRequest {

	private String studentKey;
	private List<String> courseKeys;

	public String getStudentKey() {
		return studentKey;
	}

	public void setStudentKey(String studentKey) {
		this.studentKey = studentKey;
	}

	public List<String> getCourseKeys() {
		return courseKeys;
	}

	public void setCourseKeys(List<String> courseKeys) {
		this.courseKeys = courseKeys;
	}

}
