package com.tasc.golden.poc.filter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class CorsFilter extends OncePerRequestFilter {

	static final String ORIGIN = 'Origin';
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if (request.getHeader(ORIGIN)) {
			String origin = request.getHeader(ORIGIN);
			response.addHeader('Access-Control-Allow-Origin', origin);
			response.addHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
			response.addHeader('Access-Control-Allow-Credentials', 'true');
			response.addHeader('Access-Control-Allow-Headers', request.getHeader('Access-Control-Request-Headers') );
		}
		if (request.method == 'OPTIONS') {
			response.writer.print('OK')
			response.writer.flush()
			return;
		}
		filterChain.doFilter(request, response);
	}
}
