package com.tasc.golden.poc.rest;

import java.util.List;

import com.tasc.golden.poc.dto.ClientDto;
import com.tasc.golden.poc.dto.SimpleRestResponse;

public interface IClientRest {

	List<ClientDto> findAll();
	
	SimpleRestResponse save(ClientDto clientDto);
	
	ClientDto findById(Long id);
	
}
