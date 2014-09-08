package com.tasc.golden.poc.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasc.golden.poc.business.IClientBusiness;
import com.tasc.golden.poc.dto.ClientDto;
import com.tasc.golden.poc.entity.Client;
import com.tasc.golden.poc.facade.IClientFacade;

@Service
public class ClientFacade implements IClientFacade {

	@Autowired Mapper mapper;
	@Autowired IClientBusiness clientBusiness;
	
	@Override
	public ClientDto save(ClientDto clientDto) {
		Client savedClient = this.clientBusiness.save(this.mapper.map(clientDto, Client.class));
		return mapper.map(savedClient, ClientDto.class);
	}
	
	@Override
	public List<ClientDto> findAll() {
		List<ClientDto> rlist = new ArrayList<ClientDto>();
		for (Client client : this.clientBusiness.findAll()) {
			rlist.add(this.mapper.map(client, ClientDto.class));
		}
		return rlist;
	}
}
