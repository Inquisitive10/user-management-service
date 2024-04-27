package com.SSAssignment.onboardify.usermanagementservice.vo;

public class UserDetails {

	private String username;
	private String password;
	private Integer accessLevel;
	private long teamId;
	public UserDetails(String username, String password, Integer accessLevel, long teamId) {
		super();
		this.username = username;
		this.password = password;
		this.accessLevel = accessLevel;
		this.teamId = teamId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	
	
	
}
