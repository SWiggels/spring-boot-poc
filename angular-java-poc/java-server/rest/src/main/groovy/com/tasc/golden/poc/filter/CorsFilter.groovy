package com.tasc.golden.poc.filter

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.security.web.csrf.CsrfToken
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

import com.tasc.golden.poc.csrf.RedisCsrfTokenRepository

@Component
class CorsFilter extends OncePerRequestFilter {

	static final String ORIGIN = 'Origin'
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if (request.getHeader(ORIGIN)) {
			String origin = request.getHeader(ORIGIN)
			response.addHeader('Access-Control-Allow-Origin', origin)
			response.addHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE')
			response.addHeader('Access-Control-Allow-Credentials', 'true')
			response.addHeader('Access-Control-Allow-Headers', request.getHeader('Access-Control-Request-Headers') )
		}
		if (request.method == 'OPTIONS') {
			response.addHeader('X-CSRF-TOKEN', RedisCsrfTokenRepository.CSRF_HEADER_NAME);
			response.addHeader(RedisCsrfTokenRepository.CSRF_HEADER_NAME, "c8546c65-fe9e-426e-afbb-1639922d9494");
			response.writer.print('OK')
			response.writer.flush()
			return;
		}
		filterChain.doFilter(request, response);
//		println "HEADERS NAME:  " + CsrfToken.class.getName();
//		def csrfToken =  request.getAttribute(CsrfToken.class.getName());
//		if (csrfToken == null) {
//			println "TOKEN NULLLLLLLLLLLLLLLLL";
//		} else {
//			println "HEADER: " + csrfToken.headerName;
//			println "PARAM: " + csrfToken.parameterName;
//			println "TOKEN: " + csrfToken.token;
//			
//		}
		
	}
}
