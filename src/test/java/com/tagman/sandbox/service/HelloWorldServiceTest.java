package com.tagman.sandbox.service;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by antoine on 02/05/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class HelloWorldServiceTest {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloWorldServiceTest.class);
    private List<String> names;

    @Autowired
    private IHelloWorldService service;

    @Before
    public void prepare() {

        names = new ArrayList<String>();
        String inputUrl = getClass().getResource("user.input").getFile();
        File inputFile = new File(inputUrl);
        Scanner in;
        try {
            in = new Scanner(inputFile);
            while (in.hasNext()) {
                String name = in.nextLine();
                names.add(name);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Could not find resource file, {}", e.getMessage());
            Assert.assertTrue(false);
        }

    }

    @Test
    public void testUsersGreetings() {

        for (String name : names) {
            String greeting = service.greeting(name);
            Assert.assertEquals(greeting, "Hello " + name + " !");
        }
    }

    @Test
    public void testGreetings() {
        String greeting = service.greeting();
        Assert.assertEquals(greeting, "Hello World !");
    }

}
