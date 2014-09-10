package com.tasc.golden;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
	
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
		SpringApplication.run(Application.class, args);
		
	}

}
