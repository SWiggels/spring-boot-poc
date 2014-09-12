package com.tasc.golden.poc.test.batch

import com.tasc.golden.poc.batch.IClientBatch;
import com.tasc.golden.poc.batch.impl.ClientBatch;
import com.tasc.golden.poc.dto.ClientDto;
import com.tasc.golden.poc.facade.IClientFacade;

import spock.lang.Specification

class ClientBatchUnitSpec extends Specification {
	
	IClientBatch clientBatch;
	
	def setup() {
		this.clientBatch = new ClientBatch()
	}

	def "simple test to show the batch running"() {
		
		setup:
			this.clientBatch.@clientFacade = [save:{[id:1, name:"Bobby"] as ClientDto}, findById:{[id:1, name:"Bobby"] as ClientDto}] as IClientFacade
		
		when:
			boolean rbool = this.clientBatch.runSimpleBatch("Bobby");
		
		then:
			rbool;
	}
}
