package com.tasc.golden.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasc.golden.poc.entity.User;

/**
 * This is the spring data jpa interface for user repositories.
 */
public interface IUserRepo extends JpaRepository<User, Long> {
	
	/**
	 * This method finds the user by the email address provided.
	 * 
	 * @param email - The email to search on.
	 * @return - The User with the email.
	 */
	User findByEmail(String email);
}
