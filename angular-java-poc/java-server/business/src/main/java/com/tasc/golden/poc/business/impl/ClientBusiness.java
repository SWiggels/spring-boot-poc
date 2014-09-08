package com.tasc.golden.poc.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasc.golden.poc.business.IClientBusiness;
import com.tasc.golden.poc.entity.Client;
import com.tasc.golden.poc.repository.IClientRepo;

@Service
public class ClientBusiness implements IClientBusiness {
	
	@Autowired IClientRepo clientRepo;
	
	@Override
	public Client save(Client client) {
		return this.clientRepo.save(client);
	}
	
	@Override
	public List<Client> findAll() {
		return this.clientRepo.findAll();
	}
}
