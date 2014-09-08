package com.tasc.golden.poc.test.facade

import org.dozer.DozerBeanMapper;

import com.tasc.golden.poc.business.IClientBusiness;
import com.tasc.golden.poc.dto.ClientDto;
import com.tasc.golden.poc.entity.Client;
import com.tasc.golden.poc.facade.IClientFacade;
import com.tasc.golden.poc.facade.impl.ClientFacade;

import spock.lang.Specification

class ClientFacadeUnitSpec extends Specification {

	IClientFacade clientFacade;
	
	def setup() {
		this.clientFacade = new ClientFacade();
	}
	
	def "simple save"() {
		setup:
			def client = [name: "Bob"] as Client;
			this.clientFacade.@clientBusiness = [save: {client} ] as IClientBusiness;
			this.clientFacade.@mapper = new DozerBeanMapper();
			
		when:
			def rdto = this.clientFacade.save(new ClientDto());
			
		then:
			rdto != null;
	}
	
	def "returning an empty list"() {
		setup:
			def clients = [] as List<Client>;
			this.clientFacade.@clientBusiness = [findAll: {clients} ] as IClientBusiness;
			this.clientFacade.@mapper = new DozerBeanMapper();
			
		when:
			def rlist = this.clientFacade.findAll();
		
		then:
			rlist != null;
			rlist.isEmpty();
		
	}
	
	def "returning one in the list"() {
		setup:
			def clients = [[name: "Bobby"] as Client] as List<Client>;
			this.clientFacade.@clientBusiness = [findAll: {clients} ] as IClientBusiness;
			this.clientFacade.@mapper = new DozerBeanMapper();
			
		when:
			def rlist = this.clientFacade.findAll();
		
		then:
			rlist != null;
			rlist.size() == 1;
	}
}
