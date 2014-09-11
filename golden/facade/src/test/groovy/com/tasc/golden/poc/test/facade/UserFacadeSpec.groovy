package com.tasc.golden.poc.test.facade

import lombok.extern.java.Log

import org.dozer.DozerBeanMapper
import org.junit.Assert

import spock.lang.Specification

import com.tasc.golden.poc.business.IUserBusiness
import com.tasc.golden.poc.dto.UserDto
import com.tasc.golden.poc.entity.User
import com.tasc.golden.poc.facade.IUserFacade
import com.tasc.golden.poc.facade.impl.UserFacade


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