package com.SSAssignment.onboardify.usermanagementservice.service;

import org.springframework.http.ResponseEntity;

import com.SSAssignment.onboardify.usermanagementservice.dto.Team;
import com.SSAssignment.onboardify.usermanagementservice.vo.UserDetails;

public interface UserManagementServiceInterface {
	
	public ResponseEntity<Object> retrieveUserInfoById(long userId);
	
	public ResponseEntity<Object> saveUserInfo(UserDetails userDetails);
	
	public ResponseEntity<Object> deleteUserInfo(long userId);
	
	public ResponseEntity<Object> retrieveTeamInfoById(long teamId);
	
	public ResponseEntity<Object> saveTeamInfo(Team team);
	
	public ResponseEntity<Object> deleteTeamInfo(long teamId);

	public ResponseEntity<Object> retrieveUserInfoForAuthentication(String username);

}
