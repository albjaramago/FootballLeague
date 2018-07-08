package com.pulselive.footballleague.exception;


public enum ExceptionMessage {


	/**
	 * HOME_TEAM_NAME_ERROR
	 */
	HOME_TEAM_NAME_ERROR("Home team with no name"),
	
	
	/**
	 * AWAY_TEAM_NAME_ERROR
	 */
	AWAY_TEAM_NAME_ERROR("Away team with no name");

	
	private String value;
	
	private ExceptionMessage(String value) {
		
		this.value = value;
	}
	
	
	public String getValue() {
		
		return this.value;
	}
}
