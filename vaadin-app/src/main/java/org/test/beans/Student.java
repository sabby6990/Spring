package org.test.beans;

public class Student extends School {

	private School school;

	public Student(String schoolName) {
		super(schoolName);
	}

	/**
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * @param school
	 *            the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String show() {
		return new String("student name is " + this.name + " and  belongs to school : " + super.getSchoolName());
	}
}
