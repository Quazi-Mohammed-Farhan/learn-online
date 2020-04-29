package com.learn.online.requests;

public class StudentRequest {

	private String studentKey;

	/**
	 * @return the studentKey
	 */
	public String getStudentKey() {
		return studentKey;
	}

	/**
	 * @param studentKey the studentKey to set
	 */
	public void setStudentKey(String studentKey) {
		this.studentKey = studentKey;
	}

	@Override
	public String toString() {
		return "StudentRequest [studentKey=" + studentKey + "]";
	}

}
