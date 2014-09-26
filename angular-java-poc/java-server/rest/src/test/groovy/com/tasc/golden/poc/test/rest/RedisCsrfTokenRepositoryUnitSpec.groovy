package com.tasc.golden.poc.test.rest

import java.util.UUID;

import groovy.mock.interceptor.MockFor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.util.SerializationUtils;

import com.tasc.golden.poc.csrf.RedisCsrfTokenRepository;

import redis.clients.jedis.BinaryJedisCommands;
import redis.clients.jedis.Jedis;
import redis.embedded.RedisServer;
import spock.lang.Specification

class RedisCsrfTokenRepositoryUnitSpec extends Specification {

	CsrfTokenRepository csrfTokenRepository;
	
	def setup() {
		this.csrfTokenRepository = new RedisCsrfTokenRepository();
	}
	
	def "generate a token"() {
		
		when:
			CsrfToken token = this.csrfTokenRepository.generateToken(null);
		
		then:
			token 					!= null;
			token.headerName 		== RedisCsrfTokenRepository.CSRF_HEADER_NAME;
			token.parameterName 	== RedisCsrfTokenRepository.CSRF_PARAMETER_NAME;
			token.token 			!= null;
	}
	
	def "save token null key so no call to the token repository"() {
		
		setup:
			def request = [getHeader: {null}] as HttpServletRequest;
			def jedisMock = Mock( BinaryJedisCommands )
			this.csrfTokenRepository.@tokenRepository = jedisMock;
		
		when:
			this.csrfTokenRepository.saveToken(null, request, null);
			
		then:
			0 * this.csrfTokenRepository.@tokenRepository.set(_,_);
			0 * this.csrfTokenRepository.@tokenRepository.del(_);
	}
	
	def "http session key available but token null so repo deletes the key."() {
		
		setup:
			def request = [getHeader: {"MOCKKEY"}] as HttpServletRequest;
			this.csrfTokenRepository.@tokenRepository = Mock( BinaryJedisCommands );
		
		when:
			this.csrfTokenRepository.saveToken(null, request, null);
			
		then:
			0 * this.csrfTokenRepository.@tokenRepository.set(_,_);
			1 * this.csrfTokenRepository.@tokenRepository.del(_);
	}
	
	def "calling the repository save method"() {
		
		setup:
			def request = [getHeader: {"MOCKKEY"}] as HttpServletRequest;
			this.csrfTokenRepository.@tokenRepository = Mock( BinaryJedisCommands );
		
		when:
			this.csrfTokenRepository.saveToken(
				new DefaultCsrfToken(
					RedisCsrfTokenRepository.CSRF_HEADER_NAME,
					RedisCsrfTokenRepository.CSRF_PARAMETER_NAME,
					UUID.randomUUID().toString()
				),
				request,
				null);
			
		then:
			1 * this.csrfTokenRepository.@tokenRepository.set(_,_);
			0 * this.csrfTokenRepository.@tokenRepository.del(_);
	}

	def "load token and return token"() {
		
		setup:
			def request = [getHeader: {"MOCKKEY"}] as HttpServletRequest;
			this.csrfTokenRepository.@tokenRepository = Mock( BinaryJedisCommands );
			def cfrToken = new DefaultCsrfToken(
						RedisCsrfTokenRepository.CSRF_HEADER_NAME,
						RedisCsrfTokenRepository.CSRF_PARAMETER_NAME,
						UUID.randomUUID().toString()
					);
		
		when:
			CsrfToken rtoken = this.csrfTokenRepository.loadToken( request);
			
		then:
			1 * this.csrfTokenRepository.@tokenRepository.get(_) >> SerializationUtils.serialize(cfrToken);
			rtoken.token == cfrToken.token;
			rtoken.headerName == cfrToken.headerName;
			rtoken.parameterName == cfrToken.parameterName;
	}	
	
	def "load token and return null as key does exist but token does not"() {
		
		setup:
			def request = [getHeader: {"MOCKKEY"}] as HttpServletRequest;
			this.csrfTokenRepository.@tokenRepository = Mock( BinaryJedisCommands );
		
		when:
			CsrfToken rtoken = this.csrfTokenRepository.loadToken( request);
			
		then:
			1 * this.csrfTokenRepository.@tokenRepository.get(_) >> null;
			rtoken == null;
	}
	
	def "load token and return null as key does not exist"() {
		
		setup:
			def request = [getHeader: {null}] as HttpServletRequest;
			this.csrfTokenRepository.@tokenRepository = Mock( BinaryJedisCommands );
		
		when:
			CsrfToken rtoken = this.csrfTokenRepository.loadToken( request);
			
		then:
			0 * this.csrfTokenRepository.@tokenRepository.get(_);
			rtoken == null;
	}
}
