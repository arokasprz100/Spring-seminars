package com.javasampleapproach.springsecurity.jdbcauthentication;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityJdbcAuthenticationPostgreSqlApplication {

	private static final Logger logger=LoggerFactory.getLogger(SpringSecurityJdbcAuthenticationPostgreSqlApplication.class);
	  
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcAuthenticationPostgreSqlApplication.class, args);
        logger.info("Application is running");
	}

}
