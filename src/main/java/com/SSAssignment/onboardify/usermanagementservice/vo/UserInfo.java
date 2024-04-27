package com.SSAssignment.onboardify.usermanagementservice.vo;

public class UserInfo {

	private String username;
	private Integer accessLevel;
	private String teamName;
	
	
	
	public UserInfo(String username, Integer accessLevel, String teamName) {
		super();
		this.username = username;
		this.accessLevel = accessLevel;
		this.teamName = teamName;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public Integer getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
}
