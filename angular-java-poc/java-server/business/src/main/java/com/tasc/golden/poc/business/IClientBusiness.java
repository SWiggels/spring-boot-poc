package com.tasc.golden.poc.business;

import java.util.List;

import com.tasc.golden.poc.entity.Client;

public interface IClientBusiness {
	
	Client save(Client client);
	
	List<Client> findAll();
}
