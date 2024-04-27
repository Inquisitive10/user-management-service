package com.SSAssignment.onboardify.usermanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.SSAssignment.onboardify.usermanagementservice.configuration")
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}

}
