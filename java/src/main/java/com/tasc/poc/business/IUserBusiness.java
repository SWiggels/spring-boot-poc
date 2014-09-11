package com.tasc.poc.business;

import com.tasc.poc.entity.User;

/**
 * Interface for the usage of the user business objects.
 */
public interface IUserBusiness {

	/**
	 * This method finds the user by the email address provided.
	 * 
	 * @param email - The email to search on.
	 * @return - The User with the email.
	 */
	User findByEmail(String email);
}
