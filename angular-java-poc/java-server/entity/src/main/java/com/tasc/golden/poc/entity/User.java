package com.tasc.golden.poc.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Class to define the User db object.
 */
@Entity
@Data
public class User {

	/**
	 * Our PK.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * The users first name.
	 */
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	/**
	 * The users last name.
	 */
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	/**
	 * The users email.
	 */
	@Column(name = "email", nullable = false)
	private String email;
}
