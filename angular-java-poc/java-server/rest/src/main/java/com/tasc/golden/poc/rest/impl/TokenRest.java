package com.tasc.golden.poc.rest.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasc.golden.poc.csrf.RedisCsrfTokenRepository;
import com.tasc.golden.poc.dto.SimpleRestResponse;

/**
 * Simple token to get the CSRF token and passed back. Would be better to have this in cookies, however, I cannot 
 * as browser issues due to CSRF.
 */
@RestController
public class TokenRest {
	
	@Autowired
	private RedisCsrfTokenRepository tokenRepository;

	@RequestMapping("/api/token")
	public SimpleRestResponse newToken(HttpServletRequest request) {
		
		CsrfToken token = this.tokenRepository.generateToken(null);
		this.tokenRepository.saveToken(token, request, null);
		SimpleRestResponse srr = new SimpleRestResponse();
		srr.setResponse(token.getToken());
		return srr;
	}
}
