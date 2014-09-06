package com.tasc.poc.test.integration.repository

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Assert;

import spock.lang.Specification;

import com.tasc.poc.dto.UserDto;
import com.tasc.poc.entity.User;

class DozerSpec extends Specification {
	
	/**
	 * Has to be static because it is instanciated before the class is created.
	 */
	static Mapper mapper;
	
	def setupSpec() {
		this.mapper = new DozerBeanMapper();
	}
	
	def "simple bean to bean test"() {
		
		setup:
			User u = new User();
			u.setId(1L);
			u.setFirstName("Bob");
			u.setLastName("smith");
			u.setEmail("bs@bs.com");
			
		when:
			UserDto userDto = mapper.map(u, UserDto.class);
		
		then:
			Assert.assertEquals(u.getId(), userDto.getId());
			Assert.assertEquals(u.getFirstName(), userDto.getFirstName());
			Assert.assertEquals(u.getLastName(), userDto.getLastName());
			Assert.assertEquals(u.getEmail(), userDto.getEmail());
	}
}
