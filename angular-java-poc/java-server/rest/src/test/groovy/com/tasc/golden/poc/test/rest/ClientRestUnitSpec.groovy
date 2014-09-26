package com.tasc.golden.poc.test.rest

import com.tasc.golden.poc.business.IClientBusiness;
import com.tasc.golden.poc.dto.ClientDto;
import com.tasc.golden.poc.dto.SimpleRestResponse;
import com.tasc.golden.poc.facade.IClientFacade;
import com.tasc.golden.poc.rest.IClientRest;
import com.tasc.golden.poc.rest.impl.ClientRest;
import org.springframework.security.crypto.codec.Base64;

import spock.lang.Specification;

class ClientRestUnitSpec extends Specification {

	IClientRest clientRest;
	
	def setup() {
		this.clientRest = new ClientRest();
	}
	
	
	def "get me the headers"() {
		setup:
			String header = "user" + ":" + "password";
			
		when:
			byte[] encodedAuthorisation = Base64.encode(header.getBytes());
			println UUID.randomUUID().toString();
			
		then:
			1 == 1;
	}
	
	def "simple save test"() {
		setup:
			this.clientRest.@clientFacade = [save:{[] as ClientDto}] as IClientFacade;
		
		when:
			SimpleRestResponse response = this.clientRest.save(new ClientDto());
			
		then :
			response != null;
			response.response == "Success";
	}
	
	def "returning an empty list"() {
		setup:
			this.clientRest.@clientFacade = [findAll:{new ArrayList<ClientDto>()}] as IClientFacade;
		
		when:
			List<ClientDto> rlist = this.clientRest.findAll();
		
		then:
			rlist != null;
			rlist.isEmpty();
	}
	
	def "returning one in the list"() {
		setup:
			def list = [new ClientDto()];
			this.clientRest.@clientFacade = [findAll:{list}] as IClientFacade;
		
		when:
			List<ClientDto> rlist = this.clientRest.findAll();
		
		then:
			rlist != null;
			!rlist.isEmpty();
			rlist.size() == 1;
	}
	
	def "find one by id"() {
		setup:
			this.clientRest.@clientFacade = [findById:{[id: 1L, name: "Bobby"] as ClientDto}] as IClientFacade;
		
		when:
			def client = this.clientRest.findById(1L);
		
		then:
			client != null;
	}
}
