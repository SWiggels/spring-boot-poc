package com.tasc.poc;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
	
	@Bean
	public DataSource dataSource() {
	  DataSource bean = new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.H2)
		.addScript("classpath:schema.sql")
		.build();
	  return bean;
	}

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
