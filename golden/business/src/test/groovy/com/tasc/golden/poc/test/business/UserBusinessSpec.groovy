package com.tasc.golden.poc.test.business

import org.junit.Assert

import spock.lang.Specification

import com.tasc.golden.poc.business.IUserBusiness
import com.tasc.golden.poc.business.impl.UserBusiness
import com.tasc.golden.poc.entity.User
import com.tasc.golden.poc.repository.IUserRepo


class UserBusinessSpec extends Specification {

	IUserBusiness userBusiness;
	
	def setup() {
		this.userBusiness = new UserBusiness();
	}
	
	def "validate find by email"() {
		setup:
			this.userBusiness.@userRepo = [findByEmail: {new User()}] as IUserRepo;
		
		when:
			User u = this.userBusiness.findByEmail("doesntmatter@asits.mocked");
		
		then:
			Assert.assertNotNull(u);
	}
}
