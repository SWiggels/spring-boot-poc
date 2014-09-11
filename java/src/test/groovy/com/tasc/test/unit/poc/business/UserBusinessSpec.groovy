package com.tasc.test.unit.poc.business

import org.junit.Assert;

import com.tasc.poc.business.IUserBusiness;
import com.tasc.poc.business.impl.UserBusiness;
import com.tasc.poc.entity.User
import com.tasc.poc.repository.IUserRepo;

import spock.lang.Specification

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
