package org.test.beans;

public class StormTrooper {
	private String name;
	private String designation;
	private Long trooperId;
	public StormTrooper(String name, String designation, Long trooperId) {
		super();
		this.name = name;
		this.designation = designation;
		this.trooperId = trooperId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the trooperId
	 */
	public Long getTrooperId() {
		return trooperId;
	}
	/**
	 * @param trooperId the trooperId to set
	 */
	public void setTrooperId(Long trooperId) {
		this.trooperId = trooperId;
	}
	
	
}
