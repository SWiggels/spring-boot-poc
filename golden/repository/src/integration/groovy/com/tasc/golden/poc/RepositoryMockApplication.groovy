package com.tasc.golden.poc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity


/**
 * Need for the integration tests in respository as it is not able to access the rest folder.
 * 
 * Basically a mock.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class RepositoryMockApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(RepositoryMockApplication.class, args);
		
	}
}

