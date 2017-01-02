package org.test.beans;

public class DarkSide {
	private String leaderName;
	private StormTrooper trooper;

	public DarkSide(String leaderName, StormTrooper trooper) {
		super();
		this.leaderName = leaderName;
		this.trooper = trooper;
	}

	/**
	 * @return the leaderName
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * @return the trooper
	 */
	public StormTrooper getTrooper() {
		return trooper;
	}

	/**
	 * @param leaderName the leaderName to set
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	/**
	 * @param trooper the trooper to set
	 */
	public void setTrooper(StormTrooper trooper) {
		this.trooper = trooper;
	}

	
}
