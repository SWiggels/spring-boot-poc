package com.mycompany.example

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController2 {

    private static final String template = "Hello2, %s!";
    private final AtomicLong counter = new AtomicLong();

	
    @RequestMapping("/helloworld2")
    public HelloWorld greeting(@RequestParam(value="name", required=false, defaultValue="WORLD!") String name) {

        return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
    }
	
	def "this is the name of my method"() {
		return null;
	}
}