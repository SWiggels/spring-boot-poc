package com.tasc.golden.poc.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class SimpleRestResponse {
	
	public static final String SUCCESS = "Success";

	private HttpStatus status;
	
	private String response;
	
	
	public SimpleRestResponse() {
		this.response = SimpleRestResponse.SUCCESS;
		this.status = HttpStatus.OK;
	}
	public SimpleRestResponse(String response, HttpStatus status) {
		this.response = response;
		this.status = status;
	}
	
}
