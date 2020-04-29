package com.learn.online.dtos;

import java.time.LocalDate;
import java.util.List;


public class StudentDto {
	
	private Long studentId;
	private String studentKey;
	private String firstName;
	private String lastName;
	private String email;
	private String encryptedPassword;
	private String phone;
	private String country;
	private String state;
	private List<CourseOrderDto> courseOrders;
	private boolean active;
	private LocalDate creationtDate;
	private LocalDate lastUpdateDate;
	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
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
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the encryptedPassword
	 */
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	/**
	 * @param encryptedPassword the encryptedPassword to set
	 */
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the courseOrders
	 */
	public List<CourseOrderDto> getCourseOrders() {
		return courseOrders;
	}
	/**
	 * @param courseOrders the courseOrders to set
	 */
	public void setCourseOrders(List<CourseOrderDto> courseOrders) {
		this.courseOrders = courseOrders;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the creationtDate
	 */
	public LocalDate getCreationtDate() {
		return creationtDate;
	}
	/**
	 * @param creationtDate the creationtDate to set
	 */
	public void setCreationtDate(LocalDate creationtDate) {
		this.creationtDate = creationtDate;
	}
	/**
	 * @return the lastUpdateDate
	 */
	public LocalDate getLastUpdateDate() {
		return lastUpdateDate;
	}
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(LocalDate lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDto other = (StudentDto) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentKey=" + studentKey + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", encryptedPassword=" + encryptedPassword
				+ ", phone=" + phone + ", country=" + country + ", state=" + state + ", courseOrders=" + courseOrders
				+ ", active=" + active + ", creationtDate=" + creationtDate + ", lastUpdateDate=" + lastUpdateDate
				+ "]";
	}
	
	
	
}
