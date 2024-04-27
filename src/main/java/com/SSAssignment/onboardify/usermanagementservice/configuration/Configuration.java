package com.SSAssignment.onboardify.usermanagementservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user-service")
public class Configuration {
	private String username;
	private Integer accessLevel;
	private Integer accessLevelRoot;
	private Integer accessLevelPrevilegedAdmin;
	private Integer accessLevelAdmin;
	private Integer accessLevelUser;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}
	public Integer getAccessLevelRoot() {
		return accessLevelRoot;
	}
	public void setAccessLevelRoot(Integer accessLevelRoot) {
		this.accessLevelRoot = accessLevelRoot;
	}
	public Integer getAccessLevelPrevilegedAdmin() {
		return accessLevelPrevilegedAdmin;
	}
	public void setAccessLevelPrevilegedAdmin(Integer accessLevelPrevilegedAdmin) {
		this.accessLevelPrevilegedAdmin = accessLevelPrevilegedAdmin;
	}
	public Integer getAccessLevelAdmin() {
		return accessLevelAdmin;
	}
	public void setAccessLevelAdmin(Integer accessLevelAdmin) {
		this.accessLevelAdmin = accessLevelAdmin;
	}
	public Integer getAccessLevelUser() {
		return accessLevelUser;
	}
	public void setAccessLevelUser(Integer accessLevelUser) {
		this.accessLevelUser = accessLevelUser;
	}
	
	

}
