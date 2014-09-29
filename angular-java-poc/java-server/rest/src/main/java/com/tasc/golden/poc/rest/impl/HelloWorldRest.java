package com.tasc.golden.poc.rest.impl;


import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasc.golden.poc.dto.HelloWorld;
import com.tasc.golden.poc.rest.IHelloWorldRest;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * Super basic hello world class for the poc.
 */
@RestController
@Log4j
public class HelloWorldRest implements IHelloWorldRest {
	private AtomicLong atomicLong = new AtomicLong();
	
    @Override
    @RequestMapping(value="/api/helloworld",method=RequestMethod.GET)
    @ApiOperation(value="Some hello world API example",httpMethod="GET")
    public HelloWorld greeting(@RequestParam(value="name", required=false, defaultValue="World") final String name) {
    	return new HelloWorld(atomicLong.incrementAndGet(), String.format("Hello, %s!", name)); 
    }
}

