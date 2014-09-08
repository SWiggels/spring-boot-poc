package com.tasc.golden.poc.test.rest

import com.tasc.golden.poc.business.IClientBusiness;
import com.tasc.golden.poc.dto.ClientDto;
import com.tasc.golden.poc.dto.SimpleRestResponse;
import com.tasc.golden.poc.facade.IClientFacade;
import com.tasc.golden.poc.rest.IClientRest;
import com.tasc.golden.poc.rest.impl.ClientRest;

import spock.lang.Specification;

class ClientRestUnitSpec extends Specification {

	IClientRest clientRest;
	
	def setup() {
		this.clientRest = new ClientRest();
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
	
}
