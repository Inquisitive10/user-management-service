package com.SSAssignment.onboardify.usermanagementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SSAssignment.onboardify.usermanagementservice.Repository.TeamRepository;
import com.SSAssignment.onboardify.usermanagementservice.Repository.UsersRepository;
import com.SSAssignment.onboardify.usermanagementservice.configuration.Configuration;
import com.SSAssignment.onboardify.usermanagementservice.dto.Team;
import com.SSAssignment.onboardify.usermanagementservice.dto.Users;
import com.SSAssignment.onboardify.usermanagementservice.vo.TeamInfo;
import com.SSAssignment.onboardify.usermanagementservice.vo.UserDetails;
import com.SSAssignment.onboardify.usermanagementservice.vo.UserInfo;

@Service
public class UserManagementServiceImpl implements UserManagementServiceInterface{
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private Configuration configuration;
	
	@Override
	public ResponseEntity<Object> retrieveUserInfoById(long userId) {
		Users user = null;
		try {
			user = userRepository.findByUserId(userId);
		} catch(Exception ex) {}
		if(user!=null)
			return ResponseEntity.status(HttpStatus.OK)
				.body(new UserInfo(user.getUsername(), user.getAccessLevel(), user.getTeam().getTeamName()));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("No user with Id: " + userId);
	}
	
	@Override
	public ResponseEntity<Object> retrieveUserInfoForAuthentication(String userName) {
		Users user = null;
		try {
			user = userRepository.findByUsername(userName);
		} catch(Exception ex) {}
		if(user!=null)
			return ResponseEntity.status(HttpStatus.OK)
				.body(user);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("No user with username: " + userName);
	}
	
	@Override
	public ResponseEntity<Object> saveUserInfo(UserDetails userDetails) {
		Users user = null;
		try {
			user = userRepository.findByUsername(userDetails.getUsername());
		} catch(Exception ex) {}
		if(user!=null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("User " + userDetails.getUsername() +" already exists");
		}
		if(!(userDetails.getAccessLevel()==configuration.getAccessLevelPrevilegedAdmin() || userDetails.getAccessLevel()==configuration.getAccessLevelAdmin() || userDetails.getAccessLevel()==configuration.getAccessLevelUser())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Provide proper accessLevel as follows \n" + 
							"Access level for normal user = " + configuration.getAccessLevelUser() + "\n" +
							"Access level for admin user = " + configuration.getAccessLevelAdmin() + "\n" +
							"Access level for previleged admin user = " + configuration.getAccessLevelPrevilegedAdmin() + "\n"
						);
		}
		if(userDetails.getPassword().length()<8) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Please provide a strong password with atleast 8 characters");
		}
		Team team = teamRepository.findByTeamId(userDetails.getTeamId());
		if(team==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("No team with Id: " + userDetails.getTeamId());
		}
		Users userToAdd = new Users();
		userToAdd.setAccessLevel(userDetails.getAccessLevel());
		userToAdd.setTeam(team);
		userToAdd.setPassword(userDetails.getPassword());
		userToAdd.setUsername(userDetails.getUsername());
		try {
			userRepository.save(userToAdd);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Unable to save user. Server has encountered a problem");
		}
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Created user " + userDetails.getUsername() + " with Id " + userToAdd.getUserId());
	}
	
	@Override
	public ResponseEntity<Object> deleteUserInfo(long userId) {
		Users user = null;
		try {
			user = userRepository.findByUserId(userId);
		} catch(Exception ex) {}
		if(user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("No user with id " + userId);
		}
		try{
			userRepository.delete(user);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Deleted user with user id " + userId);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Unable to delete user. Server has encountered a problem");
		}
	}

	@Override
	public ResponseEntity<Object> retrieveTeamInfoById(long teamId) {
		Team team = null;
		try {
			team = teamRepository.findByTeamId(teamId);
		} catch(Exception ex) {}
		if(team!=null) {
			String privilegedUser = userRepository.getPrivilegedUserForTeam(teamId, configuration.getAccessLevelPrevilegedAdmin());
			return ResponseEntity.status(HttpStatus.OK)
				.body(new TeamInfo(team.getTeamName(), team.getDepartment(), privilegedUser));
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("No team with Id: " + teamId);
	}

	@Override
	public ResponseEntity<Object> saveTeamInfo(Team team) {
		Team existingTeam = null;
		try {
			existingTeam = teamRepository.findByTeamName(team.getTeamName());
		} catch(Exception ex) {}
		if(existingTeam!=null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Team " + team.getTeamName() +" already exists");
		}
		if(team.getDepartment()=="" || team.getDepartment()==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Provide valid team name");
		}
		try {
			teamRepository.save(team);
		} catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Unable to save team. Server has encountered a problem");
		}
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Created team " + team.getTeamName() + " with Id " + team.getTeamId());
		
	}
	
	@Override
	public ResponseEntity<Object> deleteTeamInfo(long teamId) {
		Team team = null;
		try {
			team = teamRepository.findByTeamId(teamId);
		} catch(Exception ex) {}
		if(team == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("No team with id " + teamId);
		}
		try{
			teamRepository.deleteByTeamId(teamId);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Deleted team with team id " + teamId);
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Unable to delete team. Server has encountered a problem");
		}
	}

}
