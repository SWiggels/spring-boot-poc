package com.tasc.golden.poc.csrf;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import redis.clients.jedis.BinaryJedisCommands;
import redis.clients.jedis.Jedis;
import redis.embedded.RedisServer;

@Component
public class RedisCsrfTokenRepository implements CsrfTokenRepository {
	
	public static final String CSRF_PARAMETER_NAME = "_csrf";

    public static final String CSRF_HEADER_NAME = "X-CSRF-HEADER";

    private RedisServer redisServer;

    private Jedis tokenRepository;

    public RedisCsrfTokenRepository() throws Exception {
        this.redisServer = new RedisServer(6379);
        redisServer.start();
        tokenRepository = new Jedis("localhost", 6379);
    }
	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		return new DefaultCsrfToken(RedisCsrfTokenRepository.CSRF_HEADER_NAME, RedisCsrfTokenRepository.CSRF_PARAMETER_NAME, "c8546c65-fe9e-426e-afbb-1639922d9494");
	}

	@Override
	public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
		String key = this.getKey(request);
        if (key == null) {
            return;
        }

        if (token == null) {
            this.tokenRepository.del(key.getBytes());
        } else {
            this.tokenRepository.set(key.getBytes(), SerializationUtils.serialize(token));
        }
	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		return this.generateToken(null);
//		String key = getKey(request);
//        if (key != null) {
//            byte[] tokenString = this.tokenRepository.get(key.getBytes());
//            if (tokenString != null) {
//                return (CsrfToken) SerializationUtils.deserialize(tokenString);
//            }
//        }
//        return null;
	}
	
	private String getKey(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

	private String createNewToken() {
        return UUID.randomUUID().toString();
    }
}
