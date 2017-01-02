package org.test.beans;

public class School {
	private String schoolName;

	public School(String name) {
		super();
		this.schoolName = name;
	}
	

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}


	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	
}
