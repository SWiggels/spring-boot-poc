package com.tasc.golden.poc.facade;

import com.tasc.golden.poc.dto.UserDto;

/**
 * The facade contract for users.
 */
public interface IUserFacade {

	/**
	 * The method definition for retreival of users in the system.
	 * 
	 * @param email - The email address for users.
	 * @return
	 */
	UserDto findByEmail(String email);
}