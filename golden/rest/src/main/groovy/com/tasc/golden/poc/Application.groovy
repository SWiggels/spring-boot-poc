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
//@EnableWebMvcSecurity
public class Application { //extends WebSecurityConfigurerAdapter {
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/", "/helloworld").permitAll()
//				.anyRequest().authenticated();
//	}
	
	@Bean
	public Mapper getMapper() {
		return new DozerBeanMapper();
	}
	
//	@Configuration
//	protected static class AuthenticationConfiguration extends
//			GlobalAuthenticationConfigurerAdapter {
//
//		@Override
//		public void init(AuthenticationManagerBuilder auth) throws Exception {
//			auth
//					.inMemoryAuthentication()
//					.withUser("user").password("password").roles("USER");
//		}
//	}
	
	/**
	 * Main method to start the application.
	 *
	 * @param args - No args required.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}

