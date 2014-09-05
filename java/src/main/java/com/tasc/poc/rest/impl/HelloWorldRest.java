package com.tasc.poc.rest.impl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasc.poc.dto.HelloWorld;
import com.tasc.poc.rest.IHelloWorldRest;

/**
 * Super basic hello world class for the poc.
 */
@RestController
public class HelloWorldRest implements IHelloWorldRest {

	/**
	 * For string formatting of the return value.
	 */
	private static final String template = "Hello, %s!";
	
	/**
	 * Basic counter for the return HelloWorld object.
	 */
    private final AtomicLong counter = new AtomicLong();

    /**
     * {@inheritDoc}
     */
    @RequestMapping("/helloworld")
    public HelloWorld greeting(@RequestParam(value="name", required=false, defaultValue="World") final String name) {
        return new HelloWorld(counter.incrementAndGet(), String.format(template, name)); 
    }
}
