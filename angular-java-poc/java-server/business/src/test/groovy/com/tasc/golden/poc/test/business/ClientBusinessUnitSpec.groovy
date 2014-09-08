package com.tasc.golden.poc.test.business

import java.util.List;

import spock.lang.Specification

import com.tasc.golden.poc.business.IClientBusiness
import com.tasc.golden.poc.business.impl.ClientBusiness
import com.tasc.golden.poc.entity.Client
import com.tasc.golden.poc.repository.IClientRepo

class ClientBusinessUnitSpec extends Specification {

	IClientBusiness clientBusiness;
	
	def setup() {
		this.clientBusiness = new ClientBusiness();
	}
	
	def "simple save"() {
		setup:
			this.clientBusiness.@clientRepo = [save:{new Client()}] as IClientRepo;
		
		when:
			def client = this.clientBusiness.save(new Client());
			
		then:
			client != null;
	}
	
	def "empty list"() {
		setup:
			this.clientBusiness.@clientRepo = [findAll: {[] as List<Client>}] as IClientRepo;
		
		when:
			def rlist = this.clientBusiness.findAll();
		
		then:
			rlist != null;
			rlist.isEmpty();
	}
	
	def "one in list"() {
		setup:
			this.clientBusiness.@clientRepo = [findAll: {[[name: "Bobby"] as Client] as List<Client>}] as IClientRepo;
		
		when:
			def rlist = this.clientBusiness.findAll();
		
		then:
			rlist != null;
			rlist.size() == 1;
	}
}
