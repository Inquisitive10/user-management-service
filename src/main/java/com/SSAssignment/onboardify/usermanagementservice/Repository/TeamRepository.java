package com.SSAssignment.onboardify.usermanagementservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SSAssignment.onboardify.usermanagementservice.dto.Team;

import jakarta.transaction.Transactional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

	Team findByTeamId(long teamId);
	
	Team findByTeamName(String teamName);
	
	@Transactional
	int deleteByTeamId(long teamId);
}
