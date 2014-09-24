package com.tasc.golden.poc.rest

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasc.golden.poc.dto.SimpleRestResponse;

@RestController
public class SecuredController {

    public static final String DEFAULT_INFO = "Default info";
    public static final String LOGGED_MESSAGE = "logged in";

    private String info = DEFAULT_INFO;

	@ResponseBody
    @RequestMapping(value = "/info")
    public SimpleRestResponse home() {
		return new SimpleRestResponse("info updated", HttpStatus.OK);
    }

	@ResponseBody
    @RequestMapping(value = "/login")
    public SimpleRestResponse login(HttpServletRequest request) {
        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        HttpHeaders headers = new HttpHeaders();
        headers.add(token.getHeaderName(), token.getToken());
        return new SimpleRestResponse();
    }

	@ResponseBody
    @RequestMapping(value = "/info/update", method = RequestMethod.PUT)
    public SimpleRestResponse post(@RequestBody String newInfo) {
        info = newInfo;
        return new SimpleRestResponse("info updated", HttpStatus.OK);
    }

}

