package com.SSAssignment.onboardify.usermanagementservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;
	
	@Column(name="username", nullable = false)
	private String username;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="access_level", nullable = false)
	private int accessLevel;
	
	@ManyToOne
    @JoinColumn(name = "team_id")
	private Team team;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
