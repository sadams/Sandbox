package com.tagman.sandbox.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by antoine on 02/05/14.
 */
@Service
public class HelloWorldService implements IHelloWorldService {

    private String greeting;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloWorldService.class);

    @Override public String greeting(String name) {
        LOGGER.info("Will return greeting for user {}", name);
        return "Hello " + name + " !";
    }

    @Override public String greeting() {
        LOGGER.info("Will return generic greeting");
        return greeting;
    }

    @Value("${sandbox.greetings}")
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }


}
