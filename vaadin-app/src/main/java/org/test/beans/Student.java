package org.test.beans;

public class Student {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	public void show(){
		System.out.println("Hello "+this.name);
	}
}
