package com.tasc.golden.poc.dto;

import lombok.Data;

@Data
public class SimpleRestResponse {

	private String response;
	
	public SimpleRestResponse() {
		this.response = "Success";
	}
}
