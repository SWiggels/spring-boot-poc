package com.tasc.golden.poc.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

import com.tasc.golden.poc.csrf.RedisCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private RedisCsrfTokenRepository tokenRepository;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .httpBasic().and()
        .csrf().csrfTokenRepository(tokenRepository).and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/api/**").permitAll()
        .anyRequest().hasRole("USER");
    	
//    	http
    	//.csrf().disable()
//    		.authorizeRequests()
//    		.antMatchers(HttpMethod.GET, "/info").permitAll()
//    		.anyRequest().hasRole("USER");
//	        .antMatchers("/api/**").hasRole("USER")
//	        .anyRequest().anonymous()
//	        .and()
//	        .httpBasic();
    	
    } 

    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER");
        }

    }

}