package com.mycompany.example

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController3 {

    private static final String template = "Hello3, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/helloworld3")
    public HelloWorld greeting(@RequestParam(value="name", required=false, defaultValue="World3!!!!!!!!") String name) {

        return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
    }
	
}