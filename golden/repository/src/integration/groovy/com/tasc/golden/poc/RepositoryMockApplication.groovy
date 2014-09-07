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
 * Main class for the application boot.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class RepositoryMockApplication  {
	
	/**
	 * Main method to start the application.
	 *
	 * @param args - No args required.
	 */
	public static void main(String[] args) {
		SpringApplication.run(RepositoryMockApplication.class, args);
		
	}
}

