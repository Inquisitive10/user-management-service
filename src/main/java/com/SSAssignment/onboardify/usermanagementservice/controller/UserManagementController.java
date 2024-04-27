package com.SSAssignment.onboardify.usermanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SSAssignment.onboardify.usermanagementservice.dto.Team;
import com.SSAssignment.onboardify.usermanagementservice.service.UserManagementServiceInterface;
import com.SSAssignment.onboardify.usermanagementservice.vo.UserDetails;

@RestController
@RequestMapping("/user-management-service")
public class UserManagementController {
	
	@Autowired
	private UserManagementServiceInterface userManagementServiceInterface;

	@GetMapping("/users/{userId}")
	private ResponseEntity<Object> retrieveUserInfo(@PathVariable long userId) {
		return userManagementServiceInterface.retrieveUserInfoById(userId);
	}
	
	@GetMapping("/authentication/user/{username}")
	private ResponseEntity<Object> retrieveAuthenticatedUserInfo(@PathVariable String username) {
		return userManagementServiceInterface.retrieveUserInfoForAuthentication(username);
	}
	
	
	@PostMapping("/users")
	private ResponseEntity<Object> saveUserInfo(@RequestBody UserDetails userDetails) {
		return userManagementServiceInterface.saveUserInfo(userDetails);
	}
	
	@DeleteMapping("/users/{userId}")
	private ResponseEntity<Object> deleteUserInfo(@PathVariable long userId){
		return userManagementServiceInterface.deleteUserInfo(userId);
	}
	
	@GetMapping("/team/{teamId}")
	private ResponseEntity<Object> retrieveTeamInfo(@PathVariable long teamId) {
		return userManagementServiceInterface.retrieveTeamInfoById(teamId);
	}
	
	@PostMapping("/team")
	private ResponseEntity<Object> saveTeamInfo(@RequestBody Team team) {
		return userManagementServiceInterface.saveTeamInfo(team);
	}
	
	@DeleteMapping("/team/{teamId}")
	private ResponseEntity<Object> deleteTeamInfo(@PathVariable long teamId){
		return userManagementServiceInterface.deleteTeamInfo(teamId);
	}

	
}
