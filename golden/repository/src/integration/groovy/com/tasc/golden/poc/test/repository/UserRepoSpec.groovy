package com.tasc.golden.poc.test.repository

import org.junit.Assert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration

import spock.lang.Specification

import com.tasc.golden.poc.RepositoryMockApplication
import com.tasc.golden.poc.entity.User
import com.tasc.golden.poc.repository.IUserRepo

@ContextConfiguration(classes = [RepositoryMockApplication.class])
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
