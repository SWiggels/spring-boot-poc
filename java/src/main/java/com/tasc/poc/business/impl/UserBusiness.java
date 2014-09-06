package com.tasc.poc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasc.poc.business.IUserBusiness;
import com.tasc.poc.entity.User;
import com.tasc.poc.repository.IUserRepo;

/**
 * Business object that manages the business rules for a user.
 */
@Service
public class UserBusiness implements IUserBusiness {

	/**
	 * The repository object for retrieving users.
	 */
	@Autowired IUserRepo userRepo;
	
	@Override public User findByEmail(String email) {
		return this.userRepo.findByEmail(email);
	}
}
