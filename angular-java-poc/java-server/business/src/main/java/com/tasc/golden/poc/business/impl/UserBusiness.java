package com.tasc.golden.poc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasc.golden.poc.business.IUserBusiness;
import com.tasc.golden.poc.entity.User;
import com.tasc.golden.poc.repository.IUserRepo;

/**
 * Business object that manages the business rules for user entities.
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
