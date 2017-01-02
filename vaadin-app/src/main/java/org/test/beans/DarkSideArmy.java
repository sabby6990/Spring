package org.test.beans;

import java.util.List;

public class DarkSideArmy {
	private String leaderName;
	private List<StormTrooper> army;

	public DarkSideArmy(String leaderName, List<StormTrooper> army) {
		super();
		this.leaderName = leaderName;
		this.army = army;
	}

	/**
	 * @return the leaderName
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * @return the army
	 */
	public List<StormTrooper> getArmy() {
		return army;
	}

}
