package com.bontsi.assessment.globalkinectic.GlobalKinectic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GlobalKinecticApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalKinecticApplication.class, args);
	}

}
