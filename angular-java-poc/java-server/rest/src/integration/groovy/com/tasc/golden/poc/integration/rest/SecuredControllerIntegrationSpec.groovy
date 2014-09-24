package com.tasc.golden.poc.integration.rest

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate
import org.springframework.web.context.WebApplicationContext;

import redis.embedded.RedisServer
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

import com.tasc.golden.poc.MockRestApplication;
import com.tasc.golden.poc.dto.SimpleRestResponse;
import com.tasc.golden.poc.rest.SecuredController

@IntegrationTest
@WebAppConfiguration
@ContextConfiguration(classes = [MockRestApplication.class])
class SecuredControllerIntegrationSpec extends Specification{
	
	private RedisServer redisServer;
	@Autowired private WebApplicationContext wac
	private MockMvc mockMvc


	def setup() {
		this.redisServer = new RedisServer(6379);
		this.redisServer.start();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
	}
	
	def cleanup() {
		this.redisServer.stop();
	}
	
	def "info should be accessable with anon"() {
		
		expect:
			MvcResult mvcResult = this.mockMvc.perform(
				get("/info")
			   .contentType(MediaType.APPLICATION_JSON)
			   ).andExpect(status().isOk())
				   .andExpect(content().contentType("application/json;charset=UTF-8"))
				   .andReturn();

			   String jsonResponse = mvcResult.getResponse().getContentAsString();
			   println "JSON Response: " + jsonResponse;
	}
}
