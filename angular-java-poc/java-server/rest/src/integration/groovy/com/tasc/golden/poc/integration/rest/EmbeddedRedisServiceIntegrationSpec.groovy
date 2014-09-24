package com.tasc.golden.poc.integration.rest

import static org.hamcrest.CoreMatchers.is;
import redis.clients.jedis.Jedis;
import redis.embedded.RedisServer;
import spock.lang.Specification

class EmbeddedRedisServiceIntegrationSpec extends Specification {
	
	RedisServer redisServer;
	
	def setup() {
		this.redisServer = new RedisServer(6379);
	}
	
	def cleanup(){
		this.redisServer.stop();
	}

	def "redis is not yet started and so not active"() {
		expect:
			!redisServer.isActive();
	}
	
	def "start redis and is active"() {
		setup:
			this.redisServer.start();
			
		expect:
			redisServer.isActive();
	}
	
	def "make sure that jedis can access the embedded redis database"() {
		setup:
			this.redisServer.start();
			Jedis jedis = new Jedis("localhost", 6379);
		
		when:
			jedis.set("testKey", "testValue");
			
		then:
			jedis.get("testKey") == "testValue";
			
		cleanup:
			jedis.close();
	}
}
