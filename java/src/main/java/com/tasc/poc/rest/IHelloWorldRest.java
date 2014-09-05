package com.tasc.poc.rest;

import com.tasc.poc.dto.HelloWorld;

/**
 * Super basic hello world interface for the poc.
 */
public interface IHelloWorldRest {

	/**
     * Simple method to test the rest architecture.
     * 
     * @param name - The name to append to the hello message. Default is 'world'
     * @return - The HelloWorld object.
     */
	HelloWorld greeting(final String name);
}
