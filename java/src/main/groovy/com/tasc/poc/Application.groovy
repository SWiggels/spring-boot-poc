package com.tasc.poc;

import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Main class for the application boot.
 */
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
