package com.tasc.golden.poc.integration.rest

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import groovy.json.*

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import spock.lang.Specification

import com.tasc.golden.poc.MockRestApplication
import com.tasc.golden.poc.dto.ClientDto
import com.tasc.golden.poc.entity.Client
import com.tasc.golden.poc.repository.IClientRepo

@WebAppConfiguration
@ContextConfiguration(classes = [MockRestApplication.class])
class ClientRestIntegrationTest extends Specification {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private IClientRepo clientRepo;
	
	private MockMvc mockMvc;
	
	private def slurper;
	
	def setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
		this.slurper = new JsonSlurper();
	}
	
	@DirtiesContext
	def "save a new client"() {
		setup:
			String clientJson = new JsonBuilder( [name:'bob'] as ClientDto );

		expect:
			MvcResult result = this.mockMvc.perform(
				 post("/api/client/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(clientJson.getBytes())
				).andExpect(status().isOk())
					.andExpect(content().contentType("application/json;charset=UTF-8"))
					.andExpect(jsonPath('$.response').value("Success"))
					.andReturn();		
	}
	
	@DirtiesContext
	def "saving a client with an empty name should fire an exception"() {
		setup:
			String clientJson = new JsonBuilder( [] as ClientDto );

		when:
			MvcResult result = this.mockMvc.perform(
				 post("/api/client/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(clientJson.getBytes())
				).andExpect(status().isOk())
					.andExpect(content().contentType("application/json;charset=UTF-8"))
					.andExpect(jsonPath('$.response').value("Success"))
					.andReturn();
					
		then:
			thrown(Exception)
	}
	
	@DirtiesContext
	def "return a list of clients"() {

		setup:
			this.clientRepo.save([name:'Bob'] as Client);
			this.clientRepo.save([name:'Spock'] as Client);
			
			List<ClientDto> clients = [];
		
		expect:
			MvcResult mvcResult = this.mockMvc.perform(
				 get("/api/clients")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
					.andExpect(content().contentType("application/json;charset=UTF-8"))
					.andReturn();

				String jsonResponse = mvcResult.getResponse().getContentAsString();
				this.slurper.parseText(jsonResponse).each {
					clients.add( new ClientDto(it) );
				}

			clients[index].id == id
			clients[index].name == name
	
		where:	
			index | id | name
			0     | 1  | "Bob"
			1     | 2  | "Spock"
			
	}
	
	def "get a client by id" () {
		
		setup:
			clientRepo.save([name:'Bob'] as Client);
			clientRepo.save([name:'Spock'] as Client);
	
		when:
			MvcResult mvcResult = this.mockMvc.perform(
				 get("/api/client")
				 .param("id", "1")
				).andExpect(status().isOk())
					.andExpect(content().contentType("application/json;charset=UTF-8"))
					.andReturn();
				
				String jsonResponse = mvcResult.getResponse().getContentAsString();
				ClientDto rclientDto = new ClientDto( slurper.parseText(jsonResponse) );
				
		then:
			rclientDto.id == 1;
			rclientDto.name == "Bob";
		}
	
	def "get a client without an id should fire an exception" () {
			
		expect:
			this.mockMvc.perform(
				 get("/api/client")
				 ).andExpect(status().is4xxClientError());
		
	}
}
