package com.tasc.poc.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasc.poc.dto.HelloWorld;

@RestController
public class HelloWorldRest {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/helloworld")
    public HelloWorld greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {

        return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
    }
}
