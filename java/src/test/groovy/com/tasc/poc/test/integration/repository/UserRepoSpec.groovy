package com.tasc.poc.test.integration.repository

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spock.lang.Specification;

import com.tasc.poc.Application;
import com.tasc.poc.entity.User;
import com.tasc.poc.repository.IUserRepo;

@ContextConfiguration(classes = [Application.class])
class UserRepoSpec extends Specification {
	
	@Autowired private IUserRepo userRepo;
	
	def "find by email"() {
		setup:
			User u = new User();
			u.setFirstName("Bob");
			u.setLastName("smith");
			u.setEmail("bs@bs.com");
			this.userRepo.save(u);
		when:
			User user = this.userRepo.findByEmail("bs@bs.com");
		then:
			Assert.assertNotNull(user);
		cleanup:
			this.userRepo.delete(user);
	}
}
