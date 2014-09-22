package com.tasc.golden.poc.integration.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import com.tasc.golden.poc.MockRestApplication;

import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebAppConfiguration
@ContextConfiguration(classes = [MockRestApplication.class])
public class HelloWorldRestSpecTests extends Specification {

	@Autowired
	private WebApplicationContext wac

	private MockMvc mockMvc


	def setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
	}

	def 'say hello to the world.'() throws Exception { 

		expect:
			this.mockMvc.perform(get("/api/helloworld").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath('$.content').value("Hello, World!"))
	}

	def 'Say hello to the crew of the USS Enterprise.'() throws Exception {

		expect:
			this.mockMvc.perform(get("/api/helloworld").param('name', name).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath('$.content').value(content))

		where:
			name     | content
			'Kirk'   | 'Hello, Kirk!'
			'Spock'  | 'Hello, Spock!'
			'Bones'  | 'Hello, Bones!'
			'Scotty' | 'Hello, Scotty!'

	}
	
}