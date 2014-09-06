package com.tasc.test.unit.poc.facade

import lombok.extern.java.Log;

import org.dozer.DozerBeanMapper;
import org.junit.Assert;

import com.tasc.poc.business.IUserBusiness;
import com.tasc.poc.dto.UserDto;
import com.tasc.poc.entity.User;
import com.tasc.poc.facade.IUserFacade;
import com.tasc.poc.facade.impl.UserFacade;

import spock.lang.Specification

@Log
class UserFacadeSpec extends Specification {
	
	IUserFacade userFacade;
	
	def setup() {
		this.userFacade = new UserFacade();
	}
	
	def "simple user facade case" () {
		setup:
			User u = new User();
			u.id = 1L;
			u.firstName = "fname";
			u.lastName = "lname";
			u.email = "this@is.mocked";
			this.userFacade.@userBusiness = [findByEmail:{u}] as IUserBusiness;
			this.userFacade.@mapper = new DozerBeanMapper();
		when:
			UserDto userDto = this.userFacade.findByEmail("this@is.mocked");
			
		then:
			Assert.assertNotNull(userDto);
			Assert.assertEquals(u.id, userDto.id);
			Assert.assertEquals(u.firstName, userDto.firstName);
			Assert.assertEquals(u.lastName, userDto.lastName);
			Assert.assertEquals(u.email, userDto.email);
	}
}
