package com.tasc.golden.poc.test.rest

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

import com.tasc.golden.poc.dto.HelloWorld
import com.tasc.golden.poc.rest.IHelloWorldRest
import com.tasc.golden.poc.rest.impl.HelloWorldRest

@RunWith(BlockJUnit4ClassRunner.class)
public class HelloWorldRestUnitTests {

    IHelloWorldRest controller;

    @Before
    public void setup() {
        controller = new HelloWorldRest()
    }

    @Test
    public void sayHelloToKirk() throws Exception {
        def result = controller.greeting('Kirk')
        assert result instanceof HelloWorld
        assert result.content == 'Hello, Kirk!'
    }
}