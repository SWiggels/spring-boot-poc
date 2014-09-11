package com.tasc.golden.poc

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


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

