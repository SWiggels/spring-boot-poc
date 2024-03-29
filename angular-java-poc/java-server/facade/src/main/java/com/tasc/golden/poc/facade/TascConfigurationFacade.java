package com.tasc.golden.poc.facade;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TascConfigurationFacade {
	
	@Bean
	public Mapper getMapper() {
		return new DozerBeanMapper();
	}

}
