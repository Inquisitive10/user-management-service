package com.SSAssignment.onboardify.usermanagementservice.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="team_id")
	private long teamId;
	
	@Column(name="team_name", nullable = false)
	private String teamName;
	
	@Column(name="department", nullable = false)
	private String department;
	
	@OneToMany(mappedBy = "team")
    private List<Users> users;

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
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
	
}
