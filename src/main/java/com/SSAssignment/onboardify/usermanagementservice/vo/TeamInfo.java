package com.SSAssignment.onboardify.usermanagementservice.vo;

public class TeamInfo {

	private String teamName;
	private String department;
	private String privilegedUser;
	
	public TeamInfo(String teamName, String department, String privilegedUser) {
		super();
		this.teamName = teamName;
		this.department = department;
		this.privilegedUser = privilegedUser;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPrivilegedUser() {
		return privilegedUser;
	}

	public void setPrivilegedUser(String privilegedUser) {
		this.privilegedUser = privilegedUser;
	}
	
	
}
