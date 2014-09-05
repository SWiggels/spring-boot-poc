package com.tasc.poc;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Main class for the application boot.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
	
	/**
	 * Adds the data source bean, test schema, and data.
	 * 
	 * @return - The data source for the application bootstrap.
	 */
	@Bean
	public DataSource dataSource() {
	  DataSource bean = new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.H2)
		.addScript("classpath:my-schema.sql")
		.addScript("classpath:my-test-data.sql")
		.build();
	  return bean;
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
