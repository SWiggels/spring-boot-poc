package com.tasc.golden.poc.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasc.golden.poc.dto.ClientDto;
import com.tasc.golden.poc.dto.SimpleRestResponse;
import com.tasc.golden.poc.facade.IClientFacade;
import com.tasc.golden.poc.rest.IClientRest;

@RestController
public class ClientRest implements IClientRest {
	
	@Autowired IClientFacade clientFacade;

	@RequestMapping("/api/clients")
	@Override
	public List<ClientDto> findAll() {
		return this.clientFacade.findAll();
	}
	
	
	@RequestMapping("/api/client/save")
	@Override
	public SimpleRestResponse save(@RequestBody ClientDto clientDto) {
		this.clientFacade.save(clientDto);
		return new SimpleRestResponse();
	}
	
	@RequestMapping("/api/client")
	@Override
	public ClientDto findById(@RequestParam(value="id", required=true) final Long id) {
		return this.clientFacade.findById(id);
	}
}
