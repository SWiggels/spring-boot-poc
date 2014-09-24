package com.tasc.golden.poc

import org.dozer.DozerBeanMapper
import org.dozer.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.tasc.golden.poc.csrf.RedisCsrfTokenRepository;


/**
 * Main class for the application boot.
 */
@ComponentScan
@EnableAutoConfiguration
@Configuration
public class MockRestApplication {
	
	@Bean
	public Mapper getMapper() {
		return new DozerBeanMapper();
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
				.httpBasic().and()
				.csrf().csrfTokenRepository(tokenRepository).and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/info").permitAll()
				.anyRequest().hasRole("USER");
	}
	
	/**
	 * Main method to start the application.
	 *
	 * @param args - No args required.
	 
	public static void main(String[] args) {
		SpringApplication.run(MockRestApplication.class, args);
		
	}
	*/
}

