package com.SSAssignment.onboardify.usermanagementservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SSAssignment.onboardify.usermanagementservice.dto.Users;

import jakarta.transaction.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	Users findByUserId(long userId);
	
	Users findByUsername(String username);
	
	@Transactional
	int deleteByUserId(long userId);

	
	@Transactional
    @Query(value = "SELECT USERNAME FROM USERS WHERE TEAM_ID = :teamId AND ACCESS_LEVEL = :accessLevel", nativeQuery = true)
    String getPrivilegedUserForTeam(@Param("teamId") long teamId, @Param("accessLevel") int accessLevel);
}
