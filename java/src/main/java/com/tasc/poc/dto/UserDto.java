package com.tasc.poc.dto;

import lombok.Data;

@Data
public class UserDto {

	/**
	 * Our PK.
	 */
	private Long id;
	
	/**
	 * The users first name.
	 */
	private String firstName;
	
	/**
	 * The users last name.
	 */
	private String lastName;
	
	/**
	 * The users email.
	 */
	private String email;
}
