package com.tasc.golden.poc.test.repository

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.tasc.golden.poc.RepositoryMockApplication;
import com.tasc.golden.poc.entity.Client;
import com.tasc.golden.poc.repository.IClientRepo;

import spock.lang.Specification

@ContextConfiguration(classes = [RepositoryMockApplication.class])
class ClientRepoIntegrationTest extends Specification {
	
	@Autowired IClientRepo clientRepo;
	
	def "make sure the mapping works"() {
		setup:
		def client = [name: "Bobby"] as Client;
		
		when:
			def rclient = this.clientRepo.save(client);
		
		then:
			rclient.id != null;
	}
	
	def "make sure an exception is thrown on empty name"() {
		setup:
		def client = [] as Client;
		
		when:
			def rclient = this.clientRepo.save(client);
		
		then:
			thrown(Exception);
	}
}
