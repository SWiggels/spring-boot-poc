package com.tasc.golden.poc.facade.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasc.golden.poc.business.IUserBusiness;
import com.tasc.golden.poc.dto.UserDto;
import com.tasc.golden.poc.entity.User;
import com.tasc.golden.poc.facade.IUserFacade;

/**
 * The user facade implementation.
 */
@Service
public class UserFacade implements IUserFacade {
	
	/**
	 * The user business object to call.
	 */
	@Autowired IUserBusiness userBusiness;
	
	/**
	 * The mapper for mashalling between objects.
	 */
	@Autowired Mapper mapper;

	@Override public UserDto findByEmail(String email) {
		User u = this.userBusiness.findByEmail(email); 
		return this.mapper.map(u, UserDto.class);
	}
}