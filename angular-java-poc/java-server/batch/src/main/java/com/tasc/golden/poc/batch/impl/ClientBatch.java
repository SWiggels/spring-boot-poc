package com.tasc.golden.poc.batch.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasc.golden.poc.batch.IClientBatch;
import com.tasc.golden.poc.dto.ClientDto;
import com.tasc.golden.poc.facade.IClientFacade;

/**
 * Simple class to show the orchestration of events behind the transaction boundry of the facacde. This is not intended to 
 * be an actual use case. :)
 */
@Service
public class ClientBatch implements IClientBatch {
	
	@Autowired IClientFacade clientFacade;

	public boolean runSimpleBatch(final String name) {
		ClientDto clientDto = new ClientDto();
		clientDto.setName(name);
		clientDto = this.clientFacade.save(clientDto);
		this.clientFacade.findById(clientDto.getId());
		return true;
	}
}
