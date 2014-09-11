package com.tasc.poc.test.unit.rest.helloworld

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

import com.tasc.poc.rest.IHelloWorldRest;
import com.tasc.poc.rest.impl.HelloWorldRest;
import com.tasc.poc.dto.HelloWorld;

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