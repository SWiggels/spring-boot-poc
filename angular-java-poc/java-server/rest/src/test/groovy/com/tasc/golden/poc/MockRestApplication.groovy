package com.tasc.golden.poc

import org.dozer.DozerBeanMapper
import org.dozer.Mapper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


/**
 * Main class for the application boot.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MockRestApplication {
	
	@Bean
	public Mapper getMapper() {
		return new DozerBeanMapper();
	}
	
	
	/**
	 * Main method to start the application.
	 *
	 * @param args - No args required.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MockRestApplication.class, args);
		
	}
}

