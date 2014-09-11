package com.tasc.golden.poc.facade;

import java.util.List;

import com.tasc.golden.poc.dto.ClientDto;

public interface IClientFacade {

	ClientDto save(ClientDto clientDto);
	
	List<ClientDto> findAll();
	
	ClientDto findById(Long id);
}
