package com.tasc.golden.poc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Component;

@Log4j
@Component
public class SimpleCORSFilter implements Filter {
	
	//XMLHttpRequest cannot load http://localhost:8080/api/client/save. Request header field Content-Type is not allowed by Access-Control-Allow-Headers.

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		chain.doFilter(req, res);
		
		log.info("filterd");
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}